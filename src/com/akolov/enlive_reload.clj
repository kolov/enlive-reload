(ns com.akolov.enlive-reload)

(defn namespaces-with-templates []
  (filter #(:net.cgrand.reload/deps (meta %)) (all-ns)))

(defn namespased-to-watch [options]
  "Build a list of namespaces to watch from (possibly null) options"
  (if options (map find-ns options) (namespaces-with-templates)))

(defn dependent-files [^clojure.lang.Namespace ns]
  (->> ns meta :net.cgrand.reload/deps
       (map #(.getFile %))
       (map #(java.io.File. %))))

(defn files-and-times-map [namespaces]
  (zipmap namespaces
          (map
            (fn [ns] (let [files (dependent-files ns)
                           times (map #(.lastModified %) files)]
                       [files times]))
            namespaces))

  )

(defn changed-namespaces [old new]
  (println old new)
  (reduce (fn [acc [ns [new-files new-times]]]
            (let [[old-files old-times] (old ns)]
              (if (or (not= old-files new-files)
                      (not= old-times new-times))
                (conj acc ns)
                acc)))
          []
          new)
  )

(defn wrap-enlive-reload
  "Reload namespaces of modified enlive template files before the request is passed to the
  supplied handler.

  Accepts the following options:

  :namespaces - A list of namespaces to watch.
          Defaults to all namespaces having enlive templates"
  [handler & [options]]
  (let [namespaces (namespased-to-watch options)
        ftm (atom (files-and-times-map namespaces))
        ]
    (fn [request]
      (let [current (files-and-times-map namespaces)]
        (doseq [ns (changed-namespaces @ftm current)]
          (require (.getName ns) :reload))
        (handler request)))))

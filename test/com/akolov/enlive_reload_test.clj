(ns com.akolov.enlive-reload-test
  (:require [clojure.test :refer :all]
            [com.akolov.enlive-reload :refer :all]
            [net.cgrand.enlive-html :refer [deftemplate]]
            [midje.sweet :refer :all])

  )


(deftemplate test-template "t.html" [] [])

(def NS (find-ns 'com.akolov.enlive-reload-test))

(fact "finds namespaces with dependent files"
      (namespaces-with-templates) => [NS]
      )


(fact "finds file of a namespace"
      (map #(-> % .getAbsolutePath (.endsWith "/t.html"))
           (dependent-files NS)) => [true]
      )

(fact "bulds files and times"
      (let [result (files-and-times-map [NS])
            ks (keys result)
            vs (vals result)
            _ (println result)]
        ks => [NS]
        (-> vs first first first .getAbsolutePath (.endsWith "/t.html")) => true
        (-> vs first second first (> 1000)) => true
        )
      )

(fact wrap-reload-smoke-test
      (let [handler (wrap-enlive-reload identity)
            request {:http-method :get, :uri "/"}]
        (handler request) => request))

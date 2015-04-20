(defproject com.akolov.enlive-reload "0.2.1"
            :description "autoreloading for enlive"
            :url "http://kolov-it.com/automatic-reloading-enlive-templates/"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [enlive "1.1.5"]
                           [org.clojure/tools.logging "0.3.1"]
                           ]

            :profiles {
                       :dev {:dependencies [[midje "1.6.3"]
                                            [midje-junit-formatter "0.1.0-SNAPSHOT"]]

                             :plugins      [[lein-deps-tree "0.1.2"]
                                            [lein-midje "3.0.0"]
                                            [test2junit "1.0.1"]]}}
            )

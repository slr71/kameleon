(defproject org.cyverse/kameleon "3.0.7"
  :description "Library for interacting with backend relational databases."
  :url "https://github.com/cyverse-de/kameleon"
  :license {:name "BSD"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.logging "1.2.4"]
                 [clj-time "0.15.2"]
                 [com.mchange/c3p0 "0.9.5.5"]
                 [korma "0.4.3"
                  :exclusions [c3p0]]
                 [me.raynes/fs "1.4.6"]
                 [org.postgresql/postgresql "42.6.0"]
                 [com.impossibl.pgjdbc-ng/pgjdbc-ng "0.8.9"]
                 [slingshot "0.12.2"]]
  :plugins [[lein-ancient "0.7.0"]
            [lein-marginalia "0.7.1"]
            [test2junit "1.2.2"]
            [jonase/eastwood "0.2.3"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :eastwood {:exclude-namespaces [apps.protocols :test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]})

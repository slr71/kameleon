(defproject org.cyverse/kameleon "3.0.6-SNAPSHOT"
  :description "Library for interacting with backend relational databases."
  :url "https://github.com/cyverse-de/kameleon"
  :license {:name "BSD"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [clj-time "0.11.0"]
                 [com.mchange/c3p0 "0.9.5.1"]
                 [korma "0.4.2"
                  :exclusions [c3p0]]
                 [me.raynes/fs "1.4.6"]
                 [org.postgresql/postgresql "42.2.4"]
                 [com.impossibl.pgjdbc-ng/pgjdbc-ng "0.7.1"]
                 [slingshot "0.12.2"]]
  :plugins [[lein-marginalia "0.7.1"]
            [test2junit "1.2.2"]
            [jonase/eastwood "0.2.3"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :eastwood {:exclude-namespaces [apps.protocols :test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]})

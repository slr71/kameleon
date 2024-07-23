(defproject org.cyverse/kameleon "3.0.11-SNAPSHOT"
  :description "Library for interacting with backend relational databases."
  :url "https://github.com/cyverse-de/kameleon"
  :license {:name "BSD"
            :url "https://cyverse.org/license"}
  :dependencies [[org.clojure/clojure "1.11.3"]
                 [org.clojure/tools.logging "1.3.0"]
                 [clj-time "0.15.2"]
                 [com.mchange/c3p0 "0.10.1"]
                 [korma "0.4.3"
                  :exclusions [c3p0]]
                 [me.raynes/fs "1.4.6"]
                 [org.postgresql/postgresql "42.7.3"]
                 [com.impossibl.pgjdbc-ng/pgjdbc-ng "0.8.9"]
                 [slingshot "0.12.2"]]
  :plugins [[lein-ancient "0.7.0"]
            [lein-marginalia "0.9.2"]
            [test2junit "1.4.4"]
            [jonase/eastwood "1.4.3"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :eastwood {:exclude-namespaces [apps.protocols :test-paths]
             :linters [:wrong-arity :wrong-ns-form :wrong-pre-post :wrong-tag :misplaced-docstrings]})

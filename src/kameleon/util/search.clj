(ns kameleon.util.search
  (:require [clojure.string :as str]))

(defn format-query-wildcards
  [search-term]
  (str/replace (str/trim search-term) #"[%_*?]" {"%" "\\%",
                                                 "_" "\\_",
                                                 "*" "%",
                                                 "?" "_"}))

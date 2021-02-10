(ns kameleon.util.search
  (:require [clojure.string :as str]))

(defn format-query-wildcards
  [search-term] 
  stripped-term=> (clojure.string/trim search-term)
  (str/replace stripped-term #"[%_*?]" {"%" "\\%",
                                      "_" "\\_",
                                      "*" "%",
                                      "?" "_"}))

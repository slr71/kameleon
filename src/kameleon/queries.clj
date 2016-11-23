(ns kameleon.queries
  (:use [kameleon.core]
        [korma.core :exclude [update]]
        [korma.db :only [transaction]]
        [slingshot.slingshot :only [throw+]]))

(defn- version-table-exists?
  []
  (first
   (select :information_schema.tables
           (fields :table_name)
           (where {:table_name "version"}))))

(defn current-db-version
  "Determines the current database version."
  []
  (when (version-table-exists?)
    (-> (select :version
                (fields [:version])
                (order :version :DESC)
                (limit 1))
        ffirst
        val)))

(defn add-query-offset
  "Returns select_query with an OFFSET clause added if offset_val is 0 or more;
   otherwise the original select_query is returned."
  [select_query offset_val]
  (if (and offset_val (>= offset_val 0))
    (offset select_query offset_val)
    select_query))

(defn add-query-limit
  "Returns select_query with a LIMIT clause added if limit_val is more than 0;
   otherwise the original select_query is returned."
  [select_query limit_val]
  (if (and limit_val (> limit_val 0))
    (limit select_query limit_val)
    select_query))

(defn add-query-sorting
  "Returns select_query with an ORDER BY clause added if sort-field is not nil;
   otherwise the original select_query is returned."
  [select_query sort-field sort-dir]
  (if (not (nil? sort-field))
    (let [sort-dir (if (= sort-dir :DESC)
                     sort-dir
                     :ASC)]
      (order select_query sort-field sort-dir))
    select_query))

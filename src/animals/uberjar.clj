(ns animals.uberjar
  (:require [animals.server :refer [start-server]])
  (:gen-class))

(defn -main [& args]
  (apply start-server args))

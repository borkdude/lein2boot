(ns animals.animals
  (:refer-clojure :exclude [read])
  (:require [animals.db :as db]))

(defn create!
  ([]
     (db/create! {:type :animal}))
  ([m]
     (db/create! (assoc m :type :animal))))

(defn read
  ([]
     (db/read :type :animal))
  ([id]
     (db/read id))
  ([k v]
     (db/read k v)))

(defn update!
  [id m]
  (db/update! id m))

(defn delete!
  [id]
  (db/delete! id))

(defn init
  []
  (println "initializing animals")
  (do
    (create! {:name    "Painted-snipe"
              :species "Rostratulidae"})

    (create! {:name    "Yellow-backed duiker"
              :species "Cephalophus silvicultor"})
    (create! {:name    "Aardwolf"
              :species "Proteles cristata"})
    (create! {:name    "Gnu"
              :species "Connochaetes gnou"})
    (create! {:name    "Curled octopus"
              :species "Eledone cirrhosa"})
    (create! {:name    "Horny toad"
              :species "Phrynosoma cornutum"})
    (create! {:name    "Dung beetle"
              :species "Scarabaeus sacer"})
    (create! {:name    "Atlantic salmon"
              :species "Salmo salar"})))

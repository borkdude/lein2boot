(ns animals.db
  (:refer-clojure :exclude [read]))

(defonce max-id (atom 0))

(defonce records (atom {}))

(defn next-id
  [] (swap! max-id inc))

(defn create!
  [m]
  (let [id (next-id)]
    (swap! records assoc id (assoc m :id id))
    id))

(defn read
  ([id]
     (get (deref records) id))
  ([k v]
     (filter #(= (get % k) v) (vals @records))))

(defn update!
  [id m]
  (swap! records
         #(if (% id)
            (update-in % [id] merge m)
            %)))

(defn delete!
  [id]
  (swap! records dissoc id))

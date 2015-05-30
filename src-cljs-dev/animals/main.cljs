(ns animals.main
  (:require
   [reagent.core :as reagent]
   [animals.crud :as crud]))

(enable-console-print!)

(defonce init
  (do (println "starting application") 
      (reagent/render [crud/animals]
                      (js/document.getElementById "app"))))

(defn fig-reload []
  (println "reloading reagent")
  (reagent/render [crud/animals]
                  (js/document.getElementById "app")))

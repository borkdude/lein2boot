(ns animals.main
  (:require
   [reagent.core :as reagent]
   [animals.crud :as crud]))

;; no println output in production code
(set! cljs.core/*print-fn* identity)

(reagent/render [crud/animals]
                (js/document.getElementById "app"))

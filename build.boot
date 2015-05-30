(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring-server "0.4.0"]
                 [org.webjars/bootstrap "3.2.0"]
                 [cljs-http "0.1.30"]
                 [compojure "1.3.4"]
                 [liberator "0.13"]
                 [fogus/ring-edn "0.2.0"]
                 [clj-json "0.5.3"]
                 [reagent "0.5.0"]
                 [prismatic/schema "0.4.3"]
                 [adzerk/boot-cljs "0.0-3269-2" :scope "test"]
                 [adzerk/boot-cljs-repl "0.1.9" :scope "test"]
                 [adzerk/boot-reload "0.2.6" :scope "test"]
                 ])

(require '[adzerk.boot-cljs :refer :all])
(require '[adzerk.boot-cljs-repl :refer :all])
(require '[adzerk.boot-reload :refer :all])

(task-options!
 repl {:init-ns 'animals.repl})

(deftask dev-cljs []
  (set-env!
   :source-paths #{"src-cljs" "src-cljs-dev"})
  (comp
   (watch)
   (cljs-repl)
   (cljs :compiler-options {:output-to "resources/public/crud.js"
                            :output-dir "resources/public/out"
                            :optimizations :none
                            :asset-path "out"
                            :main "animals.main"
                            :source-map true})
   (reload :on-jsload 'animals.main/fig-reload)))

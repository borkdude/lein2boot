(set-env!
 :source-paths #{"src" "src-cljs"}
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
                 [pandeiro/boot-http "0.6.3-SNAPSHOT" :scope "test"]
                 ])

(require '[adzerk.boot-cljs :refer :all])
(require '[adzerk.boot-cljs-repl :refer :all])
(require '[adzerk.boot-reload :refer :all])
(require '[adzerk.boot-reload :refer :all])
(require '[pandeiro.boot-http :refer :all])
(require '[animals.api])

(task-options!
 repl {:init-ns 'animals.server})

;; the following causes an error in the jar task:
;; see: https://github.com/boot-clj/boot/issues/218
;; (alter-var-root (var *print-length*) (fn [v] 20))

(deftask dev []
  (set-env!
   :source-paths #(conj % "src-cljs-dev"))
  (comp
   (serve :handler 'animals.api/handler
          :reload true
          :dir "target/"
          :init 'animals.api/init)
   (watch)
   (reload :on-jsload 'animals.main/fig-reload)
   (cljs-repl)
   (cljs)))

(deftask build-cljs []
  (set-env!
   :source-paths #(conj % "src-cljs-prod"))
  (cljs :optimizations :advanced))

(deftask build []
  (comp
   (build-cljs)
   (aot :namespace '#{animals.uberjar})
   (pom :project 'animals
        :version "1.0.0")
   (uber)
   (jar :main 'animals.uberjar)))

(defproject animals-crud "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
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
                 [prismatic/schema "0.4.3"]]

  :plugins [[lein-cljsbuild "1.0.5"]]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/out"]

  :source-paths ["src"]

  :profiles {:dev {:plugins [[lein-figwheel "0.3.1"]]
                   :figwheel {:http-server-root "public"
                              :port 3449}}}

  :cljsbuild {:builds [{:id "reagent"
                        :source-paths ["src-cljs"]
                        :figwheel true
                        :compiler {:output-to "resources/public/crud.js"
                                   :output-dir "resources/public/out"
                                   :optimizations :none
                                   :asset-path "out"
                                   :main "animals.crud"
                                   :source-map true}}]}

  :repl-options {:init-ns animals.repl}
  
  :global-vars {*print-length* 20})

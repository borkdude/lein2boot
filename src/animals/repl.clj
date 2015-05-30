(ns animals.repl
  (:require [ring.server.standalone :refer [serve]])
  (:require [animals.api :refer [handler init]]))

(defonce server (atom nil))

(defn start-server
  "used for starting the server in development mode from REPL"
  [& [port]]
  (let [port (if port (Integer/parseInt port) 8080)]
    (reset! server
            (serve #'handler
                   {:port port
                    :init init
                    :auto-reload? true                    
                    :join true
                    :open-browser? false}))
    (println (str "You can view the site at http://localhost:" port))))

(defn stop-server []
  (.stop @server)
  (reset! server nil))

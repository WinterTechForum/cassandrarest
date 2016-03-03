(ns cassandrarest.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]])
  (:gen-class))

(defresource bar-resource [id]
             :allowed-methods [:get :put]
             :available-media-types ["text/html"]
             :handle-ok (fn [ctx]
                          (if-not (nil? id)
                            (format "<html>ID is: %s" id)
                            "Called with no params")))

(defroutes app
           (ANY "/foo" [] (resource :available-media-types ["text/html"]
                                    :handle-ok (fn [ctx]
                                                 (format "<html>It's %d milliseconds since the beginning of the epoch."
                                                         (System/currentTimeMillis)))))
           (ANY "/bar" [] (bar-resource))
           (ANY "/bar/:id" [id] (bar-resource id))
           (ANY "/xxx" [] (resource :available-media-types ["text/html"]
                                    :handle-ok (fn [ctx]
                                                 (format "<html>ctx: %s" ctx)))))



(def handler
  (-> app
      wrap-params))

;(defn -main
;  )

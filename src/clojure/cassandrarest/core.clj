(ns cassandrarest.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]]
            [clojure.data.json :as json])
  (:use [ring.server.standalone])
  (:gen-class))

(defn get-yapper []
  (cassandrarest.CassandraYapper. "104.197.18.138"))

(defn get-data []
  (.getData (get-yapper)))

(defresource get-data-resource
             :allowed-methods [:get]
             :available-media-types ["text/json"]
             :handle-ok (fn [ctx]
                          (let [data (get-data)]
                            (json/write-str (get-data)))))

(defresource put-data [key value]
             :allowed-methods [:put]
             :available-media-types ["text/json"]
             :handle-ok (fn [ctx]
                          (json/write-str {:key key :value value})))

(defroutes app
           (ANY "/get-data" [] get-data-resource)
           (ANY "/put-data/:key/:value" [key value] (put-data key value)))




(def handler
  (-> app
      wrap-params))

(defn -main []
  (serve cassandrarest.core/handler))


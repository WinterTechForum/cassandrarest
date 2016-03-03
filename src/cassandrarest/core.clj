(ns cassandrarest.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]]
            [clojure.data.json :as json])
  (:gen-class))

(defn get-data []
  {:a 1 :b 2 :c 3 :d 4})

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


(defproject cassandrarest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler cassandrarest.core/handler}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.3.4"]
                 [ring/ring-core "1.2.1"]
                 [liberator "0.14.0"]
                 [org.clojure/data.json "0.2.6"]
                 [com.datastax.cassandra/cassandra-driver-core "2.0.2"]
                 [ring-server "0.4.0"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :main ^:skip-aot cassandrarest.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

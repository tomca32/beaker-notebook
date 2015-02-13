(defproject bunsen.provisioner "0.1.0-SNAPSHOT"
  :description "bunsen provisioner service"
  :url "https://github.com/twosigma/bunsen"
  :main bunsen.provisioner.service
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/algo.generic "0.1.2"]
                 [com.stuartsierra/component "0.2.2"]
                 [ring "1.3.1"]
                 [bidi "1.18.0" :exclusions [org.clojure/clojure]]
                 [liberator "0.12.1"]
                 [clj-http "1.0.0"]
                 [com.cemerick/url "0.1.1"]
                 [ring/ring-json "0.3.1"]
                 [environ "1.0.0"]
                 [pandect "0.5.1"]]
  :plugins [[lein-environ "1.0.0"]]
  :test-paths ["src/test"]
  :source-paths ["src/main"]
  :jvm-opts  ["-Xmx256M"]
  :profiles {:uberjar {:aot [bunsen.provisioner.service]}
             :dev {:env {:server-port 3001
                         :bamboo-url "http://10.10.10.10:8000"
                         :marathon-url "http://10.10.10.10:8080"
                         :app-group "/bunsen-dev/beaker"
                         :app-template-path "resources/templates/app.json"
                         :service-host "localhost"
                         :service-path "/beaker"}
                   :repl-options {:init (user/watch)}
                   :source-paths ["src/dev"]
                   :dependencies [[hawk "0.1.1"]
                                  [ring-mock "0.1.5"]
                                  [org.clojure/tools.namespace "0.2.7"]]}
             :test {:env {:server-port 6001}}}
  :aliases {"build" ["do" ["clean"] ["uberjar"]]})

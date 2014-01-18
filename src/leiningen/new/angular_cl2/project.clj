(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "{{description}}"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :node-dependencies []
  :nodejs {:keywords ["chlorinejs",
                      "clojure",
                      "macro",
                      "angular",
                      "qunit",
                      "bootstrap"]
           :devDependencies {:angular-cl2 "0.3.3-SNAPSHOT",
                             :less "~1.4.0"
                             :testem "0.6.2"}
           :scripts {:testem "testem ci"}}
  :plugins [[lein-cl2c "0.0.1-SNAPSHOT"]
            [lein-bower "0.2.0"]
            [lein-npm "0.2.0"]]
  :bower {:directory "resources/public/vendor"}
  :bower-dependencies [[sockjs "~0.3.4"]
                       [angular "~1.2.9"]
                       [angular-route "~1.2.9"]
                       [angular-xeditable  "~0.1.8"]
                       [bootstrap "~3.0.3"]]
  :cl2c {:prod
         {:watch ["src-cl2", "test-cl2"]
          :filter "src-cl2/"
          :path-map ["src-cl2/" => "resources/public/"]
          :paths ["node_modules/"]
          :strategy "prod"
          ;; some files may take too long to compile. We need a limit
          :timeout 2000
          }
         :dev
         {:watch ["src-cl2", "test-cl2"]
          :filter (or "test-cl2/test_runner.cl2"
                      (and "test-cl2/" ".hic"))
          :paths ["node_modules/" "src-cl2/"]
          :strategy "dev"
          ;; some files may take too long to compile. We need a limit
          :timeout 2000
          }})

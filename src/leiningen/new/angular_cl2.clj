(ns leiningen.new.angular-cl2
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files year]]
            [leiningen.core.main :as main]))

(def render (renderer "angular-cl2"))

(defn angular-cl2
  "Create new Angular-cl2 project"
  [name]
  (let [data {:name name
              :description
              "An Angular web app designed to ... well, that part is up to you."
              :year (year)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' angular-cl2 project.")
    (->files data
             ["src-cl2/core.cl2" (render "src-cl2/core.cl2")]
             ["src-cl2/index.hic" (render "src-cl2/index.hic")]
             ["src-cl2/partials/default.hic"
              (render "src-cl2/partials/default.hic")]
             ["test-cl2/test_runner.cl2"
              (render "test-cl2/test_runner.cl2")]
             ["test-cl2/test.hic" (render "test-cl2/test.hic")]
             ["test-cl2/core_tests.cl2"
              (render "test-cl2/core_tests.cl2")]
             ["testem.yml" (render "testem.yml")]

             [".gitignore" (render "gitignore")]

             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)])))

(def project 'natureofcode)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :dependencies '[[org.clojure/clojure "RELEASE"]
                          [quil "2.6.0"]])

(task-options!
 aot {:namespace #{'natureofcode.core}}
 pom {:project project
      :version version
      :license {:name "MIT License"
                :url "https://opensource.org/licenses/MIT"}})

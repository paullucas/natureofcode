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
                :url "https://opensource.org/licenses/MIT"}}
 jar {:main 'natureofcode.core
      :file (str "natureofcode-" version "-standalone.jar")})

(deftask build
  "Build the project locally as a JAR."
  [d dir PATH #{str} "the set of directories to write to (target)."]
  (let [dir (if (seq dir) dir #{"target"})]
    (comp (aot) (pom) (uber) (jar) (target :dir dir))))

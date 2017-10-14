(ns natureofcode.i-3.walker
  (:require [natureofcode.core :refer [width height]]
            [natureofcode.i-1.walker :refer [step!]]
            [quil.core :as q]))

(defn pull-walker [walker]
  (let [choice (rand-int 100)]
    (cond (< choice 40) (step! walker :x inc width)
          (< choice 60) (step! walker :x dec width)
          (< choice 80) (step! walker :y inc height)
          :else (step! walker :y dec height))))

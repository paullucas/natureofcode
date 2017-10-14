(ns natureofcode.i-1.walker
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn step! [walker axis mod-fn max-val]
  (swap! walker update-in [axis]
         (fn [value]
           (-> value
               mod-fn
               (q/constrain-float 0 (- max-val 1))))))

(defn step-walker [walker]
  (case (rand-int 4)
    0 (step! walker :x inc width)
    1 (step! walker :x dec width)
    2 (step! walker :y inc height)
    3 (step! walker :y dec height)))

(defn render-walker [{x :x y :y}]
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/point x y))

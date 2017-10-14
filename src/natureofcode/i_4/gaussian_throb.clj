(ns natureofcode.i-4.gaussian-throb
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-4.gaussian :refer [gauss]]))

(defn draw []
  (q/background 255)
  (let [dist (gauss 10 100)]
    (q/fill 0)
    (q/ellipse (/ width 2) (/ height 2) dist dist)))

(defn run []
  (q/defsketch gaussian-throb
    :draw draw
    :size [width height]))

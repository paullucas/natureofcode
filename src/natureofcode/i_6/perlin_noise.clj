(ns natureofcode.i-6.perlin-noise
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn setup []
  (def t (atom 0)))

(defn draw []
  (q/background 0)
  (q/fill 255)

  (-> (swap! t #(+ % 0.01))
      q/noise
      (q/map-range 0 1 0 width)
      (q/ellipse (/ height 2) 40 40)))

(defn run []
  (q/defsketch perlin-noise
    :setup setup
    :draw draw
    :size [width height]))

(ns natureofcode.i-2.random-distribution
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(def random-counts (atom (vec (replicate 20 0))))

(defn draw-rect [rel-width index val]
  (q/rect (* index rel-width) (- height val) (- rel-width 1) val))

(defn draw []
  (q/background 255)

  (let [index (rand-int (count @random-counts))]
    (swap! random-counts update-in [index] inc))

  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 127)

  (let [rel-width (/ width (count @random-counts))
        draw-fn (partial draw-rect rel-width)]
    (dorun (map-indexed draw-fn @random-counts))))

(defn run []
  (q/defsketch random-distribution
    :draw draw
    :setup setup
    :size [width height]))

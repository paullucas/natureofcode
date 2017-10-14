(ns natureofcode.i-5.accept-reject-distribution
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-2.random-distribution :refer [draw-rect]]))

(defn accept-reject []
  (let [r1 (rand)
        r2 (rand)
        y (* r1 r1)]
    (if (< r2 y)
      r1
      (recur))))

(defn setup []
  (def random-counts (atom (vec (replicate 20 0)))))

(defn draw []
  (q/background 255)

  (let [index (int (* (accept-reject) (count @random-counts)))]
    (swap! random-counts update-in [index] inc))

  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 127)

  (let [rel-width (/ width (count @random-counts))
        draw-fn (partial draw-rect rel-width)]
    (dorun (map-indexed draw-fn @random-counts))))

(defn run []
  (q/defsketch accept-reject-distribution
    :setup setup
    :draw draw
    :size [width height]))

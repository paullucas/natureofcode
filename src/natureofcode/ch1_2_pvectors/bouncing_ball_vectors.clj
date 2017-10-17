(ns natureofcode.ch1-2-pvectors.bouncing-ball-vectors
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn setup []
  (q/background 255)
  (def b (atom {:location [(/ width 2) (/ height 2)]
                :velocity [2.5 -2]})))

(defn apply-velocity [ball]
  (->> (map + (:location @ball) (:velocity @ball))
       (swap! ball assoc-in [:location])))

(defn bounce-ball [ball]
  (let [[x y] (:location @ball)
        [vx vy] (:velocity @ball)]
    (when (or (> x width)
              (< x 0))
      (swap! ball update-in [:velocity] #(mapv * % [-1 1])))
    (when (or (> y height)
              (< y 0))
      (swap! ball update-in [:velocity] #(mapv * % [1 -1])))))

(defn render-ball [ball]
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 175)
  (let [[x y] (:location @ball)]
    (q/ellipse x y 40 40)))

(defn draw []
  (apply-velocity b)
  (bounce-ball b)
  (render-ball b))

(defn run []
  (q/defsketch bouncing-ball-vectors
    :setup setup
    :draw draw
    :size [width height]))

(ns natureofcode.ch1-2-pvectors.bouncing-ball-pvectors
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]])
  (:import [processing.core PVector]))

(defn setup []
  (q/background 255)
  (def ball (atom {:location (new PVector (/ width 2) (/ height 2))
                   :velocity (new PVector 2.5 -2)})))

(defn move-ball [ball]
  (.add (:location ball) (:velocity ball)))

(defn bounce-ball [pvec]
  (let [loc (:location @pvec)
        vel (:velocity @pvec)]
    (when (or (> (.x loc) width)
              (< (.x vel) 0))
      (set! (.x vel) (* -1 (.x vel))))
    (when (or (> (.y loc) height)
              (< (.y vec) 0))
      (set! (.y vel) (* -1 (.y vel))))))

(defn render-ball [pvec]
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 175)
  (let [loc (:location @pvec)]
    (q/ellipse (.x loc) (.y loc) 40 40)))

(defn draw []
  (move-ball @ball)
  (bounce-ball ball)
  (render-ball ball))

(defn run []
  (q/defsketch bouncing-ball-pvectors
    :setup setup
    :draw draw
    :size [width height]))

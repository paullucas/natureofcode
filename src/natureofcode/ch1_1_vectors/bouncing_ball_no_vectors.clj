(ns natureofcode.ch1-1-vectors.bouncing-ball-no-vectors
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn setup []
  (q/background 255)
  (def state (atom {:x 100
                    :y 100
                    :speed-x 1
                    :speed-y 3.3})))

(defn move-coord [state key speed]
  (swap! state update-in [key] #(+ % (speed @state))))

(defn change-speed [state max-val coord speed]
  (when (or (> (get @state coord) max-val)
            (< (get @state coord) 0))
    (swap! state update-in [speed] #(* % -1))))

(defn bounce-ball [state]
  (move-coord state :x :speed-x)
  (move-coord state :y :speed-y)
  (change-speed state width :x :speed-x)
  (change-speed state height :y :speed-y))

(defn render-ball [state]
  (q/stroke 0)
  (q/fill 175)
  (q/ellipse (:x state) (:y state) 40 40))

(defn draw []
  (bounce-ball state)
  (render-ball @state))

(defn run []
  (q/defsketch bouncing-ball-no-vectors
    :setup setup
    :draw draw
    :size [width height]))

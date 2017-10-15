(ns natureofcode.i-6.perlin-walker
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn step-time! [walker key map-max]
  (-> (swap! walker update-in [key] #(+ % 0.01))
      key
      q/noise
      (q/map-range 0 1 0 map-max)))

(defn step-walker! [walker]
  (let [t-x (step-time! walker :time-x height)
        t-y (step-time! walker :time-y width)]
    (swap! walker update-in [:x] (fn [_] t-x))
    (swap! walker update-in [:y] (fn [_] t-y))))

(defn render-walker [walker]
  (q/fill 255)
  (q/ellipse (:x walker) (:y walker) 40 40))

(defn setup []
  (q/frame-rate 60)
  (q/background 0)
  (q/smooth)
  (def wlkr (atom {:x (/ width 2.0)
                   :y (/ height 2.0)
                   :time-x 0
                   :time-y 10000})))

(defn draw []
  (step-walker! wlkr)
  (render-walker @wlkr))

(defn run []
  (q/defsketch perlin-walker
    :setup setup
    :draw draw
    :size [width height]))

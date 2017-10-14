(ns natureofcode.i-1.walker-tends-to-down-right
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-1.walker :as w]))

(def wlkr (atom {:x (/ width 2.0)
                 :y (/ height 2.0)}))

(defn setup []
  (q/frame-rate 60)
  (q/background 255)
  (q/smooth))

(defn draw []
  (w/step-walker wlkr)
  (w/render-walker @wlkr))

(defn run []
  (q/defsketch walker-tends-to-down-right
    :setup setup
    :draw draw
    :size [width height]))

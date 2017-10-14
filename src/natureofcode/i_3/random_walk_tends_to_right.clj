(ns natureofcode.i-3.random-walk-tends-to-right
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-1.walker :refer [render-walker]]
            [natureofcode.i-3.walker :refer [pull-walker]]))

(def wlkr (atom {:x (/ width 2.0)
                 :y (/ height 2.0)}))

(defn setup []
  (q/frame-rate 60)
  (q/background 255)
  (q/smooth))

(defn draw []
  (pull-walker wlkr)
  (render-walker @wlkr))

(defn run []
  (q/defsketch random-walk-tends-to-right
    :setup setup
    :draw draw
    :size [width height]))

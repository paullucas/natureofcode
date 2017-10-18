(ns natureofcode.ch1-3-vector-math.subtraction
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn draw []
  (q/background 255)
  (q/stroke-weight 2)
  (q/stroke 0)
  (q/no-fill)

  (q/translate (/ width 2) (/ height 2))
  (q/ellipse 0 0 4 4)

  (let [mouse [(q/mouse-x) (q/mouse-y)]
        center [(/ width 2) (/ height 2)]
        [x y] (map - mouse center)]
    (q/line 0 0 x y)))


(defn run []
  (q/defsketch subtraction
    :draw draw
    :size [width height]))

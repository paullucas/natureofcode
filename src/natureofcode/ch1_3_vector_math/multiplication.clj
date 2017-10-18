(ns natureofcode.ch1-3-vector-math.multiplication
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
        subbed (map - mouse center)
        [x y] (map * subbed (repeat 5))]
    (q/line 0 0 x y)))

(defn run []
  (q/defsketch multiplication
    :draw draw
    :size [width height]))

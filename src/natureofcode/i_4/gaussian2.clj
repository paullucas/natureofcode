(ns natureofcode.i-4.gaussian2
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-4.gaussian :refer [gauss]]))

(defn setup []
  (q/frame-rate 60)
  (q/background 0)
  (q/smooth))

(defn gauss-rgb [std-dev mean]
  (-> (gauss std-dev mean)
      (q/constrain 0 255)))

(defn draw []
  (q/fill 0 1)
  (q/rect 0 0 width height)

  (let [r (gauss-rgb 100 100)
        g (gauss-rgb 20 200)
        b (gauss-rgb 50 0)

        pos-std-dev (/ width 10)
        pos-mean (/ width 2)
        xloc (gauss pos-std-dev pos-mean)
        yloc (gauss pos-std-dev pos-mean)]

    (q/no-stroke)
    (q/fill r g b)
    (q/ellipse xloc yloc 8 8)))

(defn run []
  (q/defsketch gaussian2
    :setup setup
    :draw draw
    :size [width height]))

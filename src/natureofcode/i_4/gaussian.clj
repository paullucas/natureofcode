(ns natureofcode.i-4.gaussian
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]))

(defn setup []
  (q/frame-rate 60)
  (q/background 255)
  (q/smooth))

(defn gauss [std-dev mean]
  (-> (q/random-gaussian)
      (* std-dev)
      (+ mean)))

(defn draw []
  (let [std-dev 60
        ;; std-dev 480
        mean (/ width 2)
        dist (gauss std-dev mean)]
    (q/fill 0 10)
    (q/no-stroke)
    ;; (dorun
    ;;  (for [x (range 1 96)]
    ;;    (q/ellipse dist (* 11.25 x) 16 16)))
    (q/ellipse dist (/ height 2) 16 16)))

(defn run []
  (q/defsketch gaussian
    :setup setup
    :draw draw
    :size [width height]))

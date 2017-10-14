(ns natureofcode.i-5.random-walk-levy
  (:require [quil.core :as q]
            [natureofcode.core :refer [width height]]
            [natureofcode.i-1.walker :refer [step!]]))

(defn monte-carlo []
  (let [r1 (rand)
        r2 (rand)
        probability (q/pow (- 1.0 r1) 8)]
    (if (< r2 probability)
      r1
      (recur))))

(defn step-walker [walker]
  (swap! walker update-in [:prev-x] (fn [_] (:x @walker)))
  (swap! walker update-in [:prev-y] (fn [_] (:y @walker)))

  (let [step-size (* 50 (monte-carlo))
        step-fn (fn [val]
                  (->> (- (rand 2) 1)
                       (* step-size)
                       (+ val)))]

    (step! walker :x step-fn width)
    (step! walker :y step-fn height)))

(defn render-walker [walker]
  (q/stroke 255)
  (q/line (:prev-x walker)
          (:prev-y walker)
          (:x walker)
          (:y walker)))

(defn setup []
  (q/frame-rate 60)
  (q/background 0)
  (q/smooth)
  (def wlkr (atom {:x (/ width 2.0)
                   :y (/ height 2.0)
                   :prev-x nil
                   :prev-y nil})))

(defn draw []
  (step-walker wlkr)
  (render-walker @wlkr))

(defn run []
  (q/defsketch random-walk-levy
    :setup setup
    :draw draw
    :size [width height]))

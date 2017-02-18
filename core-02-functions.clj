(ns clojuredistilled.functions)

;; Functions

;; Anonymous Functions
((fn [arg] (println arg)) "hello")

#(println %)
(#(println %1 %2) "hello" "world")

;; Named Functions

(def times2
  (fn [x] (* 2 x)))

(times2 4)

(defn square [x]
  (* x x))
(square 4)

(defn bmi [h w]
  (println "height: " h)
  (println "weight: " w)
  (/ w (* h h)))

(println (bmi 184 104))

;; Declare Macro
(declare down)

(defn up [n]
  (if (< n 10)
    (down (+ 2 n)) n))

(defn down [n]
  (up (dec n)))

(up 4)


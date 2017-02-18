(ns clojuredistilled.dynamicvariables)

;; Dynamic Variables
(declare ^{:dynamic true} *foo*)

(println *foo*)


(defn with-foo [f]
  (binding [*foo* "I exist!"]
    (f)))

(with-foo #(println *foo*))

(ns clojuredistilled.threadingexpressions)

;; Threading Expressions

(reduce + (interpose 5 (map inc (range 10))))

(interpose 5 [1 2 3 4 5])

;; ->> pass as last argument (-> as first argument)
(->> (range 10) (map inc) (interpose 5) (reduce +))

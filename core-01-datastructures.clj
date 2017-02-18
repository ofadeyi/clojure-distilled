(ns clojuredistilled.datastructures)

;; Data structures

;; Lists
(list 1 2 3)
(quote (1 2 3))

;; Vectors
[1 2 3]

;; Maps
{:foo "a" :bar "b"}
(array-map :foo "a" :bar "b")
(hash-map :foo "a" :bar "b")

;; Sets
(type #{1 2 3})
(hash-set "a" "b" "c")

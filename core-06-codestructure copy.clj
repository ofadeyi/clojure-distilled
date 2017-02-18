(ns clojuredistilled.codestructure)

;; Code Structure
(println
  (filter #(= (mod % 2) 0)
          (map #(* % %) (range 1 6))))

;; with threading
(->> (range 1 6)
     (map #(* % %))
     (filter #(= (mod % 2) 0))
     println)

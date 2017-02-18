(ns clojuredistilled.higherorderfunctions)

;; Higher-Order Functions

;; Map
(map #(* % %) [1 2 3 4 5])

;; Imperative style loop
(loop [[n & numbers] [1 2 3 4 5]
       result []]
  (let [result (conj result (* n n))]
    (if numbers
      (recur numbers result)
      result)))

;; Filter
(filter even? [1 2 3 4 5])

;; Higher-Order Functions chaining
(filter even?
        (map #(* 3 %) [1 2 3 4 5]))



;; Example

(defn concat-fields [& fields]
  (clojure.string/join ", " (remove empty? fields)))

(concat-fields "" "1 Main street" "Toronto" nil "Canada")
(concat-fields)
(concat-fields nil)
(concat-fields "")

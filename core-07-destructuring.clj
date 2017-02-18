(ns clojuredistilled.destructuring)

;; Destructuring

;; Let binding
(let [[smaller bigger] (split-with #(< % 5) (range 10))]
  (println smaller bigger))


;; Functions parameters
(defn print-user [[name address phone]]
  (println name "-" address phone))

(print-user ["John doe" "1 Kings Street, London" "00441234567890"])
(print-user ["John doe" "1 Kings Street, London" "00441234567890" "UK"])

;; Varargs

(defn print-args [& args]
  (println args))

(print-args "a" "b" "c")


;; Split Varargs
(defn print-args [arg1 & [arg2]]
  (println
    (if arg2
      "got two arguments"
      "got one argument")))

(print-args "bar")
(print-args "bar" "baz")
(print-args "bar" "baz" "foo")

;; Maps
(let [{foo :foo bar :bar} {:foo "Foo" :bar "Bar"}]
  (println foo bar))

;; Data Structures
(let [{[a b c] :items id :id} {:id "foo" :items [1 2 3]}]
  (println id "->" a b c))

;; Maps with syntactic sugar
(defn login [{:keys [user pass]}]
  (and (= user "bob") (= pass "secret")))

(login {:user "bob" :pass "secret"})
(login {:user "john" :pass "secret"})

;; With alias
(defn register [{:keys [id pass repeat-pass] :as user}]
  (cond
    (nil? id) "user id is required"
    (not= pass repeat-pass) "re-entered password doesn't match"
    :else user))

(register {:id "bob", :pass "secret", :repeat-pass "secret", :full-name "Bob Doe", :age 32})
(register {:id "bob", :pass "secret", :repeat-pass "sacret", :full-name "Bob Doe", :age 32})
(register {:pass "secret", :repeat-pass "secret", :full-name "Bob Doe", :age 32})

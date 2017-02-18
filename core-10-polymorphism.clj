(ns clojuredistilled.polymorphism)

;; Polymorphism

;; Multimethods
(defmulti area :shape)

(defmethod area :circle [{:keys [r]}]
  (* Math/PI r r))

(defmethod area :rectangle [{:keys [l w]}]
  (* l w))

(defmethod area :default [shape]
  (throw (Exception. (str "unrecognized shape: " shape))))

(area {:shape :circle :r 10})
(area {:shape :rectangle :l 5 :w 10})
(area {:shape :square :l 5 :w 5})

;; Multimethods: sophisticated keywords dispatch
(defmulti encounter
  (fn [x y] [(:role x) (:role y)]))

(defmethod encounter [:manager :boss] [x y]
  :promise-unrealistic-deadlines)

(defmethod encounter [:manager :developer] [x y]
  :demand-overtime)

(defmethod encounter [:developer :developer] [x y]
  :complain-about-poor-management)

(encounter {:role :manager} {:role :boss})
(encounter {:role :manager} {:role :developer})
(encounter {:role :developer} {:role :developer})

;; Protocols
(defprotocol Foo
  "Foo doc string"
  (bar [this b] "bar doc string")
  (baz [this] [this b] "baz doc string"))

(deftype Bar [data] Foo
  (bar [this param]
    (println data param))
  (baz [this]
    (println (class this)))
  (baz [this param]
    (println param)))

(let [b (Bar. "some data")]
  (.bar b "param")
  (.baz b)
  (.baz b "baz with param"))


;; Extend Protocols
(extend-protocol Foo String
  (bar [this param] (println this param)))

(bar "hello" "world")

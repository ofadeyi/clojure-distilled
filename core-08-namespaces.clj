(ns clojuredistilled.namespaces)

;; Namespaces

(ns colors)
(defn hex->rgb [[_ & rgb]]
    (map #(->> % (apply str "0x") (Long/decode))
         (partition 2 rgb)))

(defn hex-str [n]
  (-> (format "%2s" (Integer/toString n 16))
      (clojure.string/replace " " "0")))

(defn rgb->hex [color]
  (apply str "#" (map hex-str color)))

;; :use imports all
(ns myns
  (:use colors))

(hex->rgb "#33d24f")
(hex-str 210)
(rgb->hex [51 210 79])


;; :use import restricted
(ns myns1
  (:use [colors :only [rgb->hex]]))

(defn hex-str [c]
  (println "I don't do much yet"))

(rgb->hex [51 210 79])
(hex-str 79)
(hex->rgb "#33d24f")

;; :require
(ns myns3 (:require colors))

(colors/hex->rgb "#324a9b")
(colors/hex-str 210)
(colors/rgb->hex [51 210 79])

;; :require with alias
(ns myotherns
  (:require [colors :as c]))

(c/hex->rgb "#324a9b")
(c/hex-str 210)
(c/rgb->hex [51 210 79])

;; :require :refer imports all
(ns myns4
  (:require [colors :refer :all]))

(colors/hex->rgb "#33d24f")
(colors/hex-str 210)
(colors/rgb->hex [51 210 79])

;; :require :refer imports restricted
(ns myns5
  (:require [colors :refer [rgb->hex]]))
(defn hex-str [c]
  (println "I don't do much yet: in myns5"))

(colors/rgb->hex [51 210 79])
(hex-str 79)
(hex->rgb "#33d24f")

(ns clojuredistilled.callingjava)

;; Calling Java

;; Import statement
(ns myns
  (:import java.io.File))

;; Multi Package Import
(ns myns1
  (:import [java.io File FileInputStream FileOutputStream]))


;; Class Instantiation
(new File ".")
(File. ".")

;; Instance Method call
(let [f (File. ".")]
  (println (.getAbsolutePath f)))

;; Static Method/Variable call
(str File/separator "foo" File/separator "bar")

(Math/sqrt 256)


;; Multi method calls
(.getBytes (.getAbsolutePath (File. ".")))
(.. (File. ".") getAbsolutePath getBytes)

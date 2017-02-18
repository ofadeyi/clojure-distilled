(ns clojuredistilled.macros)

;; Without Macros
(def session (atom {:user "Bob"}))

(defn load-content []
  (if (:user @session)
    "Welcome back!"
    "please log in"))


(load-content)

;; Macros
(defmacro defprivate [name args & body]
  `(defn ~(symbol name) ~args
     (if (:user @session)
       (do ~@body)
       "please log in")))

;; MacroExpand-1
(macroexpand-1 '(defprivate foo [greeting] (println greeting)))

(clojure.core/defn foo [greeting]
  (if (:user (clojure.core/deref session))
    (do (println greeting))
    "please log in"))

(defprivate foo [message] (println message))

(foo "this message is private")

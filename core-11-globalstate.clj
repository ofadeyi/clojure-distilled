(ns clojuredistilled.globalstate)

;; Global State

;; Atom
(def global-val (atom nil))

;; Deref to read current value
(println (deref global-val))

;; Deref short-hand
(println @global-val)

;; Setting new values
(reset! global-val 10) (println @global-val)
(swap! global-val inc) (println @global-val)


;; Refs
(def names (ref []))

(dosync
  (ref-set names ["John"])
  (alter names #(if (not-empty %)
                  (conj % "Jane") %)))

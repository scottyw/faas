(ns openfaas-handler.core
  (:gen-class))

(defn- handle
  [in]
  (str "Hello from OpenFaas! You said: " in))

(defn -main
  [& _]
  (-> *in*
      slurp
      handle
      println))

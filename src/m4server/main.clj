(ns m4server.main
  (:gen-class :main true))

;;This is the main entry point for m4servers.
;;It's a good example of a shim-class, and
;;requires some arcane features to get things
;;working, since we're creating repls on other
;;threads.
(defn -main [& args]
  ;;clojure.set isn't imported by default, causing errors when
  ;;aot-compiling in some places.
  (require 'clojure.set)
  ;;if we don't use this, i.e. establish a root binding
  ;;for the *ns* var, we can't use in-ns later....
  ;;which leads to compile-time and run-time errors..
  (binding [*ns* *ns*]
    (println ["initializing m4"])
    (require 'm4server.core)
    (in-ns 'm4server.core)
    ;;if we don't use resolve, then we get compile-time aot
    ;;dependency on marathon.core.  This allows us to shim the
    ;;class.
    (println ["initializing nightlight server"])
    ((resolve 'm4server.core/run-server))))



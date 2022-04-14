(ns m4server.core
  (:require [nightlight.core]
            [marathon.core]))

;;we can use nightlight as an embedded repl pretty easily:

(defn run-server [& {:keys [port] :or {port 4000}}]
  (nightlight.core/start {:port port :main 'm4server.core}))


;;This should spool up an interactive repl exposed on the port.
;;note: in production, we can use env vars to determine user/password
;;or some other auth.  We probably would have an nginx proxy or something
;;to forward authenticated traffic; alternately we could just use ssh to
;;get a remote repl with M4 stuff loaded up.  One could envision a simple
;;client to do this and auth with pki.  We get a lot of jank with
;;remote storage / data at rest requirements.

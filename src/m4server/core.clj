(ns m4server.core
  (:require [nightlight.core]
            [m4server.patch]
            [marathon.core]))

(def noisy (atom true))
;;From Stuart Sierra's blog post, for catching otherwise "slient" exceptions
;;Since we're using multithreading and the like, and we don't want
;;exceptions to get silently swallowed
(let [out *out*]
  (Thread/setDefaultUncaughtExceptionHandler
   (reify Thread$UncaughtExceptionHandler
     (uncaughtException [_ thread ex]
       (when @noisy
         (binding [*out* out]
           (println ["Uncaught Exception on" (.getName thread) ex])))))))

;;temp modificatiton to spool up a simple http server.
(defn run-server [& {:keys [ip port] :or {port 4000 ip "0.0.0.0"}}]
  (println [:running-server])
  (nightlight.core/dev-start {:port port :main 'm4server.core :ip ip}))

;;This should spool up an interactive repl exposed on the port.
;;note: in production, we can use env vars to determine user/password
;;or some other auth.  We probably would have an nginx proxy or something
;;to forward authenticated traffic; alternately we could just use ssh to
;;get a remote repl with M4 stuff loaded up.  One could envision a simple
;;client to do this and auth with pki.  We get a lot of jank with
;;remote storage / data at rest requirements.

(defproject m4server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [nightlight "2.4.4" #_"2.4.5-SNAPSHOT"
                  :exclusions
                  [org.clojure/tools.cli
                   org.clojure/java.classpath
                   org.clojure/tools.reader
                   org.clojure/core.async
                   org.clojure/tools.analyzer.jvm
                   org.clojure/tools.analyzer
                   org.clojure/core.memoize
                   org.clojure/core.cache
                   org.clojure/data.priority-map
                   commons-codec]]
                 [marathon "4.2.3-SNAPSHOT"]]
  :profiles
  {:uberjar {;:aot  [marathon.main]
             :aot [m4server.main];~aot-order
             :main  m4server.main
             }}s
 #_#_ :plugins [[nightlight/lein-nightlight "2.4.4"]])

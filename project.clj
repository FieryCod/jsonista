(defproject alpha-prosoft/jsonista "0.2.8"
  :description "Clojure library for fast JSON encoding and decoding."
  :url "https://github.com/alpha-prosoft/jsonista"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v20.html"}
  :source-paths ["src/clj"]
  :resource-paths ["resources"]
  :javac-options ["-Xlint:unchecked" "-target" "1.8" "-source" "1.8"]
  :java-source-paths ["src/java"]
  :plugins [[lein-ancient "1.0.0-RC3"]
            [lein-codox "0.10.8"]
            [lein-jmh "0.3.0"]]
  :deploy-repositories [["releases" :clojars]]
  :codox {:source-uri "http://github.com/alpha-prosoft/jsonista/blob/master/{filepath}#L{line}"
          :output-path "doc"
          :metadata {:doc/format :markdown}}
  :dependencies [[com.fasterxml.jackson.core/jackson-core "2.15.2"]
                 [com.fasterxml.jackson.core/jackson-databind "2.15.2"]
                 [com.fasterxml.jackson.datatype/jackson-datatype-jsr310 "2.15.2"]]
  :profiles {:provided {:dependencies [[org.clojure/clojure "1.10.1"]]}
             :dev {:dependencies [[org.clojure/clojure "1.10.1"]
                                  [jmh-clojure/jmh-clojure "0.4.1"]
                                  [com.fasterxml.jackson.datatype/jackson-datatype-joda "2.15.2"]
                                  [cheshire "5.12.0"]
                                  [com.taoensso/nippy "3.2.0"]
                                  [org.clojure/data.json "2.4.0"]
                                  [com.cognitect/transit-clj "1.0.333"]
                                  [org.msgpack/msgpack-core "0.9.6"]
                                  [org.msgpack/jackson-dataformat-msgpack "0.9.6"
                                   :exclusions [com.fasterxml.jackson.core/jackson-databind]]
                                  [com.clojure-goes-fast/clj-async-profiler "1.0.5"]
                                  [criterium "0.4.6"]]
                   :global-vars {*warn-on-reflection* true}}
             :virgil {:plugins [[lein-virgil "0.1.9"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :jmh {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :perf {:jvm-opts ^:replace ["-server"
                                         "-Xmx4096m"
                                         "-Dclojure.compiler.direct-linking=true"]}}
  :aliases {"all" ["with-profile" "default:dev:default:dev,1.8:dev,1.9"]
            "perf" ["with-profile" "default,dev,perf"]
            "repl" ["with-profile" "default,dev,virgil" "repl"]})

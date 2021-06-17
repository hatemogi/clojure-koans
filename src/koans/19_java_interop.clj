(ns koans.19-java-interop
  (:require [koan-engine.core :refer :all]))

(meditations
  "네가 알던 것보다 더 많이 자바와 함께 해왔다"
  (= __ (class "warfare")) ; hint: try typing (javadoc "warfare") in the REPL

  "마침표로 자바 연동을 쉽고 직접적으로 한다"
  (= __ (.toUpperCase "select * from"))

  "그러나 인스턴스 메소드를 호출하는 것은 보통의 함수와는 매우 다르다"
  (= ["SELECT" "FROM" "WHERE"] (map ___ ["select" "from" "where"]))

  "객체를 생성하는 것은 없애기보다 어려울 지도 모른다"
  (= 10 (let [latch (java.util.concurrent.CountDownLatch. __)]
          (.getCount latch)))

  "정적 메소드는 나눗셈 부호(/)를 쓴다"
  (== __ (Math/pow 2 10)))

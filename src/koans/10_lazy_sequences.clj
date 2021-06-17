(ns koans.10-lazy-sequences
  (:require [koan-engine.core :refer :all]))

(meditations
  "시퀀스를 만드는 방법은 여러 가지다"
  (= __ (range 1 5))

  "범위는 기본적으로 0에서 시작한다"
  (= __ (range 5))

  "시퀀스가 클 때는 필요한 만큼만 가져오라"
  (= [0 1 2 3 4 5 6 7 8 9]
     (take __ (range 100)))

  "아니면, 필요 없는 만큼을 버리고 쓰라"
  (= [95 96 97 98 99]
     (drop __ (range 100)))

  "iterate로 무한 지연(lazy) 시퀀스를 만들 수 있다"
  (= __ (take 20 (iterate inc 0)))

  "반복이 핵심이다"
  (= [:a :a :a :a :a :a :a :a :a :a ]
     (repeat 10 __))

  "반복하기 위해 iterate를 쓸 수 있다"
  (= (repeat 100 :foo)
     (take 100 (iterate ___ :foo))))

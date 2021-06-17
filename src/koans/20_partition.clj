(ns koans.20-partition
  (:require [koan-engine.core :refer :all]))

(meditations
  "컬렉션을 쪼개려면 partition 함수를 쓸 수 있다"
  (= '((0 1) (2 3)) (__ 2 (range 4)))

  "그러나 n개 요소의 시퀀스를 구성하기에 충분하지 않는 경우에 주의하라"
  (= '(__) (partition 3 [:a :b :c :d :e]))

  "n개 요소보다 적은 시퀀스도 얻어내려면 partition-all 함수를 사용한다"
  (= __ (partition-all 3 (range 5)))

  "만약 필요하다면, 각각의 시퀀스에 오프셋(offset)을 줄 수 있다"
  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 __ (range 13)))

  "마지막 시퀀스에 패딩(padding)을 붙일 수 있다는 점도 고려하라"
  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [__] (range 7)))

  "그러나 패딩(padding)은 주어진 시퀀스 길이까지만 붙는다"
  (= '((0 1 2) (3 4 5) __) (partition 3 3 [:these :are "my" "words"] (range 7))))

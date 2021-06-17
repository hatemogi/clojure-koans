(ns koans.12-sequence-comprehensions
  (:require [koan-engine.core :refer :all]))

(meditations
  "시퀀스 반복문으로 각 요소를 한 심볼에 바인드 할 수 있다"
  (= __
     (for [x (range 6)]
       x))

  "그것으로 쉽게 매핑처럼 쓸 수 있다"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x))
          (range 6))
     (for [x (range 6)]
       __))

  "필터링도 마찬가지"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x __ :when (odd? x)]
       x))

  "매핑과 필터링을 조합하는 것도 간단하다"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x))
          (filter odd? (range 10)))
     (for [x (range 10) :when __]
       __))

  "바인딩 폼을 여러개 써서 복잡한 변환을 쉽게할 수 있다"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       __)))

(ns koans.16-atoms
  (:require [koan-engine.core :refer :all]))

(def atomic-clock (atom 0))

(meditations
  ;; "Atoms are like refs"
  "atom은 ref와 비슷하다"
  (= __ @atomic-clock)

  ;; "You can change at the swap meet"
  "swap!으로 바꿀 수 있다"
  (= __ (do
          (swap! atomic-clock inc)
          @atomic-clock))

  ;; "Keep taxes out of this: swapping requires no transaction"
  "swap!은 트랜잭션이 필요 없다"
  (= 5 (do
         __
         @atomic-clock))

  ;; "Any number of arguments might happen during a swap"
  "swap!의 함수에 전달인자를 여러개 줄 수 있다"
  (= __ (do
          (swap! atomic-clock + 1 2 3 4 5)
          @atomic-clock))

  ;; "Atomic atoms are atomic"
  "atom은 원자적(atomic)이다"
  (= __ (do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock))

  ;; "When your expectations are aligned with reality, things proceed that way"
  "너의 기대가 현실과 잘 어울어지면, 그대로 이뤄진다"
  (= :fin (do
            (compare-and-set! __ __ __)
            @atomic-clock)))

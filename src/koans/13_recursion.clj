(ns koans.13-recursion
  (:require [koan-engine.core :refer :all]))

(defn is-even? [n]
  (if (= n 0)
    __
    (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      __
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  __)

(defn factorial [n]
  __)

(meditations
  "재귀는 종료 기준으로 끝난다"
  (= true (is-even? 0))

  "그리고 그 종료 기준을 행해 다가가는 것으로 시작한다"
  (= false (is-even? 1))

  "너무 많은 스택 프레임이 필요한 경우, recur로 명시적인 꼬리재귀호출(tail call)이 필요하다"
  (= false (is-even-bigint? 100003N))

  "멀리 가지 않았다면 되돌아가기 쉽다"
  (= '(1) (recursive-reverse [1]))

  "더 걸어갈수록 힘들어지지만 말이다"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  "간단한 것들은 간단하게 드러날 것이다"
  (= 1 (factorial 1))

  "간단한 단계가 몇 번 더 필요할 때도 있다"
  (= 2 (factorial 2))

  "어떨 때는 조금 큰 조치가 필요하다"
  (= 6 (factorial 3))

  "그리고 결국은 열심히 생각해야만 한다"
  (= 24 (factorial 4))

  "매우 큰 숫자를 다룰 수도 있겠지만"
  (< 1000000000000000000000000N (factorial 1000N))

  "기계가 더 이상 받쳐주지 않을 때는 어떻게 할 것인가?"
  (< 1000000000000000000000000N (factorial 100003N)))

(ns koans.26-transducers
  (:require [koan-engine.core :refer :all]))

(def example-transducer
  (map inc))

(def transforms
  (comp (map inc)
     (filter even?)))

(meditations
 "인수를 하나만 사용한 시퀀스 작업(sequence operations)들은 종종 트렌스듀서를 반환한다"
 (= __
    (sequence example-transducer [1 2 3]))

 "시퀀스 작업들은 트렌스듀서로 합성가능하다"
 (= __
    (transduce transforms conj [1 2 3]))

 "즉시(eager) 적용 하거나"
 (= __
    (into [] transforms [1 2 3]))

 "게으르게(lazy) 적용 하거나"
 (= __
    (sequence transforms [1 2 3]))

 "트렌스듀서는 map 과 reduce 을 결합 할 수 있다"
 (= __
    (transduce transforms + [1 2 3])))

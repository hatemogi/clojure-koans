(ns koans.25-threading-macros
  (:require [koan-engine.core :refer :all]))

(def a-list
  '(1 2 3 4 5))

(def a-list-with-maps
  '({:a 1} {:a 2} {:a 3}))

(defn function-that-takes-a-map [map a b]
  (get map :a))

(defn function-that-takes-a-coll [a b coll]
  (map :a coll))

(meditations
 "더 읽기 쉬운 순차 작업을 위하여 thread first 를 사용할수 있다"
 (= __
    (-> {}
        (assoc :a 1)))

 "무자열을 사용할 때에도 고려할 수 있다"
 (= __
    (-> "Hello world"
        (str ", and moon")
        (str ", and stars")))

 "함수에 부분 적용할 인수가 더 없다면, 그냥 참조만 해도 된다"
 (= __
    (-> "String with a trailing space "
        clojure.string/trim))

 "스칼라값을 인수로 취하는 경우, 대부분 thread-first 를 사용 할 수 있다"
 (= __
    (-> {}
        (assoc :a 1)
        (assoc :b 2)
        (assoc :c {:d 4
                   :e 5})
        (update-in [:c :e] inc)
        (get-in [:c :e])))

 "이 패턴을 따르는 직접 작성한 함수 또한 사용할 수 있다"
 (= __
    (-> {}
        (assoc :a 1)
        (function-that-takes-a-map "hello" "there")))

 "->> 을 이용해서 thread last 를 사용할수 있다"
 (= __
    (->> [1 2 3]
         (map inc)))

 "컬렉션을 인수로 취하는 경우, 대부분의 thread-last 를 사용할수있다"
 (= __
    (->> a-list
         (map inc)
         (filter even?)
         (into [])
         (reduce +)))

 "이 패턴을 따르는 직접 작성한 함수 또한 사용할 수 있다"
 (= __
    (->> a-list-with-maps
         (function-that-takes-a-coll "hello" "there")
         (into []))))

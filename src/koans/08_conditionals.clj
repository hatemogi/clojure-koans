(ns koans.08-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
        :bicycling        "pretty fast"
        :jogging          "not super fast"
        :walking          "not fast at all"
        "is that even exercise?"))

(meditations
  "결정해야만 하는 일들이 많을 것이다"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  "어떤 결정에는 대안이 없다"
  (= __ (if (> 4 3)
          []))

  "그리고 그런 경우에는 아무 것도 남지 않기도 한다"
  (= __ (if (nil? 0)
          [:a :b :c]))

  "때로는 대안이 흥미로울 수 있다"
  (= :glory (if (not (empty? ()))
              :doom
              __))

  "그대 앞에 매우 다양한 길이 있다"
  (let [x 5]
    (= :your-road (cond (= x __) :road-not-taken
                        (= x __) :another-road-not-taken
                        :else __)))

  "아니, 어쩌면 그대의 운명은 이미 정해진 걸지도"
  (= 'doom (if-not (zero? __)
          'doom
          'more-doom))

  "비상시에는 빠르게 가야한다"
  (= "pretty fast"
     (explain-exercise-velocity __))

  "그러나 무얼 해야할지 모르겠다면 그 사실을 인정하라"
  (= __
     (explain-exercise-velocity :watching-tv)))

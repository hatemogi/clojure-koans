(ns koans.27-multimethods
  (:require [koan-engine.core :refer :all]))

(defmulti multimethod-without-args
 (fn [keyword-arg] keyword-arg))

(defmethod multimethod-without-args :first [_]
 (str "Hello, World!"))

(defmethod multimethod-without-args :second [_]
 (str "Hello there"))

(defmulti multimethod-with-args
 (fn [opt-one opt-two] opt-one))

(defmethod multimethod-with-args :path-one [_ opts]
 (:first-opt opts))

(defmethod multimethod-with-args :path-two [_ opts]
 (let [numbers (:second-opt opts)]
  (->> numbers
       (map inc)
       (reduce +))))

(defmethod multimethod-with-args :path-three [_])

(meditations
 "멀티메소드(multimethod) 디스패치하기 위한 하나이상의 인수를 취한다"
 (= __
    (multimethod-without-args :first))

 "defmethod 에서 _ 는 무시하는 값을 표현할때 사용한다"
 (= __
    (multimethod-without-args :second))

 "defmethod 에서 인수를 사용할 수 있다"
 (= __
    (multimethod-with-args :path-one {:first-opt 1
                                      :second-opt 2}))
 
 "이것은 우리가 각 메소드 구현에서 각기 다를 작업을 가능하게 한다"
 (= __
    (multimethod-with-args :path-two {:first-opt 1
                                      :second-opt [0 1 2]})))

(ns koans.24-macros
  (:require [koan-engine.core :refer :all]))

(defmacro hello [x]
  (str "Hello, " x))

(defmacro infix [form]
  (list (second form) (first form) (nth form 2)))

(defmacro infix-concise [form]
  `(~(second form) ; Note the syntax-quote (`) and unquote (~) characters!
    __
    __))

(defmacro recursive-infix [form]
  (cond (not (seq? form))
        __
        (= 1 (count form))
        `(recursive-infix ~(first form))
        :else
        (let [operator (second form)
              first-arg (first form)
              others __]
          `(~operator
            (recursive-infix ~first-arg)
            (recursive-infix ~others)))))

(meditations
  "매크로는 마치 컴파일 타임에 생성되는 함수 같다"
  (= __ (hello "Macros!"))

  "중위식(infix)도 가능할까?"
  (= __ (infix (9 + 1)))

  "기억하라, 이것들은 코드 변환에 지나지 않는다"
  (= __ (macroexpand '(infix (9 + 1))))

  "당신은 그보다 더 잘할 수 있다"
  (= '(* 10 2) (macroexpand '(infix-concise (10 * 2))))

  "항상 네가 바라는 대로 되는 건 아니다"
  (= '(+ 10 (2 * 3)) (macroexpand '(infix-concise (10 + (2 * 3)))))

  "재귀를 진짜로 이해하기 전까지는 재귀를 이해하지 못한 것이다"
  (= 36 (recursive-infix (10 + (2 * 3) + (4 * 5)))))

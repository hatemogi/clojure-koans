(ns koans.02-lists
  (:require [koan-engine.core :refer :all]))

(meditations
  "리스트는 함수나 인용된 형태로 표현할 수 있다"
  (= '(__ __ __ __ __) (list 1 2 3 4 5))

  "리스트는 클로저 시퀀스(sequences)이므로, 첫번째 값을 쉽게 읽을 수 있다"
  (= __ (first '(1 2 3 4 5)))

  "나머지 뒷부분을 접근하기도 쉽다"
  (= __ (rest '(1 2 3 4 5)))

  "너의 축복을 세어 보라"
  (= __ (count '(dracula dooku chocula)))

  "그 것들이 사라지기 전에"
  (= __ (count '()))

  "아무 것도 남지 않았을 때의 나머지는 빈 것이니라"
  (= __ (rest '(100)))

  "리스트 맨앞에 요소를 추가해서 만들기 쉽다"
  (= __ (cons :a '(:b :c :d :e)))

  "리스트 뒤에 요소를 합치는 것 역시 어렵지 않다"
  (= __ (conj '(:a :b :c :d) :e))

  "리스트를 스택처럼 쓰면서 맨 앞의 요소를 가져올 수 있다"
  (= __ (peek '(:a :b :c :d :e)))

  "아니면 그 나머지 값들도"
  (= __ (pop '(:a :b :c :d :e)))

  "그러나, 빈 것에서 꺼낼 때는 조심하라"
  (= __ (try
          (pop '())
          (catch IllegalStateException e
            "No dice!")))

  "나머지를 구하는 것은 그렇게 엄격하지 않다"
  (= __ (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))

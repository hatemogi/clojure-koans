(ns koans.18-quote
  (:require [koan-engine.core :refer :all]))


(meditations
  "평가하지 않기위하여 quote 으로 감싸라"
  (= (quote (1 2 3 4 5)) __)

  "quote 의 단축도 사용할 수 있다"
  (= (quote __) '(1 2 3 4 5))

  "심볼에도 quote 를 사용할 수 있다"
  (= __ (let [age 9] (quote age)))

  "Clojure가 함수를 호출하지 않아도, 데이터 컬렉션으로써 list 를 사용할 수 있다"
  (= (cons 1 (__ (2 3))) (list 1 2 3) (cons 1 [2 3]))

  "quote 는 단순히 최상위 레벨뿐만 아니라 모든 인수에 적용된다"
  (= (list 1 __) '(1 (+ 2 3)))

  "Syntax-quote (`) 도 일반 quote (') 과 유사하다"
  (= (list __ __ __) `(1 2 3) '(1 2 3))

  "Syntax-quote 구문 내에서 평가가 필요하면 Unquote (~) 를 이용해라"
  (= (list __ __) `(1 ~(+ 2 3)) '(1 5)))

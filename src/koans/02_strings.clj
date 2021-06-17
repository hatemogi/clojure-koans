(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as string]))

(meditations
  "문자열은 단지 큰 따옴표로 둘러쌓인 텍스트일 뿐이다"
  (= __ "hello")

  "그러나 큰 따옴표는 단지 더 깊은 것 위의 마법이다"
  (= __ (str 'world))

  "문자열을 만드는것 이상을 할수있고, 문자열에 함께 넣을 수 있다"
  (= "Cool right?" (str __ __))

  "특정 문자(Characters) 를 얻을수 있다"
  (= \C (get "Characters" __))

  "또는 문자 개수를 셀 수 있다"
  (= __ (count "Hello World"))

  "그러나 문자열과 문자는 같지 않다"
  (= __ (= \c "c"))

  "문자열의 일부분만 얻을수 있다"
  (= "World" (subs "Hello World" __ __))

  "리스트의 요소들을 결합 할 수 있다"
  (= __ (string/join '(1 2 3)))

  "그것들을 분리하여 결합 할 수 있다"
  (= "1, 2, 3" (string/join __ '(1 2 3)))

  "모든 라인을 분리하고 싶을수도 있다"
  (= [__ __ __] (string/split-lines "1\n2\n3"))

  "단어를 거꾸로 할수도 있다"
  (= __ (string/reverse "hello"))

  "처음 발생한 부분 문자열(sub string)의 위치(index) 를 찾고 싶을것이다"
  (= 0 (string/index-of "hello world" __))

  "아니면 마지막에 발생한 위치를 찾고 싶을것이다"
  (= __ (string/last-index-of "hello world, hello" "hello"))

  "하지만 찾을 수 없다면, 아무것도 발견되지 않는다"
  (= __ (string/index-of "hello world" "bob"))

  "때때로 공백이 앞뒤를 지저분하게 만드는것을 원하지 않는다"
  (= __ (string/trim "  \nhello world \t \n"))

  "문자인지 확인할 수 있다"
  (= __ (char? \c))

  "문자가 아닌지 또한 확인할 수 있다"
  (= __ (char? "a"))

  "그러나 문자는 문자열이 아니다"
  (= __ (string? \b))

  "문자열은 문자열이다"
  (= true (string? __))

  "몇몇 문자열은 비어있을수도 있다"
  (= __ (string/blank? ""))

  "언뜻 보기에는 비어 있어 보이지 않더라도"
  (= __ (string/blank? " \n \t  "))

  "하지만 대부분의 문자열은 비어있지 않다"
  (= __ (string/blank? "hello?\nare you out there?")))

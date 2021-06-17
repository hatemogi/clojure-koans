(ns koans.15-destructuring
  (:require [koan-engine.core :refer :all]))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
  "디스트럭쳐링(destructuring)으로 전달인자를 나눌 수 있다"
  (= __ ((fn [[a b]] (str b a))
         [:foo :bar]))

  "함수 정의에서도 쓸 수 있고"
<<<<<<< HEAD:src/koans/15_destructuring.clj
  (= (str "An Oxford comma list of apples, "
          "oranges, "
          "and pears.")
=======
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
>>>>>>> korean:src/koans/14_destructuring.clj
     ((fn [[a b c]] __)
      ["apples" "oranges" "pears"]))

  "또는 let 표현식에서도 쓴다"
<<<<<<< HEAD:src/koans/15_destructuring.clj
  (= "Rich Hickey aka The Clojurer aka Go Time aka Lambda Guru"
=======
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
>>>>>>> korean:src/koans/14_destructuring.clj
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
       __))

  "전체 전달인자를 되찾을 수 있다"
  (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
       __))

  "맵(map)을 키(key)로 나눠 받을 수 있다"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
       __))

  "아니면 더 간명하게도"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address __ __]} test-address]
       __))

  "전부 다 써보자!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     (___ ["Test" "Testerson"] test-address)))

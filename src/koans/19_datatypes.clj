(ns koans.19-datatypes
  (:require [koan-engine.core :refer :all]))

(defrecord Nobel [prize])
(deftype Pulitzer [prize])

(defprotocol Award
  (present [this recipient]))

(defrecord Oscar [category]
  Award
  (present [this recipient]
    (print (str "Congratulations on your "
                (:category this) " Oscar, "
                recipient
                "!"))))

(deftype Razzie [category]
  Award
  (present [this recipient]
    __))

(meditations
  "레코드를 보유하는 것은 그 레코드가 너에게 가치 있을 때만 의미있다"
  (= __ (.prize (Nobel. "peace")))

  "타입도 레코드와 꽤 비슷하다"
  (= __ (.prize (Pulitzer. "literature")))

  "레코드는 맵처럼 다룰 수 있다"
  (= __ (:prize (Nobel. "physics")))

  "반면 타입은 그렇지 않다"
  (= __ (:prize (Pulitzer. "poetry")))

  "더 공부하면 이유를 알게 된다"
  (= __
     (map map? [(Nobel. "chemistry")
                (Pulitzer. "music")]))

  "두 데이터타입 모두 프로토콜(protocol)로 메소드를 정의할 수 있다"
  (= __
     (with-out-str (present (Oscar. "Best Picture") "Evil Alien Conquerors")))

  "지금쯤은 틀림없이 스스로 구현(implement)할 수 있을 것이다"
  (= "You're really the Worst Picture, Final Destination 5... sorry."
     (with-out-str (present (Razzie. "Worst Picture") "Final Destination 5"))))

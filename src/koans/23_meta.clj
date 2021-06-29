(ns koans.23-meta
  (:require [koan-engine.core :refer :all]))

(def giants
  (with-meta 'Giants
    {:league "National League"}))

(meditations
  "일부 객체는 with-meta 함수를 사용하여 태깅 할 수 있다"
  (= __ (meta giants))

  "또는 리더 매크로로 더 간결하게"
  (= __ (meta '^{:division "West"} Giants))

  "태깅이 안되는 객체도 있다"
  (= __ (try
          (with-meta
            2
            {:prime true})
          (catch ClassCastException e
            "This doesn't implement the IObj interface")))

  "Notice when metadata carries over"
  (= __ (meta (merge '^{:foo :bar} {:a 1 :b 2}
                     {:b 3 :c 4})))

  "And when it doesn't"
  (= __ (meta (merge {:a 1 :b 2}
                     '^{:foo :bar} {:b 3 :c 4})))

  "메타데이터를 타입 힌트로 사용하여 런타임 중 리플렉션을 피할 수 있다"
  (= __ (#(.charAt ^String % 0) "Cast me"))

  "객체의 메타데이터를 직접 업데이트 할 수 있다"
  (= 8 (let [giants
             (with-meta
               'Giants
               {:world-series-titles (atom 7)})]
         (swap! (:world-series-titles (meta giants)) __)
         @(:world-series-titles (meta giants))))

  "다른 객체로 부터 메타데이터와 함께 새로운 객체를 만들 수 있다"
  (= {:league "National League" :park "AT&T Park"}
     (meta (vary-meta giants
                      assoc __ __)))

  "하지만 동등성에 영향을 주지는 않는다"
  (= __ (vary-meta giants dissoc :league))

  "또는 객체의 출력에"
  (= __ (pr-str (vary-meta giants dissoc :league))))

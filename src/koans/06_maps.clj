(ns koans.06-maps
  (:require [koan-engine.core :refer :all]))

(meditations
  "맵(map)을 만들때 길을 잃지 마라"
  (= {:a 1 :b 2} (hash-map :a 1 __ __))

  "모든 키(key)에 대응하는 값이 반드시 있어야 한다"
  (= {:a 1} (hash-map :a __))

  "그 크기는 엔트리(entry)의 수이다"
  (= __ (count {:a 1 :b 2}))

  "키로 그 값을 찾을 수 있다"
  (= __ (get {:a 1 :b 2} :b))

  "맵을 함수처럼 써서 값을 찾을 수 있다"
  (= __ ({:a 1 :b 2} :a))

  "키워드도 마찬가지다"
  (= __ (:a {:a 1 :b 2}))

  "맵의 키가 반드시 키워드일 필요는 없다"
  (= __ ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

  "때로는 키로 엔트리를 찾지 못할 때도 있다"
  (= __ (get {:a 1 :b 2} :c))

  "그러나, 기본값을 준비할 수 있다"
  (= __ (get {:a 1 :b 2} :c :key-not-found))

  "특정 키가 있는지 확인할 수 있다"
  (= __ (contains? {:a nil :b nil} :b))

  "아니면 없는지도."
  (= __ (contains? {:a nil :b nil} :c))

  "맵은 불변(immutable)이지만, 엔트리를 추가한 새 버전을 만들 수 있다"
  (= {1 "January" 2 __} (assoc {1 "January"} 2 "February"))

  "한 엔트리를 제거한 새 버전을 만들 수도 있다"
  (= {__ __} (dissoc {1 "January" 2 "February"} 2))
  
  "병합하는 것(merging) 으로 새로운 맵을 만들 수 있다"
  (= {:a 1 :b 2 __ __} (merge {:a 1 :b 2} {:c 3}))

  "병합할 때 같은 키를 가지는 엔트리(entry) 를 처리하는 특별한 방법을 지정할 수 있다"
  (= {:a 1 :b __ :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))

  "키목록이 필요하면 구할 수 있지만, 순서는 보장되지 않는다"
  (= (list __ __ __)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

  "값들도 비슷한 방법으로 구할 수 있다"
  (= (list __ __ __)
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))
       
  "맵의 엔트리를 시퀀스(seq) 로써 순회(iterate) 할 수 있다"
  (= {:a __ :b __}
     (into {}
           (map
            (fn [[k v]] [k (inc v)])
            {:a 1 :b 2}))))

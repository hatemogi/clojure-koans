# 클로저 선문답

> '클로저 선문답'은 ['Clojure Koans'](https://github.com/functional-koans/clojure-koans)를 한국어로 번역한 것입니다. Thanks, ClojureKoans contributors!

'클로저 선문답'은 여러분에게 [클로저 언어](http://clojure.org)의 신비를 전수하는 연습 문제 모음입니다. 여러분은 앞에 펼쳐진 길을 따라가며, 간단한 데이터형에서 매크로까지, 꼬리재귀(tail recursion)에서 자바와의 연동까지, 클로저 언어의 주요한 측면들을 모두 접하게 될 것입니다. 많은 분이 클로저가 그 전까지 썼던 프로그래밍 언어들과는 매우 다르다는 것을 알게될 것입니다. 이 선문답은 점진적이며 문답식인 배움법으로 여러분이 자연스럽게 클로저 언어로 옮겨갈 수 있도록 도울 것입니다. 모든 관문을 통과할 때 쯤이면, 클로저가 전혀 기이하지 않게 여겨질 것입니다.

## 실행 데모

[![asciicast](https://asciinema.org/a/21413.png?autoplay=1)](https://asciinema.org/a/21413)

## 자바 설치하기

선문답을 시작하기에 앞서 클로저가 필요하고, 클로저를 설치하기 전에 자바가 필요합니다. 아마도 여러분에게 자바가 이미 설치돼 있을테지만, 만약 그렇지 않더라도, 설치하기는 어렵지 않습니다. 윈도 사용자는 오라클의 윈도용 자바 설치 방법을 참고하고, 리눅스 사용자는 선호하는 패키지 관리자를 이용하도록 합니다. 애플은 시스템 업데이트 도구를 통해 자바 6를 배포하고 있습니다.

필요하다면 자바를 설치한 뒤, 콘솔(터미널)을 열어 아래 명령어를 입력합니다:

```sh
$ java -version
```

버전 1.5 이상이 설치돼 있어야 합니다.

## 선문답 설치하기

여러분이 전문가답게 클로저를 쓰려한다면, [라이닝엔(Leiningen)](http://leiningen.org)이라는 가장 널리 쓰이는 클로저 의존성 관리 도구를 써서 선문답을 설치하도록 합니다. (이게 곧 클로저를 설치해 줍니다.) 라이닝엔의 특혜를 받기 위해 설치 방법을 따르도록 합니다.

중요: 이미 lein 1.x가 설치돼 있다면 라이닝엔 2로 업그레이드 합니다.

라이닝엔을 설치한 후에는, 선문답 저장소를 클론(clone)하면 됩니다:

```sh
$ git clone git://github.com/hatemogi/clojure-koans.git
```

만약 라이닝엔을 쓰기 싫다면, 선문답을 손수 설치할 수 있습니다. [여기 링크에서 최신 버전을 다운로드](http://github.com/hatemogi/clojure-koans/releases) 받고 압축을 풀어서 시작하실 수 있습니다.


## 선문답 실행하기

앞서 설명한 라이닝엔이 설치돼 있다면

```sh
$ lein koan run
```

위의 명령어로 바로 시작할 수 있습니다.

(저장소를 클론한 뒤 clojure-koans 디렉토리로 이동하는 것을 잊지 마세요!)

또는, 라이닝엔을 안 쓴다면, 아래처럼 씁니다

```sh
$ script/run
```

맥이나 리눅스에서는 위 명령어를 실행하고,

```
$ script\run
```

윈도에서는 위 명렁어를 씁니다.

그러면 아래와 같은 에러 메시지를 보게 됩니다:

```plain
Now meditate on ~/clojure-koans/src/koans/01_equalities.clj:6
---------------------
Assertion failed!
같은지 확인해가며 현실을 시험해서 진실을 주의깊게 관찰하라
(= __ true)
```

위 내용은 01_equalities.clj 파일의 6째줄에서 테스트가 실패하고 있다는 뜻입니다. 그럼 그 파일을 여러분이 즐겨 쓰는 텍스트 에디터로 열고, 밑줄 친 빈칸을 채워서 테스트를 통과하도록 합시다!

## 반복

첫번째 테스트를 통과하고 나면 그 다음 테스트가 실패하는 것을 알게 될 것입니다. 한 파일의 모든 테스트를 통과하고 나면, 자동으로 그 다음 파일의 선문답 과정이 시작됩니다.

## 역자의 말

이 사이트는 김대현이 한국어로 번역했고, GitHub Pages로 호스팅되고 있습니다. 별도 웹사이트는 <http://clojurekoans.hatemogi.com>에서 보실 수 있습니다.

번역에 관한 문의나 제안은 [이슈로 남겨](https://github.com/hatemogi/clojure-koans/issues)주시거나, [풀리퀘스트를 보내](https://github.com/hatemogi/clojure-koans/pulls)주세요.

## 라이선스

The use and distribution terms for this software are covered by the
[Eclipse Public License 1.0](http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.

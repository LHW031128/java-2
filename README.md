<<<<<<< HEAD
이효원 202230130 <br>
05/22(11주차)

# StringBuffer 클래스
가변 스트링을 다루는 클래스

StringBuffer 객체 생성
StringBuffer sb = new StringBuffer("java");

String 클래스와 달리 문자열 변경 가능
 가변 크기의 버퍼를 가지고 있어 문자열 수정 가능
 문자열의 수정이 많은 작업에 적합

스트링 조작 사례
StringBuffer sb = new StringBuffer("This");

sb.append(" is pencil.");     // sb = "This is pencil."
sb.insert(7, " my");          // sb = "This is my pencil."
sb.replace(8, 10, "your");    // sb = "This is your pencil."
System.out.println(sb);      // "This is your pencil." 출력

# StringTokenizer 클래스
구분 문자를 기준으로 문자열을 분리하는 클래스
 구분 문자(delimiter) : 문자열을 구분할 때 사용되는 문자
 토큰(token) : 구분 문자로 분리된 문자열

# Math 클래스
기본 산술 연산 메소드를 제공하는 클래스

모든 메소드는 static으로 선언

클래스 이름으로 호출 가능

Math.random() 메소드로 난수 발생
 random()은 0보다 크거나 같고 1.0보다 작은 실수 난수 발생
 1에서 100까지의 랜덤 정수 10개를 발생시키는 코드 사례
for(int x=0; x<10; x++) {
    int n = (int)(Math.random()*100 + 1);  // 1~100까지의 랜덤 정수 발생
    System.out.println(n);
}
java.util.Random 클래스를 이용하여 난수 발생 가능
Random r = new Random();
int n = r.nextInt();       // 음수, 양수, 0 포함, 자바의 정수 범위 난수 발생
int m = r.nextInt(100);    // 0에서 99 사이(0과 99 포함)의 정수 난수 발생

# 컬렉션(collection)의 개념
요소(element)라고 불리는 가변 개수의 객체들의 저장소
 객체들의 컨테이너라고도 불림
 요소의 개수에 따라 크기 자동 조절
 요소의 삽입, 삭제에 따른 요소의 위치 자동 이동

고정 크기의 배열을 다루는 어려움 해소
다양한 객체들의 삽입, 삭제, 검색 등의 관리 용이

# 컬렉션의 특징
1. 컬렉션은 제네릭(generics) 기법으로 구현
제네릭
 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화시키는 기법
 클래스나 인터페이스 이름에 <E>, <K>, <V> 등 타입 매개변수 포함

제네릭 컬렉션 사례 : 벡터 Vector<E>
 <E>에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
 정수만 다루는 컬렉션 벡터 Vector<Integer>
 문자열만 다루는 컬렉션 벡터 Vector<String>
2. 컬렉션의 요소는 객체만 가능
 int, char, double 등의 기본 타입으로 구체화 불가
 컬렉션 사례
Vector<int> v = new Vector<int>();     // 컴파일 오류. int는 사용 불가
Vector<Integer> v = new Vector<Integer>(); // 정상 코드

# 제네릭의 기본 개념
제네릭
 JDK 1.5부터 도입(2004년 기준)
 모든 종류의 데이터 타입을 다룰 수 있도록 일반화된 타입 매개 변수로 클래스(인터페이스)나 메소드를 작성하는 기법
 C++의 템플릿(template)과 동일

# Vector<E>의 특성
<E>에 사용할 요소의 특정 타입으로 구체화

배열을 가변 크기로 다룰 수 있게 하는 컨테이너
 배열의 길이 제한 극복
 요소의 개수가 넘치면 자동으로 길이 조절

요소 객체들을 삽입, 삭제, 검색하는 컨테이너
 삽입, 삭제에 따라 자동으로 요소의 위치 조정

Vector에 삽입 가능한 것
 객체, null
 기본 타입의 값은 Wrapper 객체로 만들어 저장

Vector에 객체 삽입
 벡터의 맨 뒤, 중간에 객체 삽입 가능

Vector에서 객체 삭제
 임의의 위치에 있는 객체 삭제 가능

# 컬렉션과 자동 박싱/언박싱
JDK 1.5 이전
기본 타입 데이터를 Wrapper 객체로 만들어 삽입
Vector<Integer> v = new Vector<Integer>();
v.add(Integer.valueOf(4));

컬렉션으로부터 요소를 얻어올 때, Wrapper 클래스로 캐스팅 필요
Integer n = (Integer)v.get(0);
int k = n.intValue(); // k = 4

JDK 1.5부터
 자동 박싱/언박싱이 작동하여 기본 타입 값 삽입 가능
Vector<Integer> v = new Vector<Integer>();
v.add(4); // 4 → Integer.valueOf(4)로 자동 박싱
int k = v.get(0); // Integer 타입이 int 타입으로 자동 언박싱, k = 4

그러나, 타입 매개 변수를 기본 타입으로 구체화할 수는 없음
Vector<int> v = new Vector<int>(); // 컴파일 오류

# 컬렉션 생정문의 진화 : JAVA7, JAVA10
JAVA7 이전
 vector<Integer> V = new Vector<Integer>;// JAVA7 이전

JAVA7 이후
 컴파일러의 타입 추론 기능 추가
 <>(다이어몬드 연산자)에 타입 매개변수 생략
Vector<Integer> V = new Vector<>(); //JAVA7부터 추가, 가능

JAVA10 이후
var 키워드 도입, 컴파일러의 지역 변수 타입 추론 가능
var V = new Vector<Integer>(); //JAVA10 부터 주가, 가능 

# ArrayList<E>
가변 크기 배열을 구현한 클래스
 <E>에 요소로 사용할 특정 타입으로 구체화

벡터와 거의 동일
 요소 삽입, 삭제, 검색 등 벡터 기능과 거의 동일
 벡터와 달리 스레드 동기화 기능 없음
 다수 스레드가 동시에 ArrayList에 접근할 때 동기화되지 않음
 개발자가 스레드 동기화 코드 작성

# ArrayList와 Vector의 차이
ArrayList와 Vector는 모두 동적으로 크기가 늘어나는 배열 기반의 리스트 클래스입니다

요즘은 ArrayList가 기본 선택지입니다
Vector는 이제 거의 사용하지 않고, 멀티스레드가 필요하다면 다른 방법을 씁니다

# 컬렉션의 순차 검색을 위한 Iterator
Iterator<E> 인터페이스
 리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
 Iterator<E>, ArrayList<E>, LinkedList<E>가 상속받는 인터페이스

 Iterator 객체 얻어내기
  컬렉션의 iterator() 메소드 호출: 해당 컬렉션을 순차 검색할 수 있는 Iterator객체 리턴

# HashMap<k, v>
키와 값의 쌍으로 구성되는 요소를 다루는 컬렉션
 K : 키로 사용할 요소의 타입
 V : 값으로 사용할 요소의 타입
 키와 값이 한 쌍으로 삽입
 값을 검색하기 위해서는 반드시 키 이용
삽입 및 검색이 빠른 특징
 요소 삽입 : put() 메소드
 요소 검색 : get() 메소드

# 자바의 GUI
GUI : 사용자가 편리하게 입출력 할 수 있도록 그래픽으로 화면을 수겅하고, 마우스나 키보드로 입력 받을 수 있도록 지원하는 사용자 인터페이스

자바 언어에서 GUI 응용프로그램 작성 : AWT와 Swing 패키지에 강력한 GUI 컴포넌트 제공

AWT 패키지
자바가 처음 나았을 떄 붜터 배포된 GUI패키지, 최근에는 거의 사용하지 않음
AWT 컴포넌트는 중량 컴포넌트
AWT컴포넌트의 그리기는 운영체제에 의해 이루어지며 운영체제에 의 자원을 많이 소모하고 부담을 줌
운영체제가 직접 그리기 땜분에 속도는 빠름

# Swing 패키지
 AWT키술을 기반으로 작성된 자바 라이브러리
 모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴포넌트
 AWT 컴포넌트를 모두 스윙으로 재작성
 AWT 컴포넌트를 이름 앞 j자를 덧붙임
 순수 자바언어로 구현
 스윙 컴포넌트는 경량 컴포넌트

_______________________________________________________________
05/15(10주차)

# 자바 플랫폼의 모듈화
■ 자바 플랫폼
자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭. Java SE(자바 API) 포함.
자바 API의 모든 클래스가 여러 개의 모듈로 재구성됨
모듈 파일은 JDK의 jmods 디렉터리에 저장하여 배포

■ 모듈 파일로부터 모듈을 푸는 명령
jmod extract "C:\Program Files\Java\jdk-17.0.3.+7\jmods\java.base.jmod"
현재 디렉터리에 java.base 모듈이 패키지와 클래스들로 풀림

# 자바 모듈화의 목적
자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함

컴퓨터 시스템의 불필요한 부담 감소
 세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
 소형 IoT 장치에도 자바 응용프로그램이 실행되고 성능을 유지하게 함

# JDK의 주요 패키지
java.lang
스트링, 수학 함수, 입출력 등 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스
자동으로 import 됨 - import 문 필요 없음

java.util
날짜, 시간, 벡터, 해시맵 등과 같은 다양한 유틸리티 클래스와 인터페이스 제공

java.io
키보드, 모니터, 프린터, 디스크 등에 입출력을 할 수 있는 클래스와 인터페이스 제공

java.awt
GUI 프로그램을 작성하기 위한 AWT 패키지

javax.swing
GUI 프로그램을 작성하기 위한 스윙 패키지

# Object 클래스
모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일
모든 클래스의 수퍼 클래스
모든 클래스가 상속받는 공통 메소드 포함

메소드	                        설명
boolean equals(Object obj)	 obj가 가리키는 객체와 현재 객체를 비교하여 같으면 true 리턴
Class getClass()	현 객체의 런타임 클래스 리턴
int hashCode()   	현 객체에 대한 해시 코드 값 리턴
String toString()	현 객체에 대한 문자열 표현을 리턴
void notify()	    현 객체에 대해 대기하고 있는 하나의 스레드를 깨운다.
void notifyAll()	현 객체에 대해 대기하고 있는 모든 스레드를 깨운다.
void wait()	        다른 스레드가 깨어날 때까지 현재 스레드를 대기하게 한다.

# 객체 속성
Object 클래스는 객체의 속성을 나타내는 메소드 제공

hashCode() 메소드
객체의 해시코드 값을 리턴하며, 객체마다 다름

getClass() 메소드
객체의 클래스 정보를 담은 Class 객체 리턴

Class 객체의 getName() 메소드는 객체의 클래스 이름 리턴

toString() 메소드
객체를 문자열로 리턴


# toString() 메소드, 객체를 문자열로 변환
각 클래스는 toString()을 오버라이딩하여 자신만의 문자열 리턴 가능
객체를 문자열로 변환
원형 : public String toString();

컴파일러에 의한 toString() 자동 변환
"객체 + 문자열" → "객체.toString() + 문자열"로 자동 변환
객체를 단독으로 사용하는 경우 → 객체.toString()으로 자동변환

# 객체 비교(==)와 equals() 메소드
== 연산자 : 객체 레퍼런스 비교

Point a = new Point(2,3);
Point b = new Point(2,3);
Point c = a;

if(a == b) // false
    System.out.println("a==b");
if(a == c) // true
    System.out.println("a==c");

a == c

boolean equals(Object obj)
두 객체의 내용을 비교
객체의 내용을 비교하기 위해 클래스의 멤버로 작성

# wrapper클래스
wrapper 클래스 :  자바의 기본 타입을 클래스화 한 8개 클래스를 통칭
용도 : 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 wrapper 객체로 만들어 사용

# 박싱과 언박싱
박싱 : 기본 타입의 값을 wtapper 객체로 변환하는 것
언박싱 : wtappr객체에 들어 있는 기본 타입의 값을 빼내는 것, 박싱의 반대
자동 박싱과  자동 언박싱 : JDK1.5부터 박싱과 언박싱은 자동으로 이루어지도록 컴파일됨

# String의 생성과 특징
String 클래스는 문자열을 나타냄
스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨



# 스트링 리터럴과 new String()
스트링 리터럴
 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨
 응용프로그램에서 공유됨
 스트링 리터럴 사례) String s = "Hello";

new String()으로 생성된 스트링
 스트링 객체는 힙에 생성
 스트링은 공유되지 않음

# String 활용
스트링 비교 equals()와 compareTo()
  스트링 비교에 == 연산자 절대 사용 금지
   equals() : 스트링이 같으면 true, 아니면 false리턴

int compareTo(String anotherString)
 문자열이 같으면  0 리턴
 이 문자열이 anotherString 보다 먼저 나오면 음수 리턴
 이 문자열이 anotherString 보다 나중에 나오면 양수 리턴










__________________________________________________________________
05/08 (9주차)
# 추상 클래스
   추상 메소드
    abstract로 선언된 메소드, 메소드릐 코드는 없고 원형만 선언
   추상 클래스
    추상 메소드를 가지며 abstract로 선언된 클래스
    추상 메소드 없이, abstract로 선언한 클래스
# 추상 클래스의 상속과 구현
   추상 클래스 상속
    추상 클래스를 상속받으면 추상 크랠스가 됨
    서브 클래스도 abstract로 선언해야 함
   추상클래스 구현
    서브 클래스에서 슈퍼 클래스의 추상 메소드 구현 (오버라이딩)
    추상클래스를 구현한 서브 클래스는 추상 클래스 아님
# 추상 클래스의 목적
   추상 클래스의 목적
    상속을 위한 슈퍼 클래스로 활용하는 것
    서브 클래스에서 추상 메소드 구현
    다형성 실현

# 자바의 인터페이스
    소프트웨어를 규격화된 모듈로 만들고 인터페이스가 맞는 모듈을 조립하듯이 응용프로그램을 작성 하기위해서 사용

   자바의 인터페이스
    클래스가 구현해야 할 메소드들이 선언되는 추상형
    인터페이스 선언 : interface 키워드로 선언

   자바 인터페이스에 대한 변화
    자바 7까지 : 인터페이스는 상수와 추상 메소드로만 구성
    자바 8부터 : 상수와 추상메소드 포함 default 메소드 포함 

# 인터페이스의 구성 요소들의 특징
[인터페이스의 구성 요소들]
   상수 : public만 허용, public static final 생략

   추상 메소드 : public abstract 생략 가능

   default 메소드 :
    인터페이스에 코드가 작성된 메소드
    인터페이스를 구현하는 클래스에 자동 상속
    public 접근 지정만 허용. 생략 가능

   private 메소드 :
    인터페이스 내에 메소드 코드가 작성되어야 함
    인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능

   static 메소드 : public, private 모두 지정 가능. 생략하면 public

# 자바 인터페이스 특징
   인터페이스의 객체 생성 불가
    오류 new PhoneInterface(); // 오류. 인터페이스 PhoneInterface 객체 생성 불가
   인터페이스 타입의 레퍼런스 변수 선언 가능
    PhoneInterface galaxy; // galaxy는 인터페이스에 대한 레퍼런스 변수

# 인터페이스 상속
   인터페이스 간에 상속 가능 :
    인터페이스를 상속하여 확장된 인터페이스 작성 가능
    extends 키워드로 상속 선언
예시
interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS();     // 추상 메소드 추가
    void receiveSMS();  // 추상 메소드 추가
}
   인터페이스 다중 상속 허용 (* 일반 상속에서는 허용하지 않음)  
예시
interface MusicPhoneInterface extends PhoneInterface, MP3Interface
{
    ......
}

# 인터페이스 구현
   인터페이스의 추상 메소드를 모두 구현한 클래스 작성
    implements 키워드 사용
    여러 개의 인터페이스 동시 구현 가능
   인터페이스 구현 사례
    PhoneInterface 인터페이스를 구현한 SamsungPhone 클래스
class SamsungPhone implements PhoneInterface { // 인터페이스 구현
    // PhoneInterface의 모든 메소드 구현
    public void sendCall() { System.out.println("띠리리리링"); }
    public void receiveCall() { System.out.println("전화가 왔습니다."); }

    // 메소드 추가 작성
    public void flash() { System.out.println("전화기에 불이 켜졌습니다."); }
}
SamsungPhone 클래스는 PhoneInterface의 default 메소드 상속

# 패키지 개념과 필요성
3명이 부담하여 자바 응용프로그램을 개발하는 경우 동일한 이름의 클래스가 존재할 가능성 있음 -> 합칠 때 오류 발생 가능성
-> 개발자가 서로 다른 디렉터리로 코드를 관리할 수 있다

# 자바의 패키지와 모듈이란?
   패키지(package)
    서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리
    하나의 응용프로그램은 한 개 이상의 패키지로 작성
    패키지는 jar 파일로 압축할 수 있음

   모듈(module)
    여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    하나의 모듈을 하나의 .jmod 파일에 저장

   ■ Java 9부터 모듈화 도입
    플랫폼의 모듈화 : Java 9부터 자바 API의 모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성

    응용프로그램의 모듈화 : 클래스들을 패키지로 만들고, 다시 패키지를 모듈로 만듦
               모듈 프로그래밍은 어렵고 복잡. 기존 방식으로     프로그램 작성

# 자바의 모듈화의 목적
   모듈화의 목적
    Java 9부터 자바 API를 여러 모듈(99개)로 분할 : Java 8까지는 rt.jar의 한 파일에 모든 API 저장.
  # 현재 70개로 정리됨.
    응용프로그램이 실행할 때 꼭 필요한 모듈들로만 실행 환경 구축 :
    메모리 자원이 열악한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지를 만들기 위함
   모듈의 현실
    Java 9부터 전면적으로 도입
    복잡한 개념
    큰 자바 응용프로그램에는 개발, 유지보수 등에 적합
    현실적으로 모듈로 나누어 자바 프로그램을 작성할 필요 없음
💡 모듈화 작업은 매우 중요한 개념이며, 소규모 프로젝트부터 적용해야 대형 프로젝트 쉽게 도입, 활용할 수 있습니다.

# 패키지 만들기
   클래스 파일(.class)이 저장되는 위치는?
    클래스나 인터페이스가 컴파일 되면 클래스 파일(.class) 생성
    클래스 파일은 패키지로 선언된 디렉터리에 저

   패키지 선언 
    소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정 → package 패키지명;

# 디폴트 패키지
   package선언문이 없는 자바 소스 파일의 경우
    컴파일러는 클래스나  인터페이스를 디폴트 패키지에 소속시킴
    티폴트 패키지 -> 현재 디렉터리

# package의 운영 방법
패키지 이름은 도메인 기반으로 시작 (일반 관례)형식 : com.회사이름.프로젝트명.기능명
→ 충돌 방지 (전 세계 어디서든 유일한 패키지명 확보 가능) / 모듈별 분리 가능

기능/역할별로 하위 패키지를 구분 : utils, controller, service 등

디렉토리 구조와 package 선언을 정확히 일치해야 합니다.

import는 필요한 만큼만, * 전체 import는 피하는 것이 좋습니다.
___________________________
04/17 (5월 1일 보강)

# static 메소드의 제약 조건 2
    static 메소드는 this 사용불가
    static 메소드는 객체 없이도 사용 가능하므로, static 래퍼런스 사용할 수 없음
    오류  static void f() { this.m = x; } // 오류. static 메소드에서는 this 사용 불가능  
    오류  static void g() { this.m = x; } // 오류. static 메소드에서는 this 사용 불가능

# final 필드
    final 필드 : 상수를 선언할 때 사용
    class SharedClass {
    public static final double PI = 3.14;
}
상수 필드는 선언 시에 초기 값을 지정하여야 한다.

상수 필드는 실행 중에 값을 변경할 수 없다
public class FinalFieldClass {
    final int ROWS = 10; // 상수 정의, 이때 초기 값(10)을 반드시 설정

    void f() {
        int[] intArray = new int[ROWS]; // 상수 활용
        ROWS = 30; // 컴파일 오류 발생, final 필드 값을 변경할 수 없다.
    }
}

# 상속의 필요성
    상속이 없는 경우 중복된 멤버를 가진 4개의 클래스나
    상속을 이용한 경우 중복이 제거되고 간결해진 클래스 구조

# 클래스 상속과 객체
    상속 선언 : extends 키워드 사용
    부모 클래스를 물려받아 자식 클래스를 확장하다는 의미
    부모 클래스 -> 슈퍼 클래스
    자식 클래스 -> 서브 클래스
    class Point {
    int x, y;
    ...
}

class ColorPoint extends Point { // Point를 상속받은 ColorPoint 클래스 선언
    ...
}

    ColorPoint는 Point를 물려 받으므로, Point에 선언된 필드와 메소드 선언 필요 없음
E 서브 클래스 객체의 모양
    슈퍼 클래스 객체와 서브 클래스의 객체는 별개
    서브 클래스 객체는ㄴ,ㄴ 개게는 ㅎ\슈ㅜㅍ


# 자바 상속의 특징
    클래스 다중 상속(multiple inheritance) 불허

하나의 클래스가 둘 이상의 부모 클래스를 동시에 상속받는 것을 말합니다.
C++는 다중 상속 가능

C++는 다중 상속으로 멤버가 중복 생성되는 문제 있음. (다이아몬드 상속)

부모 클래스 간에 계층적 관계가 있을 경우, 중복된 멤버가 생성될 수 있습니다.
모호성(Ambiguity) 문제 : 두 부모 클래스에 동일한 이름의 멤버(변수나 함수)가 존재할 경우,
어떤 부모의 멤버를 호출해야 할지 모호해집니다.

자바는 **인터페이스(interface)**의 다중 상속 허용

다중 상속과 유사한 기능을 제공합니다.
모든 자바 클래스는 묵시적으로 Object 클래스를 상속받음

java.lang.Object는 클래스는 모든 클래스의 슈퍼 클래스

# 슈퍼 클래스의 멤버에 대한 서브 클래스의 접근
    슈퍼 클래스의 private 멤버 : 서브 클래스에서 접근할 수 없음
    슈퍼 클래스의 디폴트 멤버 : 서브 클래스가 동일한 패키지에 있을 때, 접근 가능
    슈퍼 클래스의 public 멤버 : 서브 클래스는 항상 접근 가능
    슈퍼 클래스의 protected 멤버 : 
    1. 같은 패키지 내의 모든 클래스 접근 허용
    2. 패키지 여부와 상관없이 서브 클래스는 접근 가능

# protected 멤버
    protected 멤버에 대한 접근 : 같은 패키지의 모든 클래스에게 허용
    상속되는 서브 클래스가 같은 패키지든 다른 패키지든 상관 없이 허용

    (a) 슈퍼 클래스와 서브 클래스가 동일한 패키지에 있는 경우
    패키지 P

public class A {
    private int pri;
    int def;
    protected int pro;
    public int pub;
}

public class B extends A {
    void set() {
        pub = 1;
        pro = 2;
        def = 3;
        pri = 4; // 슈퍼 클래스의 private 멤버 접근 안 됨
    }
}
    (b) 슈퍼 클래스와 서브 클래스가 서로 다른 패키지에 있는 경우
    패키지 Q

public class A {
    private int pri;
    int def;
    protected int pro;
    public int pub;
}

패키지 R

public class B extends A {
    void set() {
        pub = 1;
        pro = 2;
        def = 3;
        pri = 4; // 슈퍼 클래스의 private, default 멤버 접근 안 됨
    }
}


# 접근 지정자
    자바의 접근 지정자 4가지 : private, protected, public, 디폴트(접근 지정자 생략) 
    접근 지정자의 목적
    ✔ 클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
    ✔ 객체 지향 언어의 캡슐화 정책은 멤버를 보호하는 것
    ➔ 접근 지정은 캡슐화에 묶인 보호를 일부 해제할 목적으로 사용

    접근 지정자에 따른 클래스나 멤버의 공개 범위

접근 수준	허용 대상
private	외부로부터 완벽 차단
디폴트	동일 패키지에 허용
protected	동일 패키지와 자식 클래스에 허용
public	모든 클래스에 허용

# 서브 클래스/슈퍼 클래스의 생성자 호출과 실행
    서브 클래스의 객체가 생성될 때 : 슈퍼클래스 생성자와 서브 크랠스 생성자 모두 실행
    
# 서브 클래스와 슈퍼 클래스의 생성자 선택
    슈퍼 클래스와 서브 클래스 : 각각 여러 개의 생성자 작성 가능
    서브 클래스의 객체가 생성될 때 : 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행
    서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식

1. 개발자의 명시적 선택

    서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
    super() 키워드를 이용하여 선택

2. 컴파일러가 기본 생성자 선택

    서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
    컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택

# 업캐스팅 개념
    하위 클래스위 해퍼런스는 상위 클래스를 가리킬 수 없지만, 상위 클래스의 래퍼런스의 하위 클래스를 가리킬 수 있다는 설명

# 업캐스팅
    생물이 들어가는 박스에 사람이나 코끼리를 넣어도 무방
    사람이나 코끼리 모두 생물을 상속받았기 때문

# 업캐스팅 이란?
    서브클래스의 레퍼런스를 슈퍼 클래스 레퍼런드에 대입
    슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 된는 현상
    class Person { } // 슈퍼 클래스
    class Student extends Person { }

    Person p;
    Student s = new Student();
    p = s; // 업캐스팅

# 업캐스팅 사례
class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    String grade;
    String department;

    public Student(String name) {
        super(name);
    }
}

public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("이재문");
        p = s; // 업캐스팅 발생

        System.out.println(p.name); // 오류 없음

        // p.grade = "A";      // 컴파일 오류
        // p.department = "Com";// 컴파일 오류
    }
}

# 그렇다면 왜 p = s로 업캐스팅을 한 걸까?
    이 사례는 업캐스팅의 제한 사항을 설명하기 위한 코드입니다.
    실제로는 이런 식으로 업캐스팅을 사용하지는 않습니다.

    실제로는 여러 자식 클래스를 하나의 부모 타입으로 다루기 위해 사용합니다.
    Person[] people = new Person[3];
    people[0] = new Student("홍길동");
    people[1] = new Student("김영희");
    people[2] = new Person("이순신");

    이렇게 하면 공통된 타입(Person)으로 여러 자식 클래스를 한 배열에 담을 수 있습니다.
    대신 접근은 Person 수준에서만 가능합니다.

    ⚠️ 실제로 필요성을 느끼기 전에는 쉽게 이해하기 힘들 수 있습니다. 개념만 알아 두기⚠️

# 다운캐스팅
    슈퍼 클래스 레퍼런스 를 서브 클래스 레퍼런스에 대임
    업캐스팅 된 것을 다시 원래대로 되돌리는 것
    반드시 병시적 타입 변환 지정

# 업캐스팅 레펄런스로 객체 구별?
    업캐스팅된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
    슈퍼클래스는 여러 서브 클래스에 상속되기 때문
    예를들어 아래의 클래스 계층 구조에서, p가 가리키는 객체가 Person 객체인지, Student 객체인지, Professor 객체인지 구분하기 어려움

# instanceof 연산자 사용
    레퍼런스가 가리키는 객체의 타입 식별 : 연산의 결과는 true/false의 불린 값으로 반환
    
# 메소드 오버라이딩의 개념
    서브 클래스에서 슈퍼 클래스의 메소드 중복 작성
    슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 조장됨
    메소드 무시하기로 번역되기도 함

# 서브 클래스 객체와 오버라이딩된 메소드 호출
    오버라이딩 한 메소드가 실행됨을 보장

# 오버라이딩의 목적 다향성 실현
    오버라이딩으로 다형성 실현
    하나의 인터페이스(같은 이름)에 서로 다른 구현
    
# 동적 바인딩 - 오버라인딩된 메소드 호출
    Super0bject 하나만 있는 응용프로그램의 경우 혹은 상속받은 경우 모두 동적 바인딩을 한단
    오퍼라이딩 메소드가 항상 호출된다
    Super0bject는 키워드가 아닙니다!

# super 키워드로 슈퍼 클래스의 멤버 접근
    슈퍼 클래스의  멤버를 접근할 때 사용되는 레퍼런스
    서브 클래스에서만 사용
    슈퍼 클래스의 필드 접근
    슈퍼 클래스의 메소드 호출 시 super로 이루어지는 메소드 호풀 : 정적 바인딩

    상속!까지 시험범위
    프로젝스 생성하기
    객체 생성하기
    클래스도 공부하기
_____________________________
04/17 7주차
생성자의 종류
1. 기본 생성자: 매개 변수 없고, 아무 작업 없이 단순 리턴하는 생성자
    class Circle{
        public Circle() {} // 기본 생성자
    }


2. 기본 생성자가 자동 생성되는 경우
    클래스에 생성자가 하나도 선언되어 있지 않을 때
    컴파일러에 의해 기본 생성자 자동 생성

this 레퍼런스
    객체 자신에 대한 래퍼런스
    
    컴파일러에 의해 자동 관리, 개발자는 사용하기만 하면 됨
    
    this멤버 형태로 멤버를 접근할 때 사용

객체 속에서의 this

    1.this.radius는 현재 객체의 멤버 변수

    radius는 메서드의 매개변수

    this.radius = radius;는 매개변수 값으로 객체의 필드 값을 바꿈

    각 객체는 서로 독립적으로 존재하며, 각각의 radius 값을 가지고 있음

객체 배열
* 객체에 대한 래퍼런스 배열
* 자바의 객체 배열 만들기 3 단계
    1. 배열 레퍼런스 변수 선언
    2. 래퍼런스 배열 생성
    3. 배열의 각 원소 객체 생성

Circle[] c;                          // Circle 배열에 대한 레퍼런스 변수 c 선언
c = new Circle[5];                   // 레퍼런스 배열 생성

for (int i = 0; i < c.length; i++) { // c.length는 배열 c의 크기로서 5
    c[i] = new Circle(i);           // 각 원소 객체 생성
}

for (int i = 0; i < c.length; i++) { // 모든 객체의 면적 출력
    System.out.print((int)(c[i].getArea()) + " "); // 배열의 원소 객체 사용
}

객체 배열 선언과 생성 과정
객체 배열 만들 때는
1) 배열 선언 → 2) 배열 생성 → 3) 각 칸에 객체 생성
이 3단계로 기억하면 된다

칱나 넡앞 매쳪치 넡앞외틑 경우
    배열 체퍼런스만 매개 변수에 전달 : 배열 통째로 전달되지 않음
    개게가 전달되는 경우와 동일 : 매개 변수가 실인자의 배열 공유    

메소드 오버로딩
 한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
    1. 메소드 이름이 동일해야 함
    2. 메개 변수의 개수 혹은 타입이 달라야 함
    3. 리턴 타입은 오버로딩과 관련 없음

성공한 오버로딩과 메소드 호출
    public class MethodSample {
    public int getSum(int i, int j) {
        return i + j;
    }

    public int getSum(int i, int j, int k) {
        return i + j + k;
    }

    public double getSum(double i, double j) {
        return i + j;
    }

    public static void main(String args[]) {
        MethodSample a = new MethodSample();

        int i = a.getSum(1, 2);
        int j = a.getSum(1, 2, 3);
        double k = a.getSum(1.1, 2.2);
    }
}

객체 치환 시 주의할 점
 객체 치환은 객체 복사가 아니며, 레퍼런스의 복사이다
public class Samp {
    int id;

    public Samp(int x) {
        this.id = x;
    }

    public void set(int x) {
        this.id = x;
    }

    public int get() {
        return this.id;
    }

    public static void main(String[] args) {
        Samp ob1 = new Samp(3);
        Samp ob2 = new Samp(4);
        Samp s;

        s = ob2;
        ob1 = ob2;  // 객체의 치환 (레퍼런스 복사)

        System.out.println("ob1.id = " + ob1.get());
        System.out.println("ob2.id = " + ob2.get());
    }
}



객체 소멸
 new로 할당 받은 객체와 메모리를 JVM으로 되돌려 주는 행위
 자바는 객체 소멸 연사자 없음
 객체 소멸은 JVM의 고유한 역할

 C/C++에서는 할당 받은 객체를 개발자가 프로그램 내에서 삭제해야 함
 C/C++의 프로그램 작성을 어렵게 만드는 요인
 자바에서는 사용하지 않는 객체나 배열을 돌려주는 코딩 책임으로부터  개발자 해방

가비지
 가리키는 레퍼런스가 하나도 없는 객체
 더 이상 접근할 수 없어 사용할 수 없게 된 메모리
  가비지 켈렉션  : 자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수집, 반환
 Person a, b;
 a = new Person("이몽룡");
 b = new Person("성춘향");

 b = a;  // b가 가리키던 객체는 가비지가 됨
 참조형 변수는 객체 주소를 가리킨다.

 객체를 새로 할당하지 않으면, 다른 객체를 가리키던 주소는 잃어버려짐 → GC 대상이 됨 (가비지 컬렉션)

가비지의 발생
 String a = new String("Good");
 String b = new String("Bad");
 String c = new String("Normal");
 String d, e;

 a = null;  // ①
 d = c;     // ②
 c = null;  // ③

가비지 발생 여부 
 a = null;

 a가 가리키던 "Good" 객체는 더 이상 참조되지 않음
 → ✅ 가비지 발생

 d = c; → d가 "Normal" 객체 참조 시작
 c = null; → c는 참조 해제되지만, d가 여전히 "Normal"을 참조 중
 → ❌ "Normal" 객체는 가비지가 아님

 "Bad" 객체는 b가 여전히 참조 중
 → ❌ 가비지 아님

결론
 a = null;

 a가 가리키던 "Good" 객체는 더 이상 참조되지 않음
 → ✅ 가비지 발생

 d = c; → d가 "Normal" 객체 참조 시작
 c = null; → c는 참조 해제되지만, d가 여전히 "Normal"을 참조 중
 → ❌ "Normal" 객체는 가비지가 아님

 "Bad" 객체는 b가 여전히 참조 중
 → ❌ 가비지 아님

언제 발생하는지
 시점 | 가비지 객체
 Line 3~6 | 없음
 Line 7 | "Good" 발생 ✅
 Line 8 | 변화 없음
 Line 9 | "Normal"은 여전히 참조 중 → 가비지 ❌

가비지 컬렉션
 JVM이 가비지 자동 회수
  가용 메모리 공간이 일정 이하로 부족해질 때
  가비지를 수거하여 가용메로리 공간으로 확보
  가비지 컬렉터에 의해 자동 수행
강제 가비지 컬렉션 강제 수행 : System 또는 Runtime 객체의 gc()메소드 호출
    System.gc(); //가비지 컬렉션 자동 요청
이 코드는 JVM에 강력한 가비지 컬렉션 요청
그러나 JVM이 가비지 컬렉션 시접을 전적으로 판단

자바의 패키지 개념
 패키지
 상호 관련 있는 클래스 파일(컴파일된 .class)을 저장하여 관리하는 디렉터리
 자바 응용프로그램은 하나 이사으이 패키지로 구성

접근 지정자
자바의 접근 지정자 4가지 :private, protected, public, 디폴트(접근 지정자 생략)
접근 지정자의 목적
  클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
  객체 지향 언어의 캡슐화 정책은 멤버를 보호하는 것
  -> 접근 지정은 캡슐화에 묶은 보호를 일부 해제할 목적으로 사용
접근 지정자에 따른 클래스나 멤버의 공개 범의

클래스 접근 지정
 다른 크랠스에서 사용하도록 허용할 지 지정
 public 클래스 : 다른 모든 클래스에게 접근 허용
 디폴트 클래스(접근 지정자 생략) : 같은 패키지의 클래스에만 접근 허용

메버 접근 지정
 ✔ public 멤버 : 패키지에 관계 없이 모든 클래스에게 접근 허용

✔ private 멤버 : 동일 클래스 내에만 접근 허용. 상속 받은 서브 클래스에서 접근 불가.

✔ protected 멤버 :
  ✔ 같은 패키지 내의 다른 모든 클래스에게 접근 허용
  ✔ 상속 받은 서브 클래스는 다른 패키지에 있어도 접근 가능

✔ 디폴트(default) 멤버 : 같은 패키지 내의 다른 클래스에게 접근 허용

static 멤버 선언
class StaticSample {
    int n;             // non-static 필드
    void g() {...}     // non-static 메소드

    static int m;      // static 필드
    static void f() {...}  // static 메소드
}

객체 생성과 non-static 멤버의 생성
→ non-static 멤버는 객체가 생성될 때, 객체마다 생긴다.
class A {
    int n;
    void g() {...}
}
A a1 = new A();
A a2 = new A();
A a3 = new A();
각 객체 a1, a2, a3 마다 n, g()의 non-static 멤버들이 생긴다.
non-static → 모든 객체에 멤버 생성
static → 멤버 공유!

static 멤보의 생성
 static 멤보는 클래스당 하나만 생성 
 객체들에 의해 공유됨

non-static vs static 멤버 비교 정리
static멤보와 non-static 멤버 특성 정리
 구분 | non-static 멤버 | static 멤버
선언 예시 | java<br>
class Sample {<br>i
nt n;
<br>void g() {...}<br>} | java<br>class Sample {<br>static int m;<br>static void f() {...}<br>}
공간적 특성 | - 객체마다 별도 존재- 인스턴스 멤버 | - 클래스당 하나 생성- 객체가 아닌 별도 공간에 생성- 클래스 멤버
시간적 특성 | - 객체 생성 시 멤버 생성- 객체가 사라지면 멤버도 소멸 | - 클래스 로딩 시 생성- 객체 없어도 사용 가능- 프로그램 종료 시 소멸
공유 특성 | - 공유되지 않음- 각 객체가 독립적으로 멤버 소유 | - 동일 클래스의 모든 객체가 공유

static 멤버 사용
클래스 이름으로 접근 가능
StaticSample.m = 3;   // 클래스 이름으로 static 필드 접근
StaticSample.f();     // 클래스 이름으로 static 메소드 호출

객체의 멤버로 접근 가능
StaticSample b1 = new StaticSample();

b1.m = 3;   // 객체 이름으로 static 필드 접근  
b1.f();     // 객체 이름으로 static 메소드 호출

non-static 멤버는 클래스 이름으로 접근 안 됨
StaticSample.n = 5;   // n은 non-static이므로 컴파일 오류  
StaticSample.g();     // g()는 non-static이므로 컴파일 오류

static의 활용
 전역 변수와 전역 함수를 만들 때 활용
 공유 멤버를 만들 때 : static으로 선언한 멤버는 클래스의 객체들 사이에 공유

static 메소드의 제약 조건 1
 static 메소드는 오직 static 멤버만 접근 가능
 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 멤버 활용 불가
 non-static 메소드는 static 멤버 사용 가능
 class StaticMethod {
    int n;
    void f1(int x) { n = x; }           // 정상
    void f2(int x) { m = x; }           // 정상
    static int m;

    static void s1(int x) { n = x; }    // 컴파일 오류: static 메소드는 non-static 필드 n 사용 불가 ❌
    static void s2(int x) { f1(3); }    // 컴파일 오류: static 메소드는 non-static 메소드 f1() 사용 불가 ❌
    static void s3(int x) { m = x; }    // 정상: static 메소드는 static 필드 m 사용 가능 ✅
    static void s4(int x) { s3(3); }    // 정상: static 메소드는 static 메소드 s3() 호출 가능 ✅
}


_____________________________
04/10 6주차
예회 클래스 사례
배열의 범위를 벗어나 원소를 접근하는 예회 처리
int intArray [] = new int[5];

try {
    intArray[3]; = 10; //예외 발생하지 않음
    intArray[6] = 5; //예외 발생
}

자바의 예외 클래스
    자바는 응용프로그램이 실행 중 오류를 탑지할 수 있도록 많은 예외를 
    클래스 형태로 제공

세상 모든 것이 객체다
  실 세계 객체의 특징
    객체마다 고유한 특성(state)와 행동(behavior)를 가짐
    다은 객체들과 정보를 주고 받는 등, 상호작용하면서 살아감
  컴퓨터 프로그램에서 객체 사례
    테트리스 게임의 각 블록들
    한글 프로그램의 메뉴나 버튼

자바의 객체 지향 특성 : 캡슐화
  캡슐와 : 객체를 갭슐로 싸서 내부를 볼 수 없게 하는 것
    객체의 가장 본질적인 특징
    외부의 접근으로부터 객체 보호
  자바의 갭슐화
    클래스(Class) : 객체 모양을 선언한 틀(캡슐롸라는 틀)
    객체 : 생성된 실체(instance) : 클래스 내에 메소드와 필드 구현

자바의 객체 지향 특성 : 상속
    상위 객체의 속성이 하위 객체에 물려줌
    하위 객체가 상위 객체의 속성을 모두 가지는 관계
  실세계의 상속 사례
    나무는 식물의 속성과 생물의 속성을 모두 가짐
    사람은 생물의 속성은 가지지만 식물의 속성은 가지고 있지 않음

자바의 객체 지향 특서 : 다향성
같은 이름의 메소드가 클래스 혹은 객체에 따라 다른게 구현
  다형성 사례
    메소드 오버로팅 : 한 클래스 내에서 같은 이름이지만 다르게 작동하는 여러 메소드
    메소드 오버라이팅 : 슈퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

객체 지향 언어의 목적

1.소프트웨어의 생산성 향상
    컴퓨터 산업 발전에 따라 소프트웨어의 생명 주기(life cycle) 단축
    소프트웨어를 빠른 속도로 생산할 필요성 증대

객체지향 언어
    상속, 다향성, 객체, 캡슐화 등 소프트웨어 재사용을 위한 여러 장치 내장
    소프트웨어 재사용과 부분 수정 빠름
    소프트웨어를 다시 만드는 부담 대폭 줄임
    소프트웨어 생산성 향상

절차 지향 프로그래밍과 객체 지향 프로그래밍
   절차 지향 프로그램
    작업 순서를 표현하는 컴퓨터 명령 집합
    함수들의 집합으로 프로그램 작성
   객체 지향 프로그래밍
    컴퓨터가 수행하는 작업을 객체들 간의 상호 작용으로 표현
    클래스 혹은 객체들의 집합으로 프로그램 작성

클래스와 객체
   크랠스 : 객체의 속성 과 행위 선언, 객체의 설계도 혹은 틀
   
   객체 : 클래스의 틀로 찍어낸 실체
    프로그램 실행 주에 생성되는 실체
    메모리 공간을 갖는 구체적인 실체
    인스터스 라고도 부름

자바 클래스 구성
    class 키워드로 선언
    멤버 : 클래스 구성 요소. 필드 (멤버 변수)와 메소드(멤버 함수)
    클래스에 대한 public 접근 지정 ㅣ 다른 모든 클래스에서 클래스 사용허락
    멤버에 대한 public 접근 지정 : 다른 모든 클래스에게 멤버 접근 허용

객체 생성과 활용
    1.레퍼런스 변수 선언
        Circle pizza;

    2.객체 생성
        new 연산자 이용
        pizza = new Circle();

    3. 객체 멤버 접근 
        점(.) 연산자 이용
        pizza.radius -10;
        area = pizza.getArea();

생성자 개념과 목적
    객체가 생성될 때 초기화 목적으로 실행되는 메소드
    객체가 생성되는 순간에 자동 호출

생성자의 특징

    생성자 이름은 크랠스 이름가 동일

    생성자는 여러 개 작성 가능(생정자 중복)
        
    생성자는 객체 생성시 한 번만 호출
       자바에서 객체 생성은 반드시 new 연산자로 함

    생성자의 목적은 객체 생성 시 초기화

    생성자는 리턴 타입을 지정할 수 없음







___________________________
04/03 5주차
자바 반목문 - for문 while문, do-while문
for문 예시
for(int i=0; i<10; i++>) {
    System.out.print(i);
}
while 문의 구성과 코드 사례: 조건식이 참인 동안 반복 실행

do - while문
do - while문 예시
do{
    System.out.print(i);
    i++;
}while(i<10;);

continue문 
반복문을 빠져 나가지 않고 다음 반복문으로 제어 변경

break문
반복문 하나를 즉시 벗어날 때 사용 하나의 반목문만 벗어남

자바 배열
1. 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조로 안 번에 많은 메모리 공간 선언

2. 같은 타입의 데이터들이 순차적으로 저장되는 공간으로 인덱스를 이용하여 원소 데이터접근

3. 반목문을 이용하여 처리하기에 전환한 자료구조

for문을 변형한 for-each문은 배열이나 나열의 크기만큼 루프를 돌면서, 각 원소를 순차적으로 접근하는데 매우 유용하며 일반적인 구조는 밑에와 같다
예시
for(변수(1) : 배열레퍼런스){
    .. 반목문작업문(2) ..
}

자바에서 여러 차원의 배열을 만들 수 있다 그러나 일반적으로 3차원 이상의 배열은 잘 사용하지 않기 때문에 이 책에서는 2차원 배열만 다룬다

1차원 배열
1차원 배열은 동일한 데이터 타입의 값을 순차적으로 저장할 수 있는 연속적인 메모리 공간이다 각값은 인덱스를 통해 접근 가능

2차원 배열
1차원 배열과 마찬가지로 2차원 배열에서도 래퍼런스 변스 선언 후 배열을 생성한다

메소드의 배열 리턴
배열의 레퍼런스만 리턴되며 배열 전체가 리턴되는 것이 아님

메소드의 리턴 타입
    리턴하는 배열 타입과 리턴 받는 대열 타입 일치
    20  리턴 타입에 배열의 크기를 정하지 않음

_____________________________
03/27 4주차
int packedData = (red <<16)|(green<< 8)|blue; //RGB 색상 데이터 압축

if문
if(조건식){
    실행문장 
}

else 문
if(조건식1){
    실행문장1;
}
else if(조건식2){
    실행문장2;
}
switch(식){
    case값1:
    실행문장 1; //식의 결과가 값1와 같을때
    break;
     case값2:   //식의 결과가 값2와 같을때
    실행문장 2; 
    break;
    default:    //어느 것과도 같지 않을때
    실행문장 n;
}

break문
간단하게 멈춤


___________________________________
03/20 3주차


______________________
03/13 2주차
______________________
# h1 
## h2
### h3
#### h4
##### h5
###### h6

______________________ (밑줄)

* 가가가

1. 가가가
2. 나나나

```java 
public static void main(String[] args) {		
	String str = "abcdefg12345";
	try {
		System.out.println("substring(10,20) : " + str.substring(10,20));
	} catch(StringIndexOutOfBoundsException e) {
		System.out.println("Error : "+e.getMessage());
	}		
}
```


``` c# //for문 16
using System;

class ForDescription
{
    static void Main()
    {
        // for (초기식;조건식;증감식) { }
        for (int i = 0; i < 3; i++) // i가 0, 1, 2일 때 
        {
            Console.WriteLine("안녕하세요."); // 안녕하세요 출력
        }
    }
}
```

```html //html for문
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <script>
        var sum = 0;

        for(1️⃣var i = 1; 2️⃣i < 101; 4️⃣i++){
            3️⃣sum += i;
        }
        document.write("1부터 100까지 더하면" + sum);
    </script>
    
</body>
</html>

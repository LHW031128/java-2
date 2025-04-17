<<<<<<< HEAD
이효원 202230130 <br>
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

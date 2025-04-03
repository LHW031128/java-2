<<<<<<< HEAD
이효원 202230130 <br>
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

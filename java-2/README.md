<<<<<<< HEAD
이효원 202230130 <br>
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

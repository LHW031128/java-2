public class Ex31ForSample {

    public static void main(String[] args) {  // "string" -> "String"으로 수정하고 중괄호 추가
        int i, sum = 0;

        for (i = 1; i <= 10; i++) {
            sum += i;  // sum에 1이 아니라 i 값을 더하도록 수정
            System.out.print(i);

            if (i <= 9) {
                System.out.print("+");  // "+"를 출력
            } else {
                System.out.print("=");  // i가 10일 때 "="를 출력
                System.out.print(sum);  // sum 출력
            }
        }
    }
}
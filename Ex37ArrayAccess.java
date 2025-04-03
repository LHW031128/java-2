import java.util.Scanner;

public class Ex37ArrayAccess {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int intArray[];
        intArray = new int[5];  // 크기가 5인 배열 선언
        int max = 0;  // 최대값 초기화
        System.out.println("양수 5개를 입력하세요");

        // 5번 반복하여 값 입력받기
        for (int i = 0; i < 5; i++) {
            intArray[i] = scanner.nextInt();  // 사용자가 입력한 값을 배열에 저장
            if (intArray[i] > max) {  // 입력한 값이 현재 최대값보다 크면 최대값을 갱신
                max = intArray[i];
            }
        }

        System.out.println("가장 큰 수는 " + max + "입니다");  // 가장 큰 수 출력

        scanner.close();  // Scanner 닫기
    }
}

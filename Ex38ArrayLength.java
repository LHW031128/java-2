import java.util.Scanner;

public class Ex38ArrayLength {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("5개의 정수를 입력하세요");
        int intArray[] = new int[5];  // 크기 5인 배열 선언
        double sum = 0.0;

        // 배열에 값 입력 받기
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();  // 배열에 값을 입력받음
        }

        // 배열의 합 계산하기
        for(int i = 0; i < intArray.length; i++) {
            sum += intArray[i];  // 배열 값 더하기
        }

        // 평균 출력
        System.out.println("평균은 " + sum / intArray.length);

        scanner.close();
    }
}

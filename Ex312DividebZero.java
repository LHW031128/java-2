import java.util.Scanner;

public class Ex312DividebZero {
    
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print("나뉨수를 입력하시요");
        dividend = scanner.nextInt();
        System.out.print("나눗수를 입력하시요");
        divisor = scanner.nextInt();
        System.out.println(dividend+"를 " +divisor+ "로 나누면 몫은"
        +dividend/divisor+"입니다");

    }
}

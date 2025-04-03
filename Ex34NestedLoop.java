public class Ex34NestedLoop {
    
    public static void main(String[] args) {
        // 1부터 9까지 반복
        for (int i = 1; i < 10; i++) {
            // 1부터 9까지 곱셈 결과 출력
            for (int j = 1; j < 10; j++) {
                System.out.print(j + "*" + i + "=" + i * j);
                System.out.print('\t'); // 결과 간격을 탭으로
            }
            System.out.println(); // 한 줄 끝난 후 줄바꿈
        }
    }
}

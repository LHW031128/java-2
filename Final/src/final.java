/*
 * 이 프로그램은 swing을 이용하여 스크롤 윈도우 패널에 
 * 구구단을 출력하는 간단한 프로그램입니다.
 */

// [문제1] swing 프로그램을 위해 필요한 컴포넌트 클래스 및 그래픽을 위한 클래스 import 해주세요.
import ;
import ;

public class Final extends JFrame {
    private JTextArea resultArea;

    public Final() {
        ; // [문제2] 타이틀에 '구구단 출력기'라고 나오도록 작성해 주세요.
        ; // [문제3] 윈도우의 크기를 정의 하세요. 크기는 500 x 400입니다.
        ; // [문제4] 윈도우 우측 상당의 X아이콘을 클릭하면 프로그램이 종료되도록 합니다.
        setLocationRelativeTo(null);

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 결과 출력 영역
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);

        printGugudan();
    }

    private void printGugudan() {
        // [문제5] 구구단을 2단에서 9단까지 출력할 수 있도록 반복문을 작성하세요.
        // 각 단마다 빈 줄을 추가해 주세요.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ; // [문제6] 결과 화면의 윈도우를 출력해 주세요.
            } 
        });
    }
}

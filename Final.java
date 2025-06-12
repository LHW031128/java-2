/**
 * 이 프로그램은 swing을 이용하여 스크롤 윈도우 패널에 
 * 구구단을 출력하는 간단한 프로그램입니다.
 */

// [문제1] swing 프로그램을 위해 필요한 컴포넌트 클래스 및 그래픽을 위한 클래스 import 해주세요.
import javax.swing.*;       
import java.awt.*;        

public class Final extends JFrame {
    private JTextArea resultArea;

    public Final() {
        super("구구단 출력기"); // [문제2] 타이틀에 '구구단 출력기'라고 나오도록 작성
        setSize(500, 400);       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [문제4] X 클릭 시 종료
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);

        printGugudan();
    }

    private void printGugudan() {
        // [문제5] 구구단 2단부터 9단까지 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 9; i++) {
            sb.append("[").append(i).append("단]").append("\n");
            for (int j = 1; j <= 9; j++) {
                sb.append(i).append(" x ").append(j).append(" = ").append(i * j).append("\n");
            }
            sb.append("\n"); 
        }
        resultArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Final().setVisible(true); // [문제6] 윈도우 출력
            }
        });
    }
}

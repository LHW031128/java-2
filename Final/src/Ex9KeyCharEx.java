import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex9KeyCharEx extends JFrame {
    private JLabel la = new JLabel("<Enter>키를 입력하세요!");

    public Ex9KeyCharEx() {
        super("KeyListener 문자 키 입력 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(la);
        c.addKeyListener(new MyKeyListener());
        setSize(250, 150);
        setVisible(true);

        c.setFocusable(true);        // 컨텐트팬이 포커스를 받을 수 있도록 설정
        c.requestFocus();           // 컨텐트팬에 포커스를 강제로 줌
    }

    class MyKeyListener extends KeyAdapter { // 키 리스너
        public void keyPressed(KeyEvent e) {
            int r = (int)(Math.random() * 256); // 0~255 사이의 임의의 red 성분
            int g = (int)(Math.random() * 256); // 0~255 사이의 임의의 green 성분
            int b = (int)(Math.random() * 256); // 0~255 사이의 임의의 blue 성분

            switch (e.getKeyChar()) { // 입력된 키 문자
                case '\n': // <Enter>키
                    la.setText("r=" + r + ", g=" + g + ", b=" + b);
                    getContentPane().setBackground(new Color(r, g, b)); // 컨텐트팬의 배경색 설정
                    break;
                case 'q': System.exit(0); // 프로그램 종료
            }
        }
    }

    public static void main(String[] args) {
        new Ex9KeyCharEx();
    }
}

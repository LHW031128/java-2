class Point2 {
    private int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}

public class Ex62ToStringEx {
    public static void main(String[] args) {
        Point2 a = new Point2(2, 3); // 수정된 표준 문법
        System.out.println(a.toString()); // 명시적 호출
        System.out.println(a);            // 자동 변환
    }
}

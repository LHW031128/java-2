abstract class Calculator {
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
}

public class GoodCalc extends Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double average(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (double) sum / a.length;
    }

    public static void main(String[] args) {
        GoodCalc calc = new GoodCalc();
        System.out.println("덧셈: " + calc.add(10, 5));
        System.out.println("뺄셈: " + calc.subtract(10, 5));
        System.out.println("평균: " + calc.average(new int[]{1, 2, 3, 4, 5}));
    }
}

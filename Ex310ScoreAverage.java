public class Ex310ScoreAverage {
    public static void main(String[] args){
        // 4년 간의 학기별 평점
        double score[][] = 
        {
            {3.3, 3.4},  // 1학년
            {3.5, 3.6},  // 2학년
            {3.7, 4.0},  // 3학년
            {4.1, 4.2}   // 4학년
        };
        
        double sum = 0;  // 평점 합계를 저장할 변수
        
        // 4년간, 각 학기의 평점을 합산
        for (int year = 0; year < score.length; year++) {
            for (int term = 0; term < score[year].length; term++) {
                sum += score[year][term];  // 평점 더하기
            }
        }

        // 전체 평균 계산
        int n = score.length;         // 년도의 수
        int m = score[0].length;      // 각 년도의 학기 수
        System.out.println("4년 전체 평점 평균은 " + sum / (n * m));  // 전체 평점 평균 출력
    }
}

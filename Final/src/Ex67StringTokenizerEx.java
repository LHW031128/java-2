import java.util.StringTokenizer;

public class Ex67StringTokenizerEx {
    public static void main(String[] args) {
        String query = "name=kit tae&addr=seoul&age=21";
        StringTokenizer st = new StringTokenizer(query, "&"); // '&' 기준으로 분리

        int n = st.countTokens(); // 분리된 토큰 개수
        System.out.println("토큰 개수 = " + n);

        while(st.hasMoreTokens()) {
            String token = st.nextToken();  // 토큰 얻기
            System.out.println(token);      // 토큰 출력
        }
    }
}

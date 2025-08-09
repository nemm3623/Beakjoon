import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        // N == 1 이면 while() 문에서 소인수 분해가 완전 종료
        // N != 1 이면 while() 문에서
        // 실행한 소수보다 더 작은 소수가 남아있음을 의미함으로
        // 나머지 몫을 출력
        if( N != 1)
            System.out.println(N);

    }
}

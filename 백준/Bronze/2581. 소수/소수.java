import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int M = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int min = M-1;

        for (int i = M; i <= N; i++) {

            if (i == 1)
                continue;

            boolean check = true;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result += i;
                if (min > i || min < M)
                    min = i;
            }
        }
        if (min < M)
            System.out.println(-1);
        else {
            System.out.println(result);
            System.out.println(min);
        }
    }
}

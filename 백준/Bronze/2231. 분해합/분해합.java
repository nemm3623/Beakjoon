import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int length = s.length();

        for (int i = Math.max(1, N - (9 * length)); i < N; i++) {
            int temp = i;
            int init = 0;

            for (int j = 0; j < length; j++) {
                init += temp % 10;
                temp /= 10;
            }

            if (init + i == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][41];

        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        int[] N = new int[T];

        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(br.readLine());

            for (int j = 2; j <= N[i]; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i : N)
            sb.append(dp[i][0]).append(" ").append(dp[i][1]).append("\n");

        System.out.println(sb);

    }
}

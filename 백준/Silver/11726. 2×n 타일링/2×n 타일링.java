import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][n + 1];
        buildCombination(n);

        int res = 0;
        for (int i = 1; i <= n / 2; i++) {
            int temp = n - i;
            res += dp[temp][i];
        }

        res = (res + 1) % 10007  ;
        System.out.println(res);

    }

    static void buildCombination(int n) {

        for (int i = 1; i <= n; i++) {

            dp[i][0] = dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

    }
}


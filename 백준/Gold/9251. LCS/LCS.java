import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static char[] A;
    static char[] B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        A = a.toCharArray();
        B = b.toCharArray();
        dp = new int[a.length() + 1][b.length() + 1];   // dp 조건식을 편하게 하기 위해 + 1

        solve();
        System.out.println(dp[a.length()][b.length()]);

    }

    static void solve() {

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else // 두 값이 같지 않으면 이전 값을 넣는다. 이렇게 함으로 이전에 같았던 값을 기억할 수 있음.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
}

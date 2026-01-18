import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static int[] tri;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        tri = new int[n*(n + 1) / 2 + 1];
        dp = new int[n*(n + 1) / 2 + 1];

        int tmp = 1;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i  ; j++) {
                tri[tmp++] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve());
    }

    static int solve() throws IOException {

        dp[1] = tri[1];

        int idx = 2;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i  ; j++, idx++) {
                if( j == 1)
                    dp[idx] = tri[idx] + dp[idx - i + 1];
                else if( j == i)
                    dp[idx] = tri[idx] + dp[idx - i];
                else
                    dp[idx] = tri[idx] + Math.max(dp[idx - i + 1], dp[idx - i]);
            }
        }

        int res = 0;
        for (int i = dp.length - n - 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

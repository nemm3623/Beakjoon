import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static int[][] house;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        house = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        System.out.println(solve());
    }

    static int solve() {
        for (int i = 1; i < n; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}

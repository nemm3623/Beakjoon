import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static int m;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        int[][] map = new int[n + 1][n + 1];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int aX = Integer.parseInt(st.nextToken());
            int aY = Integer.parseInt(st.nextToken());
            int bX = Integer.parseInt(st.nextToken());
            int bY = Integer.parseInt(st.nextToken());

            int res = 0;
            for(int j = aX; j <= bX; j++){
                res += map[j][bY] - map[j][aY - 1];
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

    }
}

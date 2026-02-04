import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int m;
    static StringTokenizer st;
    static int[][] res;
    static final int MAX = 100000 * 100;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        res = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(res[i], MAX);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            res[a][b] = Math.min(res[a][b],v);
        }

        solve();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int[] list = res[i];
            for (int j = 1; j < list.length; j++){
                if(list[j] >= MAX) sb.append(0).append(" ");
                else sb.append(list[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solve() {

        for (int i = 1; i <= n; i++) {
            res[i][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (res[j][i] == MAX || res[i][k] == MAX) continue;
                    res[j][k] = Math.min(res[j][k], res[j][i] + res[i][k]);
                }
            }
        }
    }
    }

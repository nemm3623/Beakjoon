import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int max = 0;
    static StringTokenizer st;
    static List<List<int[]>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }
        dfs(1);
        System.out.println(max);
    }

    static int dfs(int i) {


        int first = 0;
        int second = 0;

        visited[i] = true;

        List<int[]> list = adj.get(i);
        for (int[] a : list) {
            if (!visited[a[0]]) {
                int cur = dfs(a[0]) + a[1];

                if (cur > first) {
                    second = first;
                    first = cur;
                }
                else if(cur > second)
                    second = cur;
            }
        }
        max = Math.max(max, first + second);
        return first;
    }
}

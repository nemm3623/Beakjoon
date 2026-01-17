import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static StringBuilder sb;
    static StringTokenizer st;
    static List<List<Integer>> nodes;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        visited = new boolean[n + 1];
        nodes = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        sb = new StringBuilder();
        dfs(1);
        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i) {
        visited[i] = true;

        for (int n : nodes.get(i)) {
            if (!visited[n]) {
                dfs(n);
                parent[n] = i;
            }
        }
    }
}

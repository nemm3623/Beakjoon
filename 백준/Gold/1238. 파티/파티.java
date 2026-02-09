import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int m;
    static int x;
    static StringTokenizer st;
    static int[] go;
    static int[] back;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<List<int[]>> list = new ArrayList<>();
        List<List<int[]>> revList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            revList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, v});
            revList.get(b).add(new int[]{a, v});
        }

        go = solve(revList);
        back = solve(list);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, go[i] + back[i]);
        }
        System.out.println(res);
    }

    static int[] solve(List<List<int[]>> list) {
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{x, 0});
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            List<int[]> next = list.get(cur[0]);
            for (int[] n : next){
                if(dist[n[0]] > cur[1] + n[1]) {
                    dist[n[0]] = n[1] + cur[1];
                    pq.add(new int[]{n[0], dist[n[0]]});
                }
            }
        }
        return dist;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int v;
    static int e;
    static int k;
    static StringTokenizer st;
    static List<List<int[]>> adj;
    static int[] values;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        values = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
            values[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(values[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(values[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void dijkstra(int v) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        values[v] = 0;
        pq.add(new int[]{v, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            if(values[cur[0]] !=  cur[1]) continue;

            List<int[]> tmp = adj.get(cur[0]);
            for (int[] a : tmp) {
                int nextValue = cur[1] + a[1];
                if(values[a[0]] > nextValue) {
                    values[a[0]] = nextValue;
                    pq.add(new int[]{a[0], nextValue});
                }
            }
        }
    }
}

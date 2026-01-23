import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static int k;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

    }

    static void bfs(){

        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[100001];

        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(n);
        dist[n] = 0;
        while(!q.isEmpty()){
            int cur = q.pollFirst();

            if(cur == k){
                System.out.println(dist[cur]);
                return;
            }

            int next = cur * 2;
            if(next <= 100000 && dist[next] > dist[cur]){
                dist[next] = dist[cur];
                q.addFirst(next);
            }

            next = cur + 1;
            if(next <= 100000 && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                q.addLast(next);
            }

            next = cur - 1;
            if(next >= 0 && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                q.addLast(next);
            }
        }
    }
}

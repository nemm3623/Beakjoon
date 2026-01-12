import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k) {

        // 시작점 == 도착점이면 바로 0초
        if (n == k) return 0;

        Queue<State> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];

        q.offer(new State(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            int[] move = {cur.pos + 1, cur.pos - 1, cur.pos * 2};

            for (int next : move) {
                if (next < 0 || next > MAX) continue;   // 범위 체크
                if (visited[next]) continue;            // 이미 방문했으면 패스

                if (next == k) {
                    return cur.time + 1;                // 다음이 곧 K면 여기서 바로 리턴
                }

                visited[next] = true;
                q.offer(new State(next, cur.time + 1));
            }
        }

        return -1; // 이 문제에선 도달 못하는 경우는 없지만 형식상
    }

    static class State {
        int pos;
        int time;

        public State(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[] arrX = {1,-1,0,0};
    static int[] arrY = {0,0,1,-1};
    static int[][] arr;
    static int[][] res;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        res = new int[n][m];

        int targetX = 0;
        int tagretY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    targetX = i;
                    tagretY = j;
                }
            }
        }

        bfs(targetX, tagretY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 1 && !visited[i][j])
                    sb.append(-1).append(" ");
                else sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int x, int y) {

        Queue<State> q = new LinkedList<>();

        q.add(new State(x, y));
        visited[x][y] = true;
        res[x][y] = 0;

        while (!q.isEmpty()) {

            State cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + arrX[k];
                int ny = cur.y + arrY[k];

                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;
                if(visited[nx][ny] || arr[nx][ny] == 0) continue;


                visited[nx][ny] = true;
                q.add(new State(nx, ny));

                res[nx][ny] = res[cur.x][cur.y] + 1;

            }
        }
    }

    static class State {
        int x;
        int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

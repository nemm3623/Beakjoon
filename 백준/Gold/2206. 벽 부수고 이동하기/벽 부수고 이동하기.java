import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][][] mapV;
    static int[] listX = new int[]{1, -1, 0, 0};
    static int[] listY = new int[]{0, 0, 1, -1};

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        mapV = new int[n + 1][m + 1][2];

        for (int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = arr[j - 1] - '0';
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {

        for (int[][] m : mapV)
            for (int[] x : m)
                Arrays.fill(x, INF);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0});
        mapV[1][1][0] = 1;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];
            int cost = mapV[x][y][broken];

            if(x == n && y == m)
                return cost;

            for (int i = 0; i < listX.length ; i++) {

                int nextX = x + listX[i];
                int nextY = y + listY[i];


                if( nextX < 1 || nextX > n || nextY < 1 || nextY > m)
                    continue;

                if (map[nextX][nextY] == 0 && mapV[nextX][nextY][broken] > cost + 1) {
                        q.offer(new int[]{nextX, nextY, broken});
                        mapV[nextX][nextY][broken] = cost + 1;
                }

                else if (map[nextX][nextY] == 1 && broken == 0 && mapV[nextX][nextY][1] > cost + 1) {
                        q.offer(new int[]{nextX, nextY, 1});
                        mapV[nextX][nextY][1] = cost + 1;
                }
            }
        }

        return -1;
    }
}

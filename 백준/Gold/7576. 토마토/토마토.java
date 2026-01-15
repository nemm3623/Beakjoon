import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int result = bfs(queue, matrix);

        System.out.println(result);
    }

    static int bfs(Queue<int[]> queue, int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];


        for (int[] pos : queue) {
            visited[pos[0]][pos[1]] = true;
        }

        int maxDay = 0;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], day = cur[2];
            maxDay = Math.max(maxDay, day);

            for (int i = 0; i < 4; i++) {
                int x = cx + moveX[i];
                int y = cy + moveY[i];

                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                    continue;
                if (matrix[x][y] == -1 || visited[x][y])
                    continue;

                queue.add(new int[]{x, y, day + 1});
                visited[x][y] = true;
            }
        }

        // 방문하지 못한 0이 있는지 체크
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return maxDay;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] moveX = {0, 1, 0, -1,};
    static int[] moveY = {1, 0, -1, 0,};

    static boolean[][] visited;
    static int[][] count;

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
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs(queue, matrix);


        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && matrix[i][j] == 0 ) {
                    System.out.println(-1);
                    return;
                }
                if(res < count[i][j])
                    res = count[i][j];
            }
        }

        System.out.println(res);
    }

    static void bfs(Queue<int[]> queue, int[][] matrix) {
         visited = new boolean[matrix.length][matrix[0].length];
        count = new int[matrix.length][matrix[0].length];

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + moveX[i];
                int y = cur[1] + moveY[i];



                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                    continue;
                if (matrix[x][y] == -1 || matrix[x][y] == 1 || visited[x][y])
                    continue;

                queue.add(new int[]{x, y});
                visited[x][y] = true;
                count[x][y] = count[cur[0]][cur[1]] + 1;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static boolean[][] chess;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        chess = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i][j] = line.charAt(j) == 'W';
            }
        }

        int res = 64;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                res = Math.min(res, func(i,j));
            }
        }

        System.out.println(res);
    }

    static int func(int x, int y) {
        int endX = x + 7;
        int endY = y + 7;
        int count = 0;

        boolean start = chess[x][y];

        for (int i = x; i <= endX; i++) {
            for (int j = y; j <= endY; j++) {
                if (start != chess[i][j]) {
                    count++;
                }
                start = !start;
            }
            start = !start;
        }

        return Math.min(count, 64 - count);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int res = 0;
    static int check = 0;

    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < T; l++) {

            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }


            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (field[i][j] == 0 || visited[i][j]) continue;

                    res++;
                    func(i, j, m, n);
                }
            }
            sb.append(res).append("\n");
            res = 0;
            check = 0;
        }

        System.out.print(sb);
    }

    static void func(int x, int y, int m, int n){

        if( x >= m || y >= n || y < 0 || x <0) return;

        if (field[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true;
        func(x, y+1, m, n);
        func(x, y-1, m, n);
        func(x+1, y, m, n);
        func(x-1, y, m, n);

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static int[][] stickers;
    static StringTokenizer st;
    static StringBuilder sb;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp();
        }
        System.out.println(sb);
    }

    static void dp() {

        if( n == 1){
            sb.append(Math.max(stickers[0][0],stickers[1][0])).append("\n");
        }
        else {
            int[][] res = new int[2][n];
            res[0][0] = stickers[0][0];
            res[1][0] = stickers[1][0];
            res[0][1] = stickers[0][1] + res[1][0];
            res[1][1] = stickers[1][1] + res[0][0];


            for (int i = 2; i < n; i++) {
                res[0][i] = stickers[0][i] + Math.max(res[1][i - 2], res[1][i - 1]);
                res[1][i] = stickers[1][i] + Math.max(res[0][i - 2], res[0][i - 1]);
            }

            sb.append(Math.max(res[0][n - 1], res[1][n - 1])).append("\n");
        }
    }
}

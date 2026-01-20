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
            return;
        }

        int up0 = stickers[0][0];
        int down0 = stickers[1][0];
        int up1 = stickers[0][1] + down0;
        int down1 = stickers[1][1] + up0;


        for (int i = 2; i < n; i++) {
            int newUp = stickers[0][i] + Math.max(down0, down1);
            int newDown = stickers[1][i] + Math.max(up0, up1);

            up0 = up1;
            up1 = newUp;
            down0 = down1;
            down1 = newDown;
        }

        sb.append(Math.max(up1,down1)).append("\n");

    }
}

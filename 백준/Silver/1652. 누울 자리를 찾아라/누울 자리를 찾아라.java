import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int widthCount = 0;
        int heightCount = 0;

        // 가로 방향
        for (int i = 0; i < N; i++) {
            int empty = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') empty++;
                else empty = 0;

                if (empty == 2) widthCount++;
            }
        }

        // 세로 방향
        for (int j = 0; j < N; j++) {
            int empty = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == '.') empty++;
                else empty = 0;

                if (empty == 2) heightCount++;
            }
        }

        System.out.println(widthCount + " " + heightCount);
    }
}

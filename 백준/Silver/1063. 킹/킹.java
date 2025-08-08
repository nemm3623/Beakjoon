import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // 방향 매핑
    static Map<String, int[]> direction = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String[] arr = first.split(" ");

        String A = arr[0];
        String B = arr[1];
        int N = Integer.parseInt(arr[2]);

        int[] king = new int[]{A.charAt(0), A.charAt(1)};
        int[] stone = new int[]{B.charAt(0), B.charAt(1)};

        direction.put("R",  new int[]{1, 0});
        direction.put("L",  new int[]{-1, 0});
        direction.put("B",  new int[]{0, -1});
        direction.put("T",  new int[]{0, 1});
        direction.put("RT", new int[]{1, 1});
        direction.put("LT", new int[]{-1, 1});
        direction.put("RB", new int[]{1, -1});
        direction.put("LB", new int[]{-1, -1});

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int dx = direction.get(move)[0];
            int dy = direction.get(move)[1];

            int nx = king[0] + dx;
            int ny = king[1] + dy;

            // 킹이 보드 안에 있는지
            if (inBoard(nx, ny)) {
                if (nx == stone[0] && ny == stone[1]) {
                    int nsx = stone[0] + dx;
                    int nsy = stone[1] + dy;

                    if (inBoard(nsx, nsy)) {
                        king[0] = nx; king[1] = ny;
                        stone[0] = nsx; stone[1] = nsy;
                    }
                } else {
                    king[0] = nx; king[1] = ny;
                }
            }
        }

        System.out.println("" + (char)(king[0]) + (char)king[1]);
        System.out.println("" + (char)stone[0] + (char)stone[1]);

    }

    static boolean inBoard(int x, int y) {
        return x > 64 && x < 73 && y > 48 && y < 57;
    }

}

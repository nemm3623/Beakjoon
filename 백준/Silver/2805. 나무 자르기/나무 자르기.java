import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int min = 0;
        int result = 0;

        while (min <= max) {

            int average = (min + max) / 2;
            long res = 0;

            for (int h : trees) {
                if (h > average) {
                    res += h - average;
                }
            }

            if (res >= M) {         // M 이상이면 이 높이는 가능
                result = average;   // 후보 저장
                min = average + 1;  // 더 큰 높이 도전
            } else {
                max = average - 1;  // 나무 부족 → 높이 낮추기
            }
        }

        System.out.println(result);
    }
}

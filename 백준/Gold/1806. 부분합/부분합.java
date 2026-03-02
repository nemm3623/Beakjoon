import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int s;
    static int[] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());

    }

    static int solve() {

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (true) {

            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
                sum -= arr[left++];
            }
            else {
                if (right == n) break;
                sum += arr[right++];
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
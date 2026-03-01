import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static long[] arr;
    static StringTokenizer st;

    static int min;
    static int mid;
    static int max;
    static long sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solve();

        System.out.println(arr[min] + " " + arr[mid] + " " + arr[max]);
    }

    static void solve() {

        sum = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int x = i + 1;
            int y = n - 1;
            while (x < y) {

                long temp = arr[i] + arr[x] + arr[y];

                if (sum > Math.abs(temp)) {
                    sum = Math.abs(temp);
                    min = i;
                    mid = x;
                    max = y;
                }

                if (temp < 0)
                    x++;
                else if (temp > 0)
                    y--;
                else
                    return;
            }
        }
    }
}
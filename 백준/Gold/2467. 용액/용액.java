import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static StringTokenizer st;
    static int[] arr;
    static int resMin;
    static int resMax;
    static long res = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = n - 1;

        while (min < max) {

            int tmp = Math.abs(arr[min] + arr[max]);


            if (res > tmp) {
                res = tmp;
                resMin = min;
                resMax = max;
            }

            int sum = arr[min] + arr[max];
            if (sum > 0)
                max--;
            else if (sum < 0)
                min++;
            else
                break;

        }

        System.out.println(arr[resMin] + " " + arr[resMax]);

    }
}

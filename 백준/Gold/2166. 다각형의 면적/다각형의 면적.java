import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static StringTokenizer st;
    static double[] x;
    static double[] y;
    static Double res = 0.0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        x = new double[n];
        y = new double[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }

        double tempA = 0;
        double tempB = 0;
        for (int i = 0; i < n - 1; i++) {
            tempA += (x[i] * y[i + 1]);
            tempB += (y[i] * x[i + 1]);

        }

        tempA += x[n-1] * y[0];
        tempB += y[n-1] * x[0];

        res = Math.abs(tempA - tempB) / 2;
        System.out.printf("%.1f\n", res);
    }
}

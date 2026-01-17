import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(divide(A,B,C));
    }

    static long divide(long A, long B, long C) {
        if(B == 0) return 1 % C;
        if(B == 1) return A % C;

        long half = divide(A,B / 2,C);
        long res = (half * half) % C;

        if(B % 2 == 1) res = (res * A) % C;

        return res;
    }
}

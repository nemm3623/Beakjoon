import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tracking(n,m,0,0);
    }

    private static void tracking(int n, int m, int num, int length) {
        if(length == m) {
            System.out.println(sb);
            return;
        }

        for (int i = num + 1; i <= n; i++) {
            sb.append(i).append(" ");
            tracking(n,m,i,length + 1);
            sb.delete(sb.length()-2,sb.length());
        }
    }
}

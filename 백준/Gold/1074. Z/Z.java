import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(N, r, c));
        
    }
    
    static int func(int N, int r, int c){

        if(N == 0)
            return 0;

        int half = 1 << (N - 1);
        int block = half * half;

        if( half > r && half > c ) {
            return func(N - 1, r, c);
        }
        else if( half > r && half <= c) {
            return 1 * block + func(N - 1, r, c - half);
        }
        else if( half <= r && half > c ) {
            return 2 * block + func(N - 1, r - half, c);
        }
        else {
            return 3 * block + func(N - 1, r - half, c- half);
        }
    }
}

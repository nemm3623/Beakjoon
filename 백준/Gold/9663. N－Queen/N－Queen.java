import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int n;
    static int[] queens;
    static int res;
    static boolean[] col;
    static boolean[] incL;
    static boolean[] incR;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queens = new int[n];
        col = new boolean[n];
        incL = new boolean[2 * n - 1];
        incR = new boolean[2 * n - 1];


        for (int i = 0; i < n / 2; i++) {
            queens[0] = i;
            col[i] = incL[i] = incR[(-i) + n - 1] = true;
            solve(0);
            col[i] = incL[i] = incR[(-i) + n - 1] = false;
        }

        res *= 2;

        if( n % 2 == 1){
            int num = n / 2;
            queens[0] = num;
            col[num] = incL[num] = incR[(-num) + n - 1] = true;
            solve(0);
        }

        System.out.println(res);
    }

    static void solve(int i) {

        if( i == n - 1) {
            res++;
            return;
        }

        for(int k = 0; k < n ; k++) {
            int left = i + 1 + k;
            int right = (i + 1 - k) + (n - 1);

            if(col[k] || incL[left] || incR[right]) continue;

            queens[i + 1] = k;

            col[k] = incL[left] = incR[right] = true;

            solve(i+1);

            col[k] = incL[left] = incR[right] = false;
        }
    }

//    static boolean promising(int i){
//
//        return !col[i] && !incL[i + queens[i]] && !incR[i - queens[i] + (n - 1)];
////        for ( int k = 0; k < i; k++){
////            if( queens[k] == queens[i] || Math.abs(queens[i] - queens[k]) == Math.abs(i - k))
////                return false;
////        }
//    }
}

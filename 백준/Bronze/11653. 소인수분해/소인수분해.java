import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(isNotPrime[i])
                continue;
            for (int j = i*i; j <= N; j += i) {
                isNotPrime[j] = false;
            }
        }

        int i = 2;

        while (N > 1) {
            if(!isNotPrime[i] && N % i == 0){
                System.out.println(i);
                N /= i;
                i = 2;
                continue;
            }
            i++;
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int N = 64;
        int count = 1;

        while (X != N){

            if(X < N)
                N = N/2;
            else {
                X -= N;
                count++;
            }
        }

        System.out.println(count);
        
    }
}

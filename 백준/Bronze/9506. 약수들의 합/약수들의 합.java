import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while(true) {

            String input = br.readLine();

            int result = 0;
            int n = Integer.parseInt(input);

            if(n == -1)
                return;

            StringBuilder builder = new StringBuilder();

            for(int i = 1; i <= n/2; i++) {
                if( n % i == 0){
                    if( i == 1)
                        builder.append(i);
                    else
                        builder.append(" + ").append(i);
                    result += i;
                }
            }

            if(result == n)
                System.out.println( n + " = " + builder);
            else
                System.out.println( n + " is NOT perfect.");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] str = input.split(" ");
        int N = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);

        StringBuilder sb = new StringBuilder();

        while (N > 0) {

            int remainder = N % B;

            if(remainder < 10)
                sb.append(remainder);
            else
                sb.append((char)(remainder - 10 + 65));
            
            N /= B;
        }

        sb.reverse();
        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if(N % i == 0 && ++count == K) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}

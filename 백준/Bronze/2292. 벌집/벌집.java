import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int i = 1;
        int min = 1;
        int count = 1;

        while(min < N){
            min += 6 * i++;
            count++;
        }

        System.out.println(count);

    }
}

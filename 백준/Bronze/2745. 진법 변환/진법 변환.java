import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");

        String N = split[0];
        int B = Integer.parseInt(split[1]);
        int len = N.length()-1;
        int result = 0;
        for (int i = 0; i < N.length(); i++) {
            int n = Integer.parseInt(String.valueOf(N.charAt(i)),B);
            result += n * (int)(Math.pow(B,len--));
        }
        System.out.println(result);
    }
}

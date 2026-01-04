import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        String line = br.readLine();

        double result = 0;

        for (int i = 0; i < L; i++) {
            result += ((line.charAt(i) - 96) * Math.pow(31, i)) % 1234567891;
        }
        System.out.println((int)result);
    }
}

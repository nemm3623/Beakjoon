import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        Arrays.sort(input, Main::compare);

        sb.append(input[0]).append("\n");
        for (int i = 1; i < n; i++) {
            if(!input[i].equals(input[i-1]))
                sb.append(input[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static int compare(String a, String b) {
        int A = a.length();
        int B = b.length();

        if (A != B)
            return A - B;
        else
            return a.compareTo(b);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer sizes = new StringTokenizer(br.readLine());

        StringTokenizer bundles = new StringTokenizer(br.readLine());

        int totalShirts = 0;
        int T = Integer.parseInt(bundles.nextToken());
        int P = Integer.parseInt(bundles.nextToken());

        while (sizes.hasMoreTokens()) {
            int size = Integer.parseInt(sizes.nextToken());

            if(size == 0) continue;

            if (size % T == 0) totalShirts += size / T;
            else if (size % T > 0 ) totalShirts += (size / T) + 1;

        }

        sb.append(totalShirts).append("\n").append(n / P).append(" ").append(n % P).append("\n");
        System.out.println(sb);
        br.close();
    }
}

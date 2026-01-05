import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noSee = new HashSet<>(N);
        List<String> res = new ArrayList<>(Math.min(N,M));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            noSee.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (noSee.contains(s)) {
                res.add(s);
            }
        }

        res.sort(String::compareTo);

        sb.append(res.size()).append('\n');
        for(String s : res)
            sb.append(s).append('\n');
        
        System.out.print(sb);
    }
}

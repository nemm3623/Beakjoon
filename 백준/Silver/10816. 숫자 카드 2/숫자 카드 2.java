import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arrN = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrN.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());


        List<Integer> arrM = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            arrM.add(Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Long> res = arrN.stream().collect(
                Collectors.groupingBy( n -> n, Collectors.counting()));

        arrM.stream().mapToLong(m-> res.getOrDefault(m, 0L))
                .forEach(num -> sb.append(num).append(" "));

        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;   // ★ 추가

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());  

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sorted.size(); i++) {
            if (map.size() != i) map.putIfAbsent(sorted.get(i), map.size());
            else map.putIfAbsent(sorted.get(i), i);
        }

        List<Integer> result = list.stream()
                .map(map::get)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String nextLine = br.readLine();
            set.add(nextLine);
        }

        List<String> list = new ArrayList<>(set);
        
        list.sort(Main::compare);

        for(String s : list)
            sb.append(s).append("\n");

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

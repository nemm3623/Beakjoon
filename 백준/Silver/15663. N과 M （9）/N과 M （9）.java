import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static List<Integer> list;
    static StringBuilder sb;
    static int[] res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);

        sb = new StringBuilder();
        res = new int[m];
        visited = new boolean[n];
        divide(n,m,0);
    }

    static void divide(int n, int m, int depth){
        if(depth == m){
            for(int i = 0; i < m; i++)
                sb.append(res[i]).append(i == m-1 ? "\n" : " ");
            System.out.print(sb);
            sb.setLength(0);
        }else {
            int prev = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = list.get(i);
                if (visited[i]) continue;
                if (num == prev) continue;
                prev = num;

                visited[i] = true;
                res[depth] = num;
                divide(n, m, depth + 1);
                visited[i] = false;
            }

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n;
    static Map<String, String[]> tree;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        sb = new StringBuilder();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.put(st.nextToken(),
                    new String[]{st.nextToken(), st.nextToken()});
        }

        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");
        System.out.println(sb);
    }

    static void preOrder(String s) {
        String[] arr = tree.get(s);

        sb.append(s);
        if (!arr[0].equals(".")) preOrder(arr[0]);
        if (!arr[1].equals(".")) preOrder(arr[1]);
    }

    static void inOrder(String s) {
        String[] arr = tree.get(s);

        if (!arr[0].equals(".")) inOrder(arr[0]);
        sb.append(s);
        if (!arr[1].equals(".")) inOrder(arr[1]);
    }

    static void postOrder(String s) {
        String[] arr = tree.get(s);

        if (!arr[0].equals(".")) postOrder(arr[0]);
        if (!arr[1].equals(".")) postOrder(arr[1]);
        sb.append(s);
    }
}

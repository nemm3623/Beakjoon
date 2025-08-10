import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int top = 0;
        int[] stack = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack[++top] = x;
                    break;
                case "pop":
                    sb.append(top == 0 ? -1 : stack[top--]).append("\n");
                    break;
                case "size":
                    sb.append(top).append("\n");
                    break;
                case "empty":
                    sb.append(top == 0 ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(top == 0 ? -1 : stack[top]).append("\n");
                break;
            }
        }

        System.out.println(sb);
    }
}

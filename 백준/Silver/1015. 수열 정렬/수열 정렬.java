import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String num = br.readLine();
        int[] arrA = Arrays.stream(num.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arrB = arrA.clone();
        Arrays.sort(arrB);

        boolean[] visited = new boolean[N];

        int[] P = new int[N];
        for (int i = 0; i < N; i++)
            P[i] = indexOf(arrB, arrA[i], visited);

        StringBuilder sb = new StringBuilder();
        for (int val : P) {
            sb.append(val).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static int indexOf(int[] arr, int val, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val && !visited[i]){
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
}

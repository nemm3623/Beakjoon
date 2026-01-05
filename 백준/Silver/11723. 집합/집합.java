import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] S = new int[21];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder(n);

//        List<Integer> S = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {

                case "add":
                    add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove":

                    remove(Integer.parseInt(st.nextToken()));
                    break;

                case "check":
                    check(Integer.parseInt(st.nextToken()));
                    break;

                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()));
                    break;

                case "all":
                    all();
                    break;

                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    static void add(int a){
        if(S[a] == 0)
            S[a] = a;
    }

    static void remove(int a){
        if(S[a] != 0)
            S[a] = 0;
    }

    static void check(int a){
        if(S[a] == a)
            sb.append("1").append('\n');
        else
            sb.append("0").append('\n');
    }

    static void toggle(int a){
        if(S[a] == 0)
            S[a] = a;
        else
            S[a] = 0;
    }

    static void all(){
        for (int i = 1; i < S.length; i++) {
            S[i] = i;
        }
    }

    static void empty(){
        for (int i = 1; i < S.length; i++) {
            S[i] = 0;
        }
    }
}

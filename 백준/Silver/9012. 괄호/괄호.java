import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int vps = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(') {
                    vps++;
                }
                else {
                    vps--;
                }
                if(vps < 0 || vps > chars.length - 1 - j){
                    sb.append("NO\n");
                    break;
                }
            }
            if(vps == 0)
                sb.append("YES\n");
            vps = 0;
        }
        System.out.println(sb);
    }
}

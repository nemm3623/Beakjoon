import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> distances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] num = br.readLine().split(" ");
            int distance = Integer.parseInt(num[1]) - Integer.parseInt(num[0]);
            distances.add(distance);
        }

        for (int distance : distances) {
            int t = (int)Math.sqrt(distance);
            int check = distance - (t*t);
            
            if (t*t == distance)
                System.out.println((2*t-1));
            else if(check <= t)
                System.out.println(2*t);
            else
                System.out.println((2*t+1));
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = br.readLine()) != null){

            String[] split = input.split(" ");
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);

            if(first == 0 || second == 0)
                continue;

            if (second % first == 0) {
                System.out.println("factor");
            }else if(first % second == 0){
                System.out.println("multiple");
            }else {
                System.out.println("neither");
            }
        }



    }

    static boolean isFactorOrMultiple(int first, int second) {
        return first % second == 0;
    }

}

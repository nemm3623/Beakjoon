import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("0 0 0")) break;

            String[] tokens = input.split(" ");

            List<Double> list = new ArrayList<>();

            for (String token : tokens)
                list.add(Double.parseDouble(token));

            list.sort(Double::compareTo);

            if(Math.pow(list.get(2),2) == (Math.pow(list.get(0),2) + Math.pow(list.get(1),2)))
                System.out.println("right");
            else
                System.out.println("wrong");

        }
    }
}

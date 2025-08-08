import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int Quarter = 25;
    static final int Dime = 10;
    static final int Nickel = 5;
    static final int Penny = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            int count_quarter = 0;
            int count_dime = 0;
            int count_nickel = 0;
            int count_penny = 0;

            while(C > 0){
                if(C >= Quarter){
                    C -= Quarter;
                    count_quarter++;
                }
                else if(C >= Dime){
                    C -= Dime;
                    count_dime++;
                }
                else if(C >= Nickel){
                    C -= Nickel;
                    count_nickel++;
                }
                else if(C >= Penny){
                    C -= Penny;
                    count_penny++;
                }
            }

            System.out.println(count_quarter + " " + count_dime + " "
                    + count_nickel + " " + count_penny);
        }

    }
}

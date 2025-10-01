import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int count, result, w, e;

        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt();

        for( int i =0; i<count; i++){
            result = 1;
            w = scanner.nextInt();
            e = scanner.nextInt();
            for (int j = 1; j <= w ; j++) {
                result *= e--;
                result /= j;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
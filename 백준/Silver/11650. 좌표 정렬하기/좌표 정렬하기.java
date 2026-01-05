import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Coordinate> coordinates = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates.add(new Coordinate(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        coordinates.sort(Comparator.comparingInt(Coordinate::getX)
                .thenComparingInt(Coordinate::getY));

        StringBuilder sb = new StringBuilder( n * 5);

        for (Coordinate coordinate : coordinates) {
            sb.append(coordinate.x).append(' ').append(coordinate.y).append('\n');
        }

        System.out.print(sb);

    }

//    버전이 맞지 않아 record 클래스 사용불가
//    public record Coordinate(
//            int x,
//            int y)
//    { }

    public static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }
    }

}

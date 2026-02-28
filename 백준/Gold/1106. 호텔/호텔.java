import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int c;
    static int n;
    static StringTokenizer st;
    static List<City> cities;
    static int[] dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cities = new ArrayList<>(n);
        dp = new int[c + 101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            City city = new City(value, people);
            cities.add(city);
        }

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (City city : cities) {
            for (int i = city.people; i <= c + 100; i++) {
                if (dp[i - city.people] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - city.people] + city.value);
                }
            }
        }

        int res = INF;
        for (int i = c; i < c + 100; i++) {
            res = Math.min(res, dp[i]);
        }

        System.out.println(res);
    }

    static class City{
        int value;
        int people;

        public City(int value, int people) {
            this.value = value;
            this.people = people;
        }
    }
}

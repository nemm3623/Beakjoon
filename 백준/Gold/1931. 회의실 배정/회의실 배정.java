import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;

        List<Meeting> meetings = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        meetings.sort(Comparator.comparingInt(Meeting::getEnd).thenComparingInt(Meeting::getStart));

        System.out.println(func(meetings));
    }

    static int func(List<Meeting> meetings) {

        List<Meeting> res = new ArrayList<>();
        int currentStart;
        int currentEnd = 0;

        for (Meeting m : meetings) {
            int start = m.getStart();

            if(currentEnd > start) continue;

            currentStart = start;
            currentEnd = m.getEnd();

            res.add(new Meeting(currentStart, currentEnd));
        }
        return res.size();
    }

    static class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart(){ return start; }
        public int getEnd(){ return end;}
    }

}

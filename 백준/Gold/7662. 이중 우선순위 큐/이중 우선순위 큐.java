import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
                DePriorityQueue dpq = new DePriorityQueue();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                long num = Integer.parseInt(st.nextToken());
                switch (ch) {
                    case 'I':
                        dpq.add(num);
                        break;
                    case 'D':
                        if (num == 1)
                            dpq.deleteLast();
                        else
                            dpq.deleteFirst();
                        break;
                }
            }
            if(dpq.getSize() == 0) sb.append("EMPTY");
            else sb.append(dpq.getLast()).append(' ').append(dpq.getFirst());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static public class  DePriorityQueue {
        private final TreeMap<Long, Integer> map = new TreeMap<>();
        private int size = 0;

        void add(long x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            size++;
        }

        void deleteFirst() { // 최소값 삭제
            if (size == 0) return;
            long key = map.firstKey();
            int cnt = map.get(key);
            if (cnt == 1) map.remove(key);
            else map.put(key, cnt - 1);
            size--;
        }

        void deleteLast() { // 최대값 삭제
            if (size == 0) return;
            long key = map.lastKey();
            int cnt = map.get(key);
            if (cnt == 1) map.remove(key);
            else map.put(key, cnt - 1);
            size--;
        }

        long getFirst() { return map.firstKey(); }
        long getLast() { return map.lastKey(); }
        int getSize() { return size; }
    }

}

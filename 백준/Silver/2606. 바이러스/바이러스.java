import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    static class Node {

        private int from;
        private int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<Node> nodes = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes.add(new Node(from, to));

        }

        nodes.sort(Comparator.comparingInt(Node::getFrom).thenComparingInt(Node::getTo));

        Kruskal kruskal = new Kruskal(N);

        System.out.println(kruskal.func(nodes));

    }

    public static class Kruskal{

        static int[] arr;

        public Kruskal(int N){
            arr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = i;
            }
        }

        long func(List<Node> nodes) {

            for (Node node : nodes) {
                if(find(node.from) != find(node.to)){
                    union(node.from, node.to);
                }
            }

            int rootOne = find(1);
            
            return IntStream.of(arr).filter(n -> find(n) == rootOne).count() - 1;

        }

        int find(int m) {
            if(m == arr[m])
                return m;

            return arr[m] = find(arr[m]);
        }

         void union(int m, int n) {
            m = find(m);
            n= find(n);

            if(m != n)
                arr[n] = m;
        }
    }
}



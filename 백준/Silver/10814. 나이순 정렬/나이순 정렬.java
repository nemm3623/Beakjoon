import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members.add(new Member(name,age));
        }

        StringBuilder sb = new StringBuilder();

        members.sort(Comparator.comparingInt(a -> a.age));

        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.print(sb);
    }

    public static class Member{

        String name;
        int age;

        public Member(String name, int age){
            this.name = name;
            this.age = age;
        }

    }
}

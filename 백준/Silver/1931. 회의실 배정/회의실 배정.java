import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Room> pq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            pq.add(new Room(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }
        pq.sort((o1, o2) -> o1.finish==o2.finish?o1.start-o2.start: o1.finish-o2.finish);
        int cnt = 1;
        int endTime = pq.get(0).finish;
        for (int i = 1; i < pq.size(); i++) {
            if (endTime <= pq.get(i).start) {
                endTime = pq.get(i).finish;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static class Room{
        int start;
        int finish;

        public Room(int parseInt, int parseInt1) {
            start = parseInt;
            finish = parseInt1;
        }
    }
}

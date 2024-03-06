import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) ->  o1.x!=o2.x?o1.x-o2.x:o1.y-o2.y));
    static PriorityQueue<Integer> room = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            pq.add(new Point(x,y));
        }
        while (!pq.isEmpty()) {
            Point plan = pq.remove();
            if (room.isEmpty()) {
                room.add(plan.y);
            } else if (plan.x>=room.peek()) {
                room.remove();
                room.add(plan.y);
            }else{
                room.add(plan.y);
            }
        }
        System.out.println(room.size());

    }
}

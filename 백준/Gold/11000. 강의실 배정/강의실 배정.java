import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> temp = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> {return o1.x-o2.x;}));
        PriorityQueue<Integer> room = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            pq.add(new Point(x, y));
        }
        int cnt = 0 ;
        room.add(pq.poll().y);
        while (!pq.isEmpty()) {
            Point pick = pq.poll();
            //배치할 강의와 강의실(room)을 비교한다.
            if (!room.isEmpty() && room.peek() <= pick.x) {
                //가장 빨리 끝날 강의가 끝나는 시간 <= 새로운 강의가 시작하는 시간 --> 이 상황이면 해당 강의실의 끝나는 시간을 바꾼다.
                room.poll();
            }
            //가장 빨리 비워지는 강의실 보다 강의가 더 앞에 잡혀있는 경우 or 강의실을 바꿔줄 경우 -> room 우선순위큐에 값을 넣어준다.
            room.add(pick.y);
        }
        System.out.println(room.size());

    }
}

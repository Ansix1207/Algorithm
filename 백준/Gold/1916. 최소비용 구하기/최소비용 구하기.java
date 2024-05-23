import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<List<int[]>> list = new ArrayList<>() ;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer stk;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            list.get(start).add(new int[]{end, v});
        }
        stk = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(stk.nextToken());
        int dest = Integer.parseInt(stk.nextToken());
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(start,dest);

    }
    static void dijkstra(int start, int dest){
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int cur = temp[0];
            for (int[] ints : list.get(cur)) {
                int next = ints[0];
                int nextWeight = ints[1];
                if (distance[next] > distance[cur] + nextWeight) {
                    distance[next] = distance[cur] + nextWeight;
                    pq.add(new int[]{next, distance[next]});
                }
            }
            if (cur == dest) {
                System.out.println(distance[dest]);
                break;
            }
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int v; //간선
        int cost; //가중치

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(br.readLine())-1;
        ArrayList<Node>[] list = new ArrayList[V];
        int[] dist = new int[V];
        boolean[] visit = new boolean[V];
        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken())-1;
            int v = Integer.parseInt(stk.nextToken())-1;
            int w = Integer.parseInt(stk.nextToken());
            list[u].add(new Node(v, w));
        }
        //경로 값 넣기
        dijkstra(start,dist, list, visit);
        print(dist);
        System.out.println();
    }
    static void print(int[] dist){
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }
    static void dijkstra(int start,int[] dist, ArrayList<Node>[] list, boolean[] visit){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;
        //시작 노드에 대해서 초기화
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (!visit[now.v]) {
                visit[now.v] = true;
            }
            for (Node node : list[now.v]) {
                //방문하지 않았고, 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧을 경우 갱신한다.
                if(visit[node.v])
                    continue;
                if (dist[node.v] > now.cost + node.cost) {
                    dist[node.v] = now.cost + node.cost;
                    q.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}

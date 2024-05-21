import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static int[] dis;
    static final int MAX = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //n은 총 지역의 개수
        //road 는 두 지역을 왕복할 수 있는 길 정보를 담은 2차원 정수 배열
        //각 부대원들의 위치인 sources
        //복귀 지역 destination
        //sources의 원소 순서대로 강철부대로 복귀할 수 있는 최단시간을 담은 배열을 리턴해라,
        //단 복귀 불가능시 부대원의 최단시간은 -1.
        graph = new ArrayList();
        for(int i = 0; i < n+1 ; i ++){
            graph.add(new ArrayList());
        }
        for(int [] road : roads){
            int s = road[0];
            int e = road[1];
            
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        dis = new int[n+1];
        Arrays.fill(dis,MAX);
        dijkstra(destination);
        int[] answer = new int[sources.length];
        for(int i = 0; i<sources.length; i ++){
            answer[i] = (dis[sources[i]]<MAX)?dis[sources[i]] : -1;
        }
        return answer;
    }
    static void dijkstra(int destination){
        ArrayDeque<Integer> q = new ArrayDeque();
        q.add(destination);
        dis[destination] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0 ; i <graph.get(cur).size(); i ++){
                int v = graph.get(cur).get(i);
                if(dis[v] > dis[cur] + 1){
                    dis[v] = dis[cur] + 1;
                    q.add(v);
                }
            }
        }
    }
    
    
}
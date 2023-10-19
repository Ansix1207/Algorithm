import java.util.*;
class Solution {
        class Node{
            public int v;
            public int l;
            public Node(int v, int l){
                this.v = v;
                this.l = l;
            }
        }
        public int solution(int n, int[][] edge) {
            ArrayList<Integer>[] list = new ArrayList[n+1];
            int[] visit = new int[n+1];
            for(int i = 0; i < n+1; i++){
                list[i]=new ArrayList<Integer>();
            }
            for(int i =0 ; i < edge.length ; i++){
                int x = edge[i][0];
                int y = edge[i][1];
                list[x].add(y);
                list[y].add(x);
            }
            Queue<Node> q = new ArrayDeque();
            q.add(new Node(1,0));
            visit[1] = -1;
            int max = 0;
            while(!q.isEmpty()){
                Node node = q.poll();
                int v = node.v;
                int l = node.l;
                for(int i = 0 ; i < list[v].size() ; i++){
                    int next_node = list[v].get(i);
                    if(visit[next_node] ==0){
                        max = Math.max(l+1, max);
                        visit[next_node] = l+1;
                        q.add(new Node(next_node,l+1));
                    }
                }
            }
            int answer = 0;
            for(int i =1; i< visit.length; i++){
                if(visit[i] == max){
                    System.out.println(i);
                    answer++;
                }
            }
            return answer;
        }
}
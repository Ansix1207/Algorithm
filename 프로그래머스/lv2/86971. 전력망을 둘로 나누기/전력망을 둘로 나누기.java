import java.util.*;
class Solution {
        static int arr[][];
        static boolean visit[];
    
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            arr = new int[n+1][n+1];
            //초기화 해서 초기 배열 선언
            for (int i = 0; i < wires.length; i++) {
                int low = wires[i][0];
                int column = wires[i][1];
                arr[low][column] = 1;
                arr[column][low] = 1;
            }
            //모든 경우의수 따지기 위해서 해당부분 제거한 배열을 넣음
            for (int i = 0; i < wires.length; i++) {
                visit = new boolean[n+1];
                int low = wires[i][0];
                int column = wires[i][1];
                arr[low][column] = 0;
                arr[column][low] = 0;
                int bfs1 = bfs(arr, low);
                int bfs2 = bfs(arr, column);
                arr[low][column] = 1;
                arr[column][low] = 1;
                answer = Math.min(answer, Math.abs(bfs1-bfs2));
            }
            return answer;
        }

        static int bfs(int [][] tarr,int start){
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visit[start] = true;
            int res = 0;
            while (!q.isEmpty()) {
                int v = q.poll();
                res++;
                for (int i = 1; i < tarr[v].length; i++) {
                    if (tarr[v][i] == 1 && !visit[i]) {
                        q.offer(i);
                        visit[i] = true;
                    }
                }
            }
            return res;
        }
    }
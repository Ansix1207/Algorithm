import java.util.*;
class bot{
    public int x;
    public int y;
    public int sum = 0;
    public bot(){
        int x = 0;
        int y = 0;
    }
    public bot(int x, int y,int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        bfs(maps);
        int n = maps.length-1;
        int m = maps[0].length-1;
        answer = maps[n][m];
        if(answer==1){
            return -1;
        }
        return answer;
    }
    public void bfs(int[][] maps){
        Deque<bot> dq = new ArrayDeque();
        int x = 0;
        int y = 0;
        dq.add(new bot(x,y,1));
        maps[x][y] = 0;
        while(!dq.isEmpty()){
            bot b = dq.remove();
            int nx = b.x;
            int ny = b.y;
            int sum = b.sum;
            if(nx==maps.length-1 && ny == maps[0].length-1){
                // System.out.println("nx = " +nx + " ny = "+ ny);
                // System.out.println("sum = "+sum);
                maps[nx][ny] = b.sum;
                break;
            }
            //아래
            if(nx+1<maps.length && maps[nx+1][ny]==1){
                dq.add(new bot(nx+1,ny,sum+1));
                maps[nx+1][ny] = 0;
            }
            //오른쪽
            if(ny+1<maps[0].length && maps[nx][ny+1] == 1){
                dq.add(new bot(nx,ny+1,sum+1));
                maps[nx][ny+1] = 0;
            }
            //위
            if(nx-1>=0 && maps[nx-1][ny]==1){
                dq.add(new bot(nx-1,ny,sum+1));
                maps[nx-1][ny] = 0;
            }
            //왼쪽
            if(ny-1>=0 && maps[nx][ny-1] == 1){
                dq.add(new bot(nx,ny-1,sum+1));
                maps[nx][ny-1] = 0;
            }
            
        }
    }
}
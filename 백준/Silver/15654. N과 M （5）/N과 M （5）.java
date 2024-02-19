import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/19 15654번 N과 M(5) (실버3)
public class Main {
    static int[] arr;
    static int[] sol;
    static int depth;
    public static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N개의 자연수와 자연수 M
        //N개의 자연수 중에서 M 개를 고른 수열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        sol = new int[n];
        visited = new boolean[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        //주어진 N개의 자연수들을 담은 배열을 정렬한다.
        Arrays.sort(arr);
        dfs(n,m,0);
        System.out.println(sb);
    }
    static void dfs(int n,int m, int depth){
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(sol[i]+" ");
            }
            sb.append("\n");
        }
        else{
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    visited[i]=true;
                    sol[depth]=arr[i];
                    dfs(n,m,depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}

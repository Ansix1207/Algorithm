package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/23 15649번 N과 M (1) (실버 3) 
// TODO: 2023/06/23 !!성공!!
public class boj_15649_n과m1 {
    static int n;
    static int m;
    static int arr[];
    static int visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        visit = new int[n];
        Arrays.fill(visit,0);
        back( 0);
    }

    static void back(int depth) {
        //1 2 3 4
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.print("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visit[i]==0){
                visit[i]=1;
                arr[depth] = i+1;
                back(depth+1);
                visit[i]=0;
            }
        }
    }
}

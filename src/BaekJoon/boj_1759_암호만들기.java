package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2023/06/22 1759번 암호만들기 (골드5)
public class boj_1759_암호만들기 {
    static char[] arr;
    static char[] solution;
    static boolean[] visited;
    static int cnt_con, cnt_vowels,n,m;
    static boolean isConsonant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new char[m];
        solution = new char[n];
        visited = new boolean[m];
        cnt_con=0;
        cnt_vowels = 0;
        isConsonant = false;
        stk = new StringTokenizer(br.readLine());
        int i = 0;
        while (stk.hasMoreTokens()) {
            arr[i++] = stk.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    static void dfs(int next,int depth){
        if (depth == n) {
            if (isValid()) {
                System.out.println(solution);
            }
            return;
        }
        // a c i s t w
        // 0 1 2 3 4 5
        /** n = 4, m = 6;
         * a(next=0,depth=0, i=0) , ac(1,1,1), aci(2,2,2) ,acis(3,3,i=3), acit(3,3,i=4),aciw(3,3,i=5)
         * a, ac, acs(2,2,3), acst(4,3,i=4), acsw(4,3,i=5)
         * a, ac ,act(2,2,4), actw(5,3,5)
         * */
        else {
            for (int i = next ; i < m; i++) {
                solution[depth] = arr[i];
                dfs(i+1,depth+1);
                solution[depth] = 'X';
            }
        }
    }
    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : solution) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}

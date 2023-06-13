package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/13 3085번 사탕게임 (실버2)
// TODO: 2023/06/13 !!성공!! (다시 풀고 지우기)
public class boj_3085 {
    static String[][] srr;
    static int max_cnt=0,n;
    static public void checkCandy(){

    }
    static public void check() {
        //가로 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n-1; j++) {
                if(srr[i][j].equals(srr[i][j+1])){
                    cnt++;
                }
                else{
                    if (cnt > max_cnt) {
                        max_cnt=cnt;

                    }
                    cnt = 1;
                }
            }
            if(cnt>max_cnt) max_cnt=cnt;

        }
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 0; i < n-1; i++) {
                if(srr[i][j].equals(srr[i+1][j])){
                    cnt++;
                }
                else{
                    if (cnt > max_cnt) {
                        max_cnt=cnt;
                    }
                    cnt = 1;
                }
            }
            if(cnt>max_cnt) max_cnt=cnt;
        }
    }

    static public void swapx(int i, int j) {
        String temp = srr[i][j];
        srr[i][j] = srr[i][j+1];
        srr[i][j+1]=temp;
    }
    static public void swapy(int i, int j) {
        String temp = srr[i][j];
        srr[i][j] = srr[i + 1][j];
        srr[i+1][j] = temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        srr= new String[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                srr[i][j] = s.substring(j,j+1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                swapx(i,j);
                check();
                swapx(i,j);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n-1; i++) {
                swapy(i,j);
                check();
                swapy(i,j);
            }
        }
        System.out.println(max_cnt);
    }
}

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

// TODO: 2023/06/15 1748번 수 이어 쓰기 1 (실버4)
// TODO: 2023/06/19 성공!
public class boj_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0 ;
        int plus = 1;
        int num = 10;
        for (int i = 1 ; i <= n ; i ++) {
            if(i%num==0){
                plus++;//셀 자리수 증가 9 -> 10  // 1 -> 2
                num= num*10; // 10, 100, 1000 ... 수마다 자리수 1개씩 증가
            }
            cnt= cnt+plus;
        }
        System.out.println(cnt);
    }
}

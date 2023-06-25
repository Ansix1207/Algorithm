package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 백트래킹 문제중에 서브셋을 이용한 풀이이다!
 * 모든 항목들을 depth까지 더하면 모든 항목을 포함한 subset이게 된다.
 * depth는 + 1 해주면서 value를 더해주지 않으면 해당 value가 빠진 subset이 만들어지게 된다.
 * 더해지고 빼진원소들을 기반으로 더해진 원소들만 모아보면 부분수열이 완성된다.
 * 예외 사항으로 모두 더하지 않았을때가 문제인데. 타겟 넘버가 0일경우 모든걸 안더하면 1이 더해지기때문에
 * if(타겟넘버 == 0 ) cnt = cnt -1 을 해준다.
 * */

// TODO: 2023/06/23 1182번 부분수열의 합 (실버2)
// TODO: 2023/06/23 !!성공!!
public class boj_1182_부분수열의합 {
    static int n, s;
    static int[] arr;
    static int cnt = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);
        arr = new int[n+1];
        line = br.readLine().split(" ");
        for (int i = 1; i < n+1; i++)
            arr[i] = Integer.parseInt(line[i-1]);
        if (s == 0) {
            cnt--;
        }
        back(1,0);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    static void back(int depth,int sum){

        if (depth == n+1) {
            return;
        }
        if(sum  +arr[depth]== s){
            cnt++;
        }
        // -7 -3 -2 5 8
        // -7 -3 -2 5
        // -7 -3 -2 8
        // -7 -3 -2
        // -7 -3  5 8
        // -7 -3  5
        // -7 -3  8
        back(depth + 1, sum + arr[depth]);
        back(depth + 1, sum);
    }

}

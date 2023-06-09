package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/06/22  14501번 퇴사 (실버3) https://www.acmicpc.net/problem/14501
// TODO: 2023/06/22 !!성공!! (다시 풀어보기)

/**
 * 인덱스 처리가 중요하다.
 * 1일에 일할경우 3일이 걸린다 그러면 인덱스가 int i = index+t[i] 를 더해주면서 진행한다.
 * n일차에 상담을 받는건 가능, 하지만 n-1 일차에서  n일차를 넘어서 상담이 끝나는건 불가하다.
 * n일차가 되거나 n+@일에 상담이 진행되어야 하는 경우 max 와 인자로 전달받은 sum을 비교해서
 * 최대값을 지정한다.
 * */
public class boj_14501_퇴사 {
    static int t[];
    static int v[];
    static int dp[];
    static int n,max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n+1];
        v = new int[n+1];
        dp = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }
        int sum = 0 ;
        for (int i = 1; i < n+1; i++) {
            if (i + t[i] <= n+1) {
                sum = v[i];
                check(i, sum);
            }
        }

        System.out.println(max);
    }

    //첫 배열의 t 값 본다 -> idx+t<n 이면 sum에 값 더해짐
    static void check(int index, int sum){
        if (index + t[index] >= n+1) { //n>=7 이면 이번 인덱스의 값이 7일까지 일한경우 값 더해서 마무리
            max = Math.max(max, sum);
        }
        else{//7보다 작다면 즉, 아직 더 일할 수 있다면, 이번 값 더해서 다음 값으로
            for (int i = index + t[index]; i < n+1; i++) {
                if (i + t[i] <= n+1) {
//                    sum += v[i];
//                    check(i, sum);
//                    sum -= v[i];
                    check(i, sum + v[i]);
                }
                else{
                    check(i,sum);
                }
            }
        }
    }
}

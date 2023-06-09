package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//todo: 수들의 합5 https://www.acmicpc.net/problem/2018
public class boj_2018  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n + 1];
        int s_idx=1;
        int e_idx=1;
        int sum = 1 ;
        int count=1;
        //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 -> 15가 되는 경우의 수
        //목표에 도달한경우 end_idx를 넓힌다
        //end_idx를 더해서 sum >n 보다 커진경우 start_idx를 빼서 그 숫자를 경우의 수에서 제외

        while (e_idx != n) {
            if (sum == n) {//타겟과 같으면 -> 카운팅 하고, 다음 연속된 수로 넘어감
                count++;
                e_idx++;
                sum = sum+e_idx;
            } else if (sum > n) { // 타겟보다 크면 -> start_index의 숫자를 빼서 연속된 수 유지
                sum = sum-s_idx;
                s_idx++;
            }
            else{//sum<n //타겟보다 작으면 -> 다음 연속된 수로 넘어감
                e_idx++;
                sum += e_idx;
            }
        }
        System.out.println(count);

    }
}

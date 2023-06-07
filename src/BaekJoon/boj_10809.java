package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO: 2023/06/07 10809번 알파벳 찾기 (브론즈 2)  https://www.acmicpc.net/problem/10809
// TODO: 2023/06/07 !!성공!!
public class boj_10809 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(br.readLine());
        int[] arr = new int['z'-'a'+1];
        Arrays.fill(arr, -1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(arr[idx]==-1){
                arr[idx] = i;
            }
        }
//        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/06/07 10808번 알파벳 개수 (브론즈4)
// TODO: 2023/06/12 !!성공!!
public class boj_10808 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int['z'-'a'+1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            arr[idx]++;
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

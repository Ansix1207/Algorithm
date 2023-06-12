package BaekJoon;

import java.io.*;
import java.util.Arrays;

// TODO: 2023-06-12 11656번 접미사 배열 실버4
// TODO: 2023-06-12 !!성공!!
public class boj_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = s.length();
        String[] srr = new String[n];
        for (int i = 0; i < n; i++) {
            srr[i] = s.substring(i, n);
        }
        Arrays.sort(srr);
        for (String t : srr) {
            bw.append(t + "\n");
        }
        bw.flush();
    }
}

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/26 6603번 로또 (실버2)
// TODO: 2023/06/26 !!성공!!
public class boj_6603_로또 {
    static int arr[] ;
    static int n = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            arr = new int[s.length];
            n = s.length;
            if(s[0].equals("0"))
                break;
            for (int i = 1; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            back(0, 1);
            bw.write("\n");
        }
        bw.flush();
    }

    static void back(int depth, int next) throws IOException {
        if(depth==6){
            for (int i : list) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = next; i < n; i++) {
            list.add(arr[i]);
            back(depth + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

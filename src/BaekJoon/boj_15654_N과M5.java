package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// TODO: 2023/06/24 15654번 N과 M(5) 실버3
// TODO: 2023/06/24 !! 코드 참조 안하고 성공 !!
public class boj_15654_N과M5 {
    static int n;
    static int m;
    static int arr[];
    static BufferedWriter bw;
    static boolean visit[];
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        visit = new boolean[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list2.add(Integer.parseInt(stk.nextToken()));
        }
        list2.sort(Comparator.naturalOrder());
        back(0,-1);
        bw.flush();
    }


    static void back(int l,int before) throws IOException {
        if (l == m) {
            list.stream().sorted();
            for (Integer i : list) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(list2.get(i));
                back(l + 1,i);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}

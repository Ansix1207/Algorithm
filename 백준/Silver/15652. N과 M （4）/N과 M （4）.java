import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// TODO: 2023/06/24 15652번 N과 M(4) 실버3
// TODO: 2023/06/24
public class Main {
    static int n;
    static int m;
    static int arr[];
    static BufferedWriter bw;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        back(0,0);
        bw.flush();
    }


    static void back(int l,int now) throws IOException {
        if (l == m) {
            for (Integer i : list) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = now; i < n; i++) {
            list.add(i + 1);
            back(l + 1,i);
            list.remove(list.size() - 1);
        }
    }
}

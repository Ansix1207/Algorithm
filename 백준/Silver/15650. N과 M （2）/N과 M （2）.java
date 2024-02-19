import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int arr[];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        back(0,0);

    }


    static void back(int l, int next) {
        if (l == m) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = next; i < n; i++) {
            list.add(i+1);
            back(l+1,i+1);
            list.remove(list.size() - 1);
        }
    }
}

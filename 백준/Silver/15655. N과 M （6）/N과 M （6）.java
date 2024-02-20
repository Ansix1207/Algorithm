import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static Deque<Integer> dq = new ArrayDeque<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        for (String s : br.readLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }
        list.sort(Integer::compareTo);
        visit = new boolean[list.size()];
        backTracking(n,m,0,0);
        bw.flush();
    }

    static void backTracking(int n, int m, int depth,int next) throws IOException {
        //여기에서 제일 먼저 m 만큼 뽑았는지 depth를 통해 확인한다.
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : dq) {
                sb.append(integer+" ");
            }
            bw.write(sb.toString()+"\n");
            return;
        }
        for(int i = next; i<n;i++){
            if(visit[i])
                continue;
            visit[i] = true;
            dq.addLast(list.get(i));
            backTracking(n,m,depth+1,i);
            visit[i] = false;
            dq.removeLast();
        }
    }
}

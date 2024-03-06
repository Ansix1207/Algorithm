import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> preList = new ArrayList<>();
    static ArrayList<Integer> inList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int T,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        T = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < T; i++) {
            preList.clear();
            inList.clear();
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                preList.add(Integer.parseInt(stk.nextToken()));
            }
            stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                inList.add(Integer.parseInt(stk.nextToken()));
            }
            postOrder(0,0,N);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void postOrder(int root, int start, int end) {
        if (root >= N) {
            return;
        }
        int rootValue = preList.get(root);
        for (int i = start; i < end; i++) {
            if (rootValue == inList.get(i)) {
                //루트랑 중위순회랑 같다면 해당 기준으로 나누어서 left, right 분할한다.
                postOrder(root + 1, start, i);
                postOrder(root + (i - start) + 1, i + 1, end);
                sb.append(rootValue).append(" ");
                return;
            }
        }

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> pq = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();
        while (stk.hasMoreTokens()) {
            pq.add(Integer.parseInt(stk.nextToken()));
        }
        for (int i = 0; i < pq.size() - 1; i++) {
            diff.add(pq.get(i+1)-pq.get(i));
        }
        //1 3 5 6 10
        // 2 2 1 4 -> 각 수들의 차이일때
        // 각 수들의 차이가 가장 클 때 벽을 둔다
        // 1 3| 5 6 |10
        diff.sort(Comparator.naturalOrder());
        int answer = 0;
        for (int i = 0; i < N-K; i++) {
            answer += diff.get(i);
        }
        System.out.println(answer);
    }
}

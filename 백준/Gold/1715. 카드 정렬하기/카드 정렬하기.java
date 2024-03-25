import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < T; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        Long sum = 0L;
        while (pq.size()>=2) {
            long x1 = pq.remove();
            long x2 = pq.remove();
            long temp = x1+x2;
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}

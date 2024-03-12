import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (String arg : br.readLine().split(" ")) {
                pq.add(Long.parseLong(arg));
            };
            Long sum = 0L;
            while(pq.size()>=2){
                Long x = pq.poll();
                Long y = pq.poll();
                pq.add(x+y);
                sum += x+y;
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());

    }
}

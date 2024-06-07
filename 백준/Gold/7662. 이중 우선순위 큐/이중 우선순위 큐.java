import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            for (int j = 1; j <= K; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                String s = stk.nextToken();
                int v = Integer.parseInt(stk.nextToken());
                if (s.equals("I")) {
                    map.put(v, map.getOrDefault(v, 0)+1);
                }else{
                    if(map.isEmpty())
                        continue;
                    Entry<Integer, Integer> ent =
                            v == 1 ? map.firstEntry() : map.lastEntry();
                    if (map.get(ent.getKey()) == 1) {
                        map.remove(ent.getKey());
                    }else{
                        map.put(ent.getKey(), ent.getValue() - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            }else {
                System.out.println(map.firstKey() + " " +map.lastKey());
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //입력 데이터 수
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int k = Integer.parseInt(br.readLine()); //적용할 연산의 개수
            PriorityQueue<Integer> pq_desc = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq_asc = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= k; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                String s = stk.nextToken();
                int n = Integer.parseInt(stk.nextToken());
                if (s.equals("D")) {
                    if (map.size() == 0) {
                        continue;
                    }
                    if (n == 1) {
                        remove(pq_desc, map);
                    } else if (n == -1) {
                        remove(pq_asc, map);
                    }
                } else if (s.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    pq_desc.offer(n);
                    pq_asc.offer(n);
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int num = remove(pq_desc, map);
                System.out.println(num + " " + (map.isEmpty() ? num : remove(pq_asc, map)));
            }
        }
        System.out.println(sb.toString());

    }

    private static int remove(PriorityQueue<Integer> pq_asc, HashMap<Integer, Integer> map) {
        int num;
        while (true) {
            num = pq_asc.remove();
            int v = map.getOrDefault(num, 0);
            if (v == 0) {
                continue;
            }
            if (v == 1) {
                map.remove(num);
            } else {
                map.put(num, v - 1);
            }
            break;
        }
        return num;
    }
}

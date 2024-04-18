import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //문자열 게임의 수 T
        int T = Integer.parseInt(br.readLine());
        //다음 줄 부터 2개의 줄 동안 문자열 W와 정수 K가 주어진다.
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < W.length(); j++) {
                char alpha = W.charAt(j);
                map.put(alpha, map.getOrDefault(alpha, 0)+1);
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < W.length(); j++) {
                char alpha = W.charAt(j);
                if(map.getOrDefault(alpha,0)<K)
                    continue;

                int cnt = 1;
                for (int k = j + 1; k < W.length(); k++) {
                    //현재 위치의 알파벳과 다음 위치의 알파벳 비교한다.
                    if (alpha == W.charAt(k)) {
                        //알파벳이 서로 같으면 cnt+1 해준다.
                        cnt++;
                    }
                    //cnt가 딱 K개 만큼 되었을때 min과 max를 갱신시킨다.
                    if (cnt == K) {
                        min = Math.min(min, k - j + 1);
                        max = Math.max(max, k - j + 1);
                        break;
                    }
                }
            }
            //min과 max 둘중 하나라도 갱신이 안되었다면 만족하지 않음
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append("-1\n");
            }
            else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

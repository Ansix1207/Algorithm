import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> list = new ArrayList<>();
        while (stk.hasMoreTokens()) {
            list.add(Integer.parseInt(stk.nextToken()));
        }
        int answer = 1;
        if (N == 1) {
            System.out.println(answer);
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) >= c+1) {
							answer = 1;
							continue;
            }
            answer++;
        }
        System.out.println(answer);
    }

}
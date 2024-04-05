import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] HW = br.readLine().split(" ");
        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : br.readLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }
        int answer = 0;
        for (int i = 1; i < W-1; i++) {
            int l = 0,r=0;
            for (int j = 0; j < i; j++) {
                l = Math.max(l, list.get(j));
            }
            for (int k = i+1; k < W; k++) {
                r = Math.max(r, list.get(k));
            }
            //현재 블럭이 좌측, 우측 블럭보다 작을 때
            if(list.get(i)<l && list.get(i)<r) {
                answer += Math.min(l, r) - list.get(i);
            }
        }
        System.out.println(answer);
    }
}

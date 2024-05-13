import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<int[]> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        List<int[]> stack = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            int[] circle = new int[]{x-r,x+r};
            stack.add(circle);
        }
        stack.sort((x1,x2)->{
            if(x1[0] != x2[0]) return x1[0] - x2[0];
            return x1[1]-x2[1];
        });

        if(stack.isEmpty()){
            System.out.println("NO");
            return;
        }
        int[] prev = stack.remove(0);
        for (int[] ints : stack) {
            if(prev[1]>= ints[0] && prev[1] <= ints[1]){
                System.out.println("NO");
                return;
            }
            prev = ints;
        }
        System.out.println("YES");
    }
}

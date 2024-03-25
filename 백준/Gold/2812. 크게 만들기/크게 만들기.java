import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            int a = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(stack.isEmpty()){
                stack.addLast(a);
                continue;
            }

            while (!stack.isEmpty()){
                if (stack.peekLast() < a && cnt <K) {
                    stack.removeLast();
                    cnt++;
                    continue;
                }
                break;
            }

            stack.addLast(a);
        }
        while(cnt<K){
            cnt++;
            stack.removeLast();
        }
        for (Integer integer : stack) {
            bw.append(Integer.toString(integer));
        }
        bw.flush();
        }
    /**
         * 4177252841
     * ->  477252841
     * ->   77252841
     * ->   7752841
     * ->   775841
     * */

    }

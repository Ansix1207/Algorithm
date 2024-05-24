import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(stk.nextToken());
        int x2 = Integer.parseInt(stk.nextToken());
        int D = Integer.parseInt(br.readLine());
        boolean flag = false; //false 인 경우 x1 차례, true 이면 x2 차례
        for (int i = 1; i <= D; i++) {
            if (!flag) {
                //x1이 x2로 식량 절반을 넘긴다.
                if (x1 % 2 != 0) {
                    //홀수라면 다 넘긴다.
                    x1 = x1 / 2;
                    x2 += x1+1;
                } else {
                    //짝수 일때
                    x1  = x1 /2 ;
                    x2 += x1;
                }
                flag = true;
            } else {
                //x2이 x1로 식량 절반을 넘긴다.
                if (x2 % 2 != 0) {
                    //홀수라면 다 넘긴다.
                    x2 = x2 / 2;
                    x1 += x2 + 1;
                } else {
                    //짝수 일때
                    x2 = x2 / 2;
                    x1 += x2;
                }
                flag = false;
            }
        }
        System.out.println(x1 + " " + x2);

    }

}
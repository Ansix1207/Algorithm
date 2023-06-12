package BaekJoon;

// TODO: 2023/06/12  10820번 문자열 분석 (브론즈 2) https://www.acmicpc.net/problem/10820
// TODO: 2023/06/12 !!성공!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10820 {
    public static void main(String[] args) throws IOException {
//        StringTokenizer stk = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(br.readLine());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int space = 0;
            int upper = 0;
            int lower = 0;
            int num = 0 ;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) num++;
                else if(Character.isUpperCase(c)) upper++;
                else if(Character.isLowerCase(c)) lower++;
                else if(Character.isSpaceChar(c)) space++;
            }
            System.out.printf("%d %d %d %d\n",lower,upper,num,space);
        }


    }
}

    package BaekJoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    // TODO: 2023/07/28 11720번 숫자의합 (브론즈4) https://www.acmicpc.net/problem/11720
    // TODO: 2023/07/28 성공
    public class boj_11720_숫자의합 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int sum  = 0 ;
            for (int i = 0; i < n; i++) {
                sum += s.charAt(i)-'0';
            }
            System.out.println("sum = " + sum);
        }
    }

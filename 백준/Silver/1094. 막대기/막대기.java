import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
         *          128  64  32  16  8  4  2  1
         *               1   0   0   0  0  0  0
         *               0   0   1   0  1  1  1
         *                   1    1  0  0 0  0
          * */
        int cnt = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

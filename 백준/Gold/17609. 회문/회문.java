import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            check(br.readLine(), 0);
        }

        System.out.println(answer);
    }
    static boolean check(String str, int level){
        String tmp = new StringBuilder(str).reverse().toString();
        if (tmp.equals(str)) {
            if (level == 0) {
                answer.append("0\n");
            }
            return true;
        } else if (level == 0) {
            int left = 0;
            int right = str.length()-1;
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    String leftDeleteStr = new StringBuilder(str).deleteCharAt(left).toString();
                    String rightDeleteStr = new StringBuilder(str).deleteCharAt(right).toString();
                    if (check(rightDeleteStr, 1) || check(leftDeleteStr, 1)) {
                        answer.append("1\n");
                        return true;
                    }
                    //틀린 한글자를 빼고 비교했음에도 틀린 경우
                    answer.append("2\n");
                    return false;
                }
                right--;
                left++;
            }

        }
        return false;
    }
}

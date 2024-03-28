import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder sb = new StringBuilder();
        if(n.equals("0")){
            System.out.println("0");
            return;
        }
        String[] s = new String[]{
                "000","001","010","011","100","101","110","111"
        };
        for (char c : n.toCharArray()) {
            sb.append(s[Character.getNumericValue(c)]);
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                for (int j = i-1; j >= 0; j--) {
                    sb.deleteCharAt(j);
                }
                break;
            }
        }
        System.out.println(sb.toString());
    }
}

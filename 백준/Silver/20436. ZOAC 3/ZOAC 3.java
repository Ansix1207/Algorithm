import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int distance(Point x, Point y){
        return (int) (Math.abs(x.getX() - y.getX()) + Math.abs(x.getY() - y.getY()));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        String left = stk.nextToken();
        String right = stk.nextToken();
        String target = br.readLine();
        int answer = 0;

        Map<String, Point> map = new HashMap<>();
        Set<String> vowels = new HashSet<>(List.of("y","u","i","o","p",
                "h","j","k","l",
                "b","n","m"));//모음 글자 set
        String first_line = "qwertyuiop";
        String second_line = "asdfghjkl";
        String third_line = "zxcvbnm";
        String[] set = {first_line, second_line, third_line};
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set[i].length(); j++) {
                map.put(String.valueOf(set[i].charAt(j)), new Point(i, j));
            }
        }
        for (int i = 0; i < target.length(); i++) {
            String c = String.valueOf(target.charAt(i));
            Point targetPoint = map.get(c);
            Point currentPoint;
            if (!vowels.contains(c)) {
                currentPoint = map.get(left);
                left = c;
            }else {//오른손이 모음
                currentPoint = map.get(right);
                right = c;
            }
            int distance = distance(currentPoint, targetPoint);
            answer+=distance+1;
        }
        System.out.println(answer);
    }
}

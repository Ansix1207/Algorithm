import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    static ArrayList<Integer> numberOfOperators = new ArrayList<>();
    static Set<String> opSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int cnt = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (String s : br.readLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }
        for (String s : br.readLine().split(" ")) {
            numberOfOperators.add(Integer.parseInt(s));
        }
        init_op(op,numberOfOperators);
        visit = new boolean[op.size()];
        backTracking(n,0,sb);
        calculate();
        System.out.println(max+"\n"+min);
    }
    //back tracking을 사용한다.
    //Parameter -> StringBuilder로 조합을 만들어서 전달
    static void backTracking(int n, int depth, StringBuilder sb){
        if(depth == n-1){
            String str = sb.toString();
//            if (str.length() != n - 1) {
//                System.out.println("문제 발생 길이 안맞음");
//            }
//            System.out.println("만들어진 문자열! = " + str);
            opSet.add(sb.toString());
            cnt++;
            return;
        }
        char before = 0;
        for (int i = 0; i < op.size(); i++) {
            if(visit[i] || before == op.get(i))
                continue;
            visit[i] = true;
            sb.append(op.get(i));
            before = op.get(i);
            backTracking(n,depth+1,sb);
            visit[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    static void calculate(){
        // ++--/ 만들어진 거 하나 꺼냄
        for (String s : opSet) {
            //그럼 숫자 하나 꺼냄
            int sum = list.get(0);
            int idx = 1;
            for (char c : s.toCharArray()) {
                int value = list.get(idx++);
                switch (c){
                    case '+':
                        sum += value;
                        break;
                    case '-':
                        sum-= value;
                        break;
                    case '*' :
                        sum*= value;
                        break;
                    case '/':
                        sum/=value;
                        break;
                }
            }
            if (sum > max) {
                max = sum;
            }
            if(sum < min){
                min = sum;
            }
        }

    }
    static void init_op(ArrayList<Character> op,ArrayList<Integer> numberOfOperators){
        for (int i = 0; i < 4; i++) {
            char c = 0;
            if (i == 0) {
                c = '+';
            }else if(i==1){
                c = '-';
            }else if(i==2){
                c= '*';
            }else if(i==3){
                c = '/';
            }
            for (int j = 0; j < numberOfOperators.get(i); j++) {
                op.add(c);
            }
        }
    }
}

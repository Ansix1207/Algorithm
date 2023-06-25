package BaekJoon;

// TODO: 2023/06/22 2529번 부등호 (실버1) https://www.acmicpc.net/problem/2529
// TODO: 2023/06/25 !!성공!!
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2529_부등호 {
    static String[] srr;
    static int[] arr;
    static boolean[] visit = new boolean[10];//숫자 중복 불가
    static int n;
    static ArrayList<String> list = new ArrayList<>();
    static boolean check(int a, int b, String op) {
        if (op.equals("<")) {
            if (a < b) {
                return true;
            }
        }
        else if (op.equals(">")) {
            if(a>b){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        srr = br.readLine().split(" ");
        back(0,"");
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
    static void back(int depth,String num){
        if (depth == n+1) {
            list.add(num);
//            System.out.println(num) ;
            return;
        }
        for(int i = 0;i<10;i++){
            if(depth==0 || !visit[i] && check(num.charAt(num.length()-1)-'0',i,srr[depth-1])){
                //방문하지 않았으며, 첫번쨰는 비교 할필요 없음,
                    visit[i]=true;
                    back(depth+1,num+i);
                    visit[i]=false;
            }
        }
    }
}

package BaekJoon;

import java.io.*;
import java.util.Stack;

// TODO: 2023-05-30 10799번 쇠막대기 (실버2)  https://www.acmicpc.net/problem/10799
// Todo: 성공
public class boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split("");
        Stack<String> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals("(")){
                st.push("(");
            }
            else{// ')' 일때
                st.pop();
                if(str[i-1].equals("(")){//레이저 임
                    //레이저 맞으면 그 면만큼 +1
                    // 따라서 스택에 존재하는 막대개수(스택 크기) 만큼 ++
                    res += st.size();
                }
                else{ //막대의 끝 -> 남은 부분이라서 res+1
                    res +=1;
                }
            }
        }
        bw.write(res+"");
        br.close();
        bw.close();
    }
}

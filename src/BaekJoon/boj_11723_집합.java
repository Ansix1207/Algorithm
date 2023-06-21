package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// TODO: 2023/06/21 11723번 집합 실버5 
// TODO: 2023/06/21 !!성공!!
public class boj_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        final Integer[] SET_VALUES = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                String method = stk.nextToken();
                switch (method){
                        //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    case "add":
                        s.add(Integer.parseInt(stk.nextToken()));
                        break;
                        //check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                    case "check":
                        if(s.contains(Integer.parseInt(stk.nextToken())))
                            bw.write(1 + "\n");
                        else
                            bw.write(0+ "\n");
                        break;
                    case "remove":
                        //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                        s.remove(Integer.parseInt(stk.nextToken()));
                        break;
                        //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    case "toggle":
                        int x = Integer.parseInt(stk.nextToken());
                        if(s.contains(x)){
                            s.remove(x);
                        }
                        else{
                            s.add(x);
                        }
                        break;
                        //all: S를 {1, 2, ..., 20} 으로 바꾼다.
                    case "all":
                        s = new HashSet<>(Arrays.asList(SET_VALUES));
                        break;
                        //empty: S를 공집합으로 바꾼다.
                    case "empty":
                        s= new HashSet<Integer>();
                        break;
                }
            }
        }
        bw.flush();
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/05/30 12891번 DNA 비밀번호  https://www.acmicpc.net/problem/12891
// todo: 성공
public class boj_12891 {
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;
    static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0]==checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1]==checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2]==checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3]==checkArr[3])
                    checkSecret++;
                break;
        }
    }

    static void remove(char c) {
        {
            switch (c) {
                case 'A':
                    if (myArr[0] == checkArr[0])
                        checkSecret--;
                    myArr[0]--;
                    break;
                case 'C':
                    if (myArr[1] == checkArr[1])
                        checkSecret--;
                    myArr[1]--;
                    break;
                case 'G':
                    if (myArr[2] == checkArr[2])
                        checkSecret--;
                    myArr[2]--;
                    break;
                case 'T':
                    if (myArr[3] == checkArr[3])
                        checkSecret--;
                    myArr[3]--;
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
//        String[] str = br.readLine().split(" ");
        int s = Integer.parseInt(stk.nextToken()); // 문자열 길이
        int p = Integer.parseInt(stk.nextToken()); // 부분 문자열 길이
        char[] str = br.readLine().toCharArray();//입력 문자열 CCTGATTG
        int result = 0;
        checkArr= new int[4]; //ACGT
        myArr = new int[4];
        checkSecret = 0;
        stk = new StringTokenizer(br.readLine());//2 0 1 1
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(stk.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;//ACGT의 개수 세기, 만약 4이면 모두 0임
            }
        }
        //초기 p 부분 문자열 처리
        for (int i = 0; i < p; i++) {
            add(str[i]);
        }
        if (checkSecret == 4) {
            result++;
        }
        for (int i = p; i < s; i++) {
            int j = i-p;
            add(str[i]);
            remove(str[j]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
    }
}

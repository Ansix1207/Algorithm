package BaekJoon;

import java.util.Scanner;

// TODO: 2023/06/15 9095번 1,2,3, 더하기 (실버3)
// TODO: 2023/06/15 !!성공!! (복습 해보기)
public class boj_9095 {
    private static int count = 0;
    public static void rec(int n) {
        if (n == 0) {
            count++;
        }
        else if(n>0){
            rec(n - 1);
            rec(n - 2);
            rec(n - 3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            rec(sc.nextInt());
            System.out.println(count);
            count = 0;
        }
    }
}

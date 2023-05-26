package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//todo:2차원 배열의 합 https://www.acmicpc.net/problem/2167
//todo: 다시 풀어보기
public class boj_2167 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt( stringTokenizer.nextToken() );// N X N 4
        int M = Integer.parseInt( stringTokenizer.nextToken() );//질의 갯수 3

        int A[][] = new int[N+1][N+1];
        for( int i=1; i<=N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());//"1 2 3 4"
            for(int j=1; j<=N; j++) {
                A[i][j] = Integer.parseInt( stringTokenizer.nextToken() );
            }
        }

        int D[][] = new int[N+1][N+1];//누적합을 담을 배열
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                D[i][j] = D[i][j-1]+D[i-1][j] - D[i-1][j-1]+ A[i][j];
            }
        }

//질의 읽어오기
        for( int i=0; i< M ; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());//"2 2 3 4"
            int x1 = Integer.parseInt( stringTokenizer.nextToken() );
            int y1 = Integer.parseInt( stringTokenizer.nextToken() );
            int x2 = Integer.parseInt( stringTokenizer.nextToken() );
            int y2 = Integer.parseInt( stringTokenizer.nextToken() );

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }

    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2023/07/01 2667번 단지번호 붙이기 (실버2) https://www.acmicpc.net/problem/2667
public class boj_2667_단지번호붙이기 {
    static int node[][]; // 아파트 단지 배열
    static int check[][]; // 각 아파트 단지 방문여부 배열
    static int cnt =1;
    static ArrayList<Integer> array = new ArrayList<>(); // 각 단지의 수를 저장

    // 기준행을 기준으로 방문하지 않은 곳이면서 1의 값을 가지는 곳을 상,하,좌,우로 살펴본다
    static void dfs(int x,int y) { // 아파트 단지 배열에서 각 점을 인자로 전달
        check[x][y] =1; // 전달 된 인자는 방문했으므로 1저장
        // cnt변수는 1로 초기화했기 때문에 별도의 증가는 필요없다.

        // 기준열의 오른쪽열을 확인해야 하므로 범위에서+1, 오른쪽열이 1이면서 방문하지 않았다면
        if( y<node.length-1 && node[x][y+1]==1 && check[x][y+1]==0) {
            cnt++; // cnt변수 증가
            dfs(x,y+1); // 오른쪽열로 이동
        }

        //기준행의 아랫쪽행을 확인해야 하므로 범위에서+1, 아랫쪽행이 1이면서 방문하지 않았다면
        if(x<node.length-1 && node[x+1][y]==1&& check[x+1][y]==0) {
            cnt++; // cnt변수 증가
            dfs(x+1,y); // 아랫쪽으로 이동
        }

        //기준열의 왼쪽열을 확인해야 하므로 0보다 커야하며, 왼쪽열이 1이면서 방문하지 않았다면
        if(y>0 &&  node[x][y-1]==1&& check[x][y-1]==0) {
            cnt++; // cnt변수 증가
            dfs(x,y-1); // 왼쪽으로 이동
        }

        //기준행의 윗쪽행을 확인해야 하므로 0보다 커야하며, 윗쪽행이 1이면서 방문하지 않았다면
        if(x>0 &&  node[x-1][y]==1&& check[x-1][y]==0) {
            cnt++; // cnt변수 증가
            dfs(x-1,y); // 윗쪽으로 이동
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine()); // 지도의 크기 n
        node = new int[n][n]; // 지도 배열
        check = new int[n][n]; // 지도 방문배열
        for(int i=0;i<node.length;i++) {
            String row = br.readLine();
            for(int j=0;j<node[i].length;j++) {
                // char -> int 숫자로 변환 위해서 빼준다.
                node[i][j] = row.charAt(j)-'0'; //- '0' =  48
            }
        }
        for(int i=0;i<node.length;i++) {
            for(int j=0;j<node[i].length;j++) {
                if(node[i][j] == 1 && check[i][j]==0) { // 1의값이면서 방문하지 않은 곳의 정보만 전달
                    cnt =1; // cnt변수 초기화
                    dfs(i,j);// 지도의 (0,0)부터 전달
                    array.add(cnt); // 단지의 수를 어레이 리스트에 저장
                }
            }
        }
        System.out.println(array.size()); // 단지의 개수
        Collections.sort(array); // 각 단지의 아파트 수 정렬
        for(int i=0;i<array.size();i++) {
            System.out.println(array.get(i));
        }
    }

}

package BaekJoon;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
// TODO: 2023/05/31 11003번 최솟값 찾기 (플래5) https://www.acmicpc.net/problem/11003
// TODO: 2023/05/31 !!성공!!
class boj_Node {
    int index;
    int value;
    public boj_Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
public class boj_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Deque<boj_Node> deque = new ArrayDeque();
        int N = Integer.parseInt(stk.nextToken()); // 항목의 수
        int L = Integer.parseInt(stk.nextToken());// 윈도우 크기
        int count = 0;
        stk = new StringTokenizer(br.readLine());
//        while (stk.hasMoreTokens()) {
//            deque.add(Integer.parseInt(stk.nextToken()));
//        }
        for (int i = 1; i <= N; i++) {
             boj_Node node = new boj_Node(i, Integer.parseInt(stk.nextToken()));
             if(!deque.isEmpty()&&deque.getFirst().getIndex()<=i-L){
//                 System.out.println("삭제! 윈도우 안 아님 " + node.getIndex() +" : "+ node.getValue() );
                 deque.removeFirst();
             }
            while(!deque.isEmpty()&&node.getValue()<=deque.peekLast().getValue()){
                deque.removeLast();
            }
            deque.addLast(node);
            bw.append(deque.peekFirst().getValue()+" ");
        }
        bw.flush();
    }
}

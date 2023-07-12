package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2023/07/12 1991번 트리순회 https://www.acmicpc.net/problem/1991
// TODO: 2023/07/12 !!성공!!
public class boj_1991_트리순회 {
    static class Node {
        String alpha;
        Node left, right;

        public Node(String alpha) {
            this.alpha = alpha;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            Node n1 = null;
            String rootstr = stk.nextToken();
            if (!list.isEmpty()) {
                for (Node node : list) {
                    if (node.alpha.equals(rootstr)) {
                        n1 = node;
                    }
                }
            } else {
                n1 = new Node(rootstr);
                list.add(n1);
            }
            if (stk.hasMoreTokens()) {
                list.addLast(new Node(stk.nextToken()));
                n1.left = list.getLast();
            }
            if (stk.hasMoreTokens()) {
                list.addLast(new Node(stk.nextToken()));
                n1.right = list.getLast();
            }
        }
        preorder(list.getFirst());
        System.out.println("");
        inorder(list.getFirst());
        System.out.println("");
        postorder(list.getFirst());
    }

    static public void preorder(Node cur) {
        if (cur == null || cur.alpha.equals("."))
            return;
        System.out.print(cur.alpha);
        preorder(cur.left);
        preorder(cur.right);
    }

    static public void inorder(Node cur) {
        if (cur == null || cur.alpha.equals("."))
            return;
        inorder(cur.left);
        System.out.print(cur.alpha);
        inorder(cur.right);
    }

    static public void postorder(Node cur) {
        if (cur == null || cur.alpha.equals("."))
            return;
        postorder(cur.left);
        postorder(cur.right);
        System.out.print(cur.alpha);
    }
}

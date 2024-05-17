import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    // TODO: 2024/05/17
    /**
     * 1. 자료형 int[2]{문제 번호, 난이도} 를 가지는 우선순위 큐를 만든다.
     * 2. 해당 우선순위 큐의 정렬 규칙은 다음과 같다. -> 난이도가 가장 어려운 경우순, 난이도가 같다면 문제 번호가 큰 것
     *      -> 난이도가 가장 쉬운게 많다면, 문제 번호가 작은것으로 -> !!난이도 내림차순, 번호 내림차순!!
     * 3. recommend 명령어에 따라서 1일 경우 맨 앞에서 하나 뽑아주고, -1인 경우 맨 뒤에서 뽑아준다.
     * 4.  add 명령어에 따라서 추가한다.
     *      -> 같은 문제 번호를 가진 문제가 있는지 확인하고, 있다면 해당 난이도로 값을 바꾼다.
     * 5. solved 명령어에 따라서 문제를 삭제한다.
     */
    static PriorityQueue<Problem> pqHard;
    static PriorityQueue<Problem> pqEasy;
    static Map<Integer, Integer> map;
    static StringTokenizer stk;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        pqHard = new PriorityQueue<>((x1, x2) -> {
            if (x1.problemRank == x2.problemRank) {
                return x2.problemNumber - x1.problemNumber;
            }
            return x2.problemRank - x1.problemRank;
        });
        pqEasy = new PriorityQueue<>((x1, x2) -> {
            if (x1.problemRank == x2.problemRank) {
                return x1.problemNumber - x2.problemNumber;
            }
            return x1.problemRank - x2.problemRank;
        });
        map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int problemNumber = Integer.parseInt(stk.nextToken());
            int problemRank = Integer.parseInt(stk.nextToken());
            add(problemNumber, problemRank);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String st = br.readLine();
            String[] str = st.split(" ");
            if (st.contains("add")) {
                int num = Integer.parseInt(str[1]);
                int rank = Integer.parseInt(str[2]);
                add(num, rank);
            } else if (st.contains("recommend")) {
                int op = Integer.parseInt(str[1]);
                recommend(op);
            } else if (st.contains("solved")) {
                int num = Integer.parseInt(str[1]);
                map.remove(num);
                if (pqHard.peek().problemNumber == num) {
                    Problem p = pqHard.poll();
                    pqHard.remove(p);
                    pqEasy.remove(p);
                }else if (pqEasy.peek().problemNumber == num) {
                    Problem p = pqEasy.poll();
                    pqHard.remove(p);
                    pqEasy.remove(p);
                }
            }
        }
//        while (!pqEasy.isEmpty()) {
//            System.out.println(pqEasy.poll().toString());
//        }
//        System.out.println("----- 위는 이지 아래는 하드 ----");
//        while (!pqHard.isEmpty()) {
//            System.out.println(pqHard.poll().toString());
//        }
    }
    static void recommend(int flag){
        if (flag == 1) {
            System.out.println(pqHard.peek().problemNumber);
        } else if (flag == -1) {
            System.out.println(pqEasy.peek().problemNumber);
        }
    }
    static void add(int a, int b) throws IOException {
        deleteDuplicate(a);
        Problem problem = new Problem(a, b);
        map.put(a, b);
        pqHard.add(problem);
        pqEasy.add(problem);
    }

    private static void deleteDuplicate(int a) {
        if (map.containsKey(a)) {
            for (Problem problem : pqHard) {
                if (problem.problemNumber == a) {
                    pqHard.remove(problem);
                    pqEasy.remove(problem);
                    break;
                }
            }
        }
    }

    static class Problem {
        int problemNumber;
        int problemRank;

        public Problem(int problemNumber, int problemRank) {
            this.problemNumber = problemNumber;
            this.problemRank = problemRank;
        }

        @Override
        public String toString() {
            return "number : " + problemNumber + " Rank : " + problemRank;
        }
    }

}

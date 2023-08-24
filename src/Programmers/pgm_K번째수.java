package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class pgm_K번째수 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] solution1 =
                solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            ArrayList<Integer> answer = new ArrayList<Integer>();
            for (int[] command : commands) {
                int[] ints = Arrays.stream(Arrays.copyOfRange(array, command[0]-1, command[1])).sorted().toArray();
                answer.add(ints[command[2] - 1]);
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

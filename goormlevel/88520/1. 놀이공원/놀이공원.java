import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int input = Integer.parseInt(br.readLine());
			for (int i = 0; i < input; i++) {
					StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
					int N = Integer.parseInt(stk.nextToken());
					int K = Integer.parseInt(stk.nextToken());

					int[][] board = new int[N][N];
					for (int j = 0; j < N; j++) {
							stk = new StringTokenizer(br.readLine(), " ");
							int k = 0;
							while (stk.hasMoreTokens()) {
									board[j][k++] = Integer.parseInt(stk.nextToken());
							}
					}

					int answer = Integer.MAX_VALUE;
					for (int j = 0; j < N - K + 1; j++) {
							for (int k = 0; k < N - K + 1; k++) {
									int cnt = 0;
									for (int col = j; col < j + K; col++) {
											for (int row = k; row < k + K; row++) {
													if (board[col][row] == 1) {
															cnt++;
													}
											}
									}
									answer = Math.min(cnt, answer);
							}
					}
					System.out.println(answer);
			}
	}

}
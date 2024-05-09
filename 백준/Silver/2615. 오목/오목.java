import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int size = 21;
    static int[][] board = new int[size][size];
    static boolean isWin = false;
    public static void main(String[] args) throws IOException {
        //검은색이 이기면 1, 흰색이 이기면2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        for (int[] ints : board) {
            Arrays.fill(ints,0);
        }
        for (int i = 1; i <= 19; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                //왼쪽 위에서 시작하여 수직으로 아래로 탐색 -> 그 다음 오른쪽 한칸 이동 하여 탐색
                if (checkOMok(j, i)) {
                    System.out.println(board[j][i]);
                    System.out.println((j) +" "+(i));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean checkOMok(int x, int y) {
        if (board[x][y] == 0) {
            return false;
        }
        if (checkDiagonalTopLeftToBottomRight(x, y) == 5
                || checkDiagonalTopRightToBottomLeft(x, y) == 5
                || checkVertical(x, y) == 5
                || checkHorizon(x, y) == 5) {
            isWin = true;
            return true;
        }
        return false;
    }

    static int checkDiagonalTopLeftToBottomRight(int x, int y) {
        if (board[x][y] == 0) {
            return 0;
        }
        return checkRightBelow(x, y) + checkTopLeft(x, y) + 1;
    }

    static int checkDiagonalTopRightToBottomLeft(int x, int y) {
        if (board[x][y] == 0) {
            return 0;
        }
        return checkLeftBelow(x, y) + checkTopRight(x, y) + 1;
    }

    static int checkVertical(int x, int y) {
        if (board[x][y] == 0) {
            return 0;
        }
        return checkTop(x, y) + checkBottom(x, y) + 1;
    }

    static int checkHorizon(int x, int y) {
        if (board[x][y] == 0) {
            return 0;
        }
        return checkLeft(x, y) + checkRight(x, y) + 1;
    }

    static int checkLeft(int x, int y) {
        if (y - 1 <= 0)
            return 0;
        if (board[x][y - 1] == board[x][y]) {
            return checkLeft(x, y - 1) + 1;
        }
        return 0;
    }

    static int checkRight(int x, int y) {
        if (y + 1 >= size-1)
            return 0;
        if (board[x][y + 1] == board[x][y]) {
            return checkRight(x, y + 1) + 1;
        }
        return 0;
    }

    static int checkTop(int x, int y) {
        if (x - 1 <= 0)
            return 0;
        if (board[x - 1][y] == board[x][y]) {
            return checkTop(x - 1, y) + 1;
        }
        return 0;
    }

    static int checkBottom(int x, int y) {
        if (x + 1 >= size-1)
            return 0;
        if (board[x + 1][y] == board[x][y]) {
            return checkBottom(x + 1, y) + 1;
        }
        return 0;
    }

    static int checkRightBelow(int x, int y) {
        if (x + 1 >= size-1 || y + 1 >= size-1)
            return 0;
        if (board[x + 1][y + 1] == board[x][y]) {
            return checkRightBelow(x + 1, y + 1) + 1;
        }
        return 0;
    }

    static int checkTopLeft(int x, int y) {
        if (x - 1 <= 0 || y - 1 <= 0)
            return 0;
        if (board[x - 1][y - 1] == board[x][y]) {
            return checkTopLeft(x - 1, y - 1) + 1;
        }
        return 0;
    }

    //왼쪽 아래 대각선 체크
    static int checkLeftBelow(int x, int y) {
        if (x + 1 >= size-1 || y - 1 <= 0)
            return 0;
        if (board[x + 1][y - 1] == board[x][y]) {
            return checkLeftBelow(x + 1, y - 1) + 1;
        }
        return 0;
    }

    //오른쪽 위 대각선 체크
    static int checkTopRight(int x, int y) {
        if (x - 1 <= 0 || y + 1 >= size-1)
            return 0;
        if (board[x - 1][y + 1] == board[x][y]) {
            return checkTopRight(x - 1, y + 1) + 1;
        }
        return 0;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[] x_board = {-1, 0, 0, 1};
    static int[] y_board = {0, -1, 1, 0};

    static class Fish {
        int row;
        int col;
        int time;

        public Fish(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static class location {
        int x;
        int y;
        int depth;

        public location(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    static class BabyShark {
        int size = 2;
        int stack = 0;
        public int x;
        public int y;
        int time = 0;

        public void eat(int x, int y) {
            this.x = x;
            this.y = y;
            stack++;
            if (stack== size) {
                size++;
                stack = 0;
//                System.out.printf("레벨업! %d -> %d\n", size - 1, size);
            }
        }
    }

    public static void init(int[][] arr, BabyShark shark, BufferedReader br) throws IOException {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(temp[j]);
                arr[i][j] = v;
                if (v == 9) {
                    arr[i][j] = 0;
                    shark.x = i;
                    shark.y = j;
                }
            }
        }
    }

    //더이상 먹을 수 있는 물고기가 있는지 체크 없으면 false 반환으로 끝냄
    public static boolean checkMap(BabyShark shark, Map<Integer, Integer> fish) {
        for (int fish_size : fish.keySet()) {
            if (fish.get(fish_size) > 0 && shark.size > fish_size) {
                //먹을 물고기 있으면 true 반환
                return true;
            }
        }
        //먹을 물고기 없으면 false 반환
        return false;
    }

    public static boolean checkMove(BabyShark shark, int[][] map, int x, int y) {
        //상어의 크기보다 작거나 같으면 이동 가능
        return map[x][y] <= shark.size;
    }

    public static boolean checkEat(BabyShark shark, int[][] map, int x, int y) {
        //상어의 크기보다 작거나 같으면 이동 가능
        return (map[x][y] < shark.size) && (map[x][y] != 0);
    }

    public static boolean eatFish(BabyShark shark, int[][] map, Queue<location> q) {
        int n = map.length;
        boolean[][] visit = new boolean[n][n];
        q.add(new location(shark.x, shark.y, 0));
        visit[shark.x][shark.y] = true;
//        System.out.printf("%d : %d 상어 위치 (depth : %s, 누적 = %d) \n", shark.x, shark.y, "시작", shark.time);
        location fish = null; // 물고기 위치 초기화
        int minTime = Integer.MAX_VALUE; // 최소 시간 최대치로 초기화

        while (!q.isEmpty()) {
            location location = q.poll();
//            System.out.printf("%d : %d 상어 위치 (depth : %d, 누적 = %d) \n", location.x, location.y, location.depth,
//                    shark.time);
            //움직임 가능 o, 먹을수 있는지?
            int x = location.x;
            int y = location.y;
            int depth = location.depth;
            if (minTime < depth) break; // 만약 최소 시간보다 큰 순간부터는 큐의 성질에 의해 time은 현재 타임과 같거나 크게 됨 따라서 종료

            if (checkEat(shark, map, x, y)) {
                if (fish == null) { // fish에 값이 없다면
                    fish = location;
                    minTime = Math.abs(fish.x - shark.x) + Math.abs(fish.y - shark.y);
                } else { // fish에 값이 있다면 업데이트 가능 여부 판단
                    if (fish.x > location.x || fish.x == location.x && fish.y > location.y) { // 더 행이 높은 곳에 있거나 (row가 더 작은 것 ), 두 행의 높이가 같다면 더 왼쪽에 가까운  것(col이 더 작은 것)
                        fish = location;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + x_board[i];
                int ny = y + y_board[i];
                if (nx >= n || ny >= n || nx < 0 || ny < 0) {
                    continue;
                }
                //움직임 체크, 해당 방향으로 못가면 큐에 더 안넣음
                if (visit[nx][ny] || !checkMove(shark, map, nx, ny)) {
                    continue;
                }
                //못먹으면 큐에넣고 탐색 계속
                visit[nx][ny] = true;
                q.add(new location(nx, ny, location.depth + 1));
            }
        }
        if (fish == null) return false; // 만약 더 이상 물고기가 없다면 종료
        int x = fish.x;
        int y = fish.y;
        int depth = fish.depth;
//        System.out.printf("물고기 먹음 %d : %d (depth:%d)  누적 = %d (물고기 LV:%d,상어 LV:%d)\n", x, y,
//                depth, shark.time+depth, map[x][y], shark.size);
        shark.eat(x, y);
        shark.time += depth;
        map[x][y] = 0;
        return true;
    }

    //자신의 크기보다 큰 물고기가 있는칸은 이동이 불가
    //아기상어는 자신보다 작은 물고기만 먹을 수 있음. (크기가 같으면 먹기 불가, but 지나갈 수 있음)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BabyShark shark = new BabyShark();

        int[][] arr = new int[n][n];
        init(arr, shark, br);
        int turn = 0;
        Queue<location> q = new ArrayDeque<>();
        //먹을수 있는 물고기 체크, 없으면 엄마 상어에게 도움 요청
        while (true) {
            q.clear();
            if (!eatFish(shark, arr, q)) {
                break;
            }
        }
//        System.out.println(shark.x + " : " + shark.y + ": 걸린 시간 : " + shark.time);
        System.out.println(shark.time);
    }
}

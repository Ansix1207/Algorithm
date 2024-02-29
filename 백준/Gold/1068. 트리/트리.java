
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int cnt = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //정점 저장리스트
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = 0;
        visit = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if(v==-1)
            {
                root = i;
                continue;
            }

            list.get(v).add(i);
        }
        int target = sc.nextInt();
        if(target!=root){
            dfs(root,target);
        }

        System.out.println(cnt);
    }
    static void dfs(int num,int target){
        if (list.get(num).size() == 0) {
            cnt++;
            return;
        }
        for (int i = 0; i < list.get(num).size(); i++) {
            int v = list.get(num).get(i);
            if(target==v){
                if(list.get(num).size()==1)
                    cnt++;
                continue;
            }
            dfs(v,target);
        }
    }
}

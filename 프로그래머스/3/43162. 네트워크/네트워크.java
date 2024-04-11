class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0 ; i<visit.length; i++){
            if(!visit[i]){
                dfs(computers,i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, int net){
        visit[net]=true;
        for(int j = 0 ; j<computers[net].length;j++){
            if(computers[net][j] == 1 && visit[j]== false){
                visit[net] = true;
                dfs(computers, j);
            }
        }
    }
}
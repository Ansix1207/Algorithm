class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int index;// 다음 값들을 확인할때 사용
        int move = length - 1;
        
        for(int i = 0 ; i < name.length(); i ++){
            //위아래 움직이는 부분. 어느게 가장 빠른지 확인
            answer += Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i) +1);
            
            //연속되는 A 갯수 확인 (처음에는 A로만 이루어졌다고 했음)
            index = i + 1;
            while(index<length && name.charAt(index)=='A'){
                index++;
            }
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
            
        }
        return answer +move;
    }
}
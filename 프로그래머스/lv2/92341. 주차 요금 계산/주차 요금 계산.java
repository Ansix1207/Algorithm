import java.util.*;
class Solution {
        int HourToMin(String time){
            String[] srr = time.split(":");
            return Integer.parseInt(srr[0]) * 60 + Integer.parseInt(srr[1]);
        }
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            Map<String, Integer> parking = new HashMap<>();//주차된 차량
            Map<String, Integer> times = new HashMap<>(); //누적 주차 시간

            long lastMin =HourToMin("23:59");
            for (String record : records) {
                String[] str = record.split(" ");
                String date = str[0];
                String car = str[1];
                String status = str[2];
                int min =HourToMin(date);
                if(status.equals("IN") && !parking.containsKey(car)){
                    //IN 이고 없으면
                    parking.put(car, min);
                } else if (status.equals("OUT")) {
                    int outMin = min-parking.get(car);
                    parking.remove(car);
                    //1.차가 이미 한번 나간 기록이 있는 경우
                    if (times.containsKey(car)) {
                        times.put(car, times.get(car) + outMin);
                    }else{
                        //2. 기록이 없이 처음 나가는 경우
                        times.putIfAbsent(car, outMin);
                    }
                }
            }
            //남은 In 처리
            for (String s : parking.keySet()) {
                times.put(s, (int) (times.getOrDefault(s, 0) + (lastMin-parking.get(s))));
            }
            List<String> list = new ArrayList<>(times.keySet());
            list.sort((s1, s2) -> s1.compareTo(s2));
            answer = new int[list.size()];
            int i = 0;
            for (String s : list) {
                answer[i++] = getFee(fees,times.get(s));
            }
            return answer;
        }
        int getFee(int[]fees, int totalMin){
            int baseT = fees[0];
            int baseF = fees[1];
            int perMin = fees[2];
            int feePerMin = fees[3];

            if(totalMin<baseT){
                return baseF;
            }
            return baseF + (int) (Math.ceil((totalMin-baseT)/(double) perMin)) * feePerMin;


        }
    }
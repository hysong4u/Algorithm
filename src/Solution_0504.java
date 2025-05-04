class Solution_0504 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int [] availabelTime = getAvailableTime(schedules);
        answer = compareTimelogs(availabelTime,timelogs,startday);
        return answer;
    }

    int[] getAvailableTime(int[] schedules){ // 기존 배열 쓰지말고 새로운 배열 만들기
        int[] availabelTime = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++ ){
            availabelTime[i] = schedules[i] + 10;
        }
        return availabelTime;
    }

    int compareTimelogs(int[] availabelTime, int[][] timelogs, int startday){
        int count = 0;
        for (int i = 0; i < availabelTime.length; i++){
            boolean isSuccess = true;
            for (int j = 0; j < 7; j++ ){
                int dayIndex = (startday +j -1) % 7;

                if(dayIndex == 5 || dayIndex == 6) {
                    continue;
                }
                if (timelogs[i][j] > availabelTime[i]){
                    isSuccess = false;
                    break;
                }
            }
            if(isSuccess){count ++;}
        }
        return count;
    }





}



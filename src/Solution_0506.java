public class Solution_0506 {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] giftTable = getGiftTable(friends, gifts);
        int[] giftScore = getGiftScore(giftTable);

        answer = getNextMonthGift(giftTable, giftScore);

        return answer;
    }

    static int[][] getGiftTable(String[] friends, String[] gifts) {
        int length = friends.length;
        int[][] giftTable = new int[length][length];

        for (int i = 0; i < gifts.length; i++) {
            String sender = gifts[i].substring(0, gifts[i].indexOf(" "));
            String receiver = gifts[i].substring(gifts[i].indexOf(" ") + 1);

            int senderIdx = -1;
            int receiverIdx = -1;
            for (int j = 0; j < length; j++) {
                if (friends[j].equals(sender)) senderIdx = j;
                if (friends[j].equals(receiver)) receiverIdx = j;
            }
            giftTable[senderIdx][receiverIdx] += 1;
        }
        return giftTable;
    }

    static int[] getGiftScore(int[][] giftTable) {
        int giftScore[] = new int[giftTable.length];
        for (int i = 0; i < giftTable.length; i++) {
            int receiveCnt = 0;
            int sendCnt = 0;

            for (int j = 0; j < giftTable.length; j++) {
                sendCnt += giftTable[i][j];
                receiveCnt += giftTable[j][i];
            }
            giftScore[i] = sendCnt - receiveCnt;
        }
        return giftScore;
    }

    static int getNextMonthGift(int[][] giftTable, int giftScore[]) {
        int nextMonthGift[] = new int[giftTable.length];
        for (int i = 0; i < giftTable.length; i++) {
            for (int j = 0; j < giftTable.length; j++) {
                if (i == j) continue; // 자기 자신 skip
                if (giftTable[i][j] > giftTable[j][i]) { // i가 j에게 준 선물 수  > j가 i에게 준 선물 수
                    nextMonthGift[i] += 1;
                }
                else if (giftTable[i][j] == giftTable[j][i]) {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGift[i] += 1;
                    }
                }
            }

        }
        int maxGift = 0;
        for (int gift : nextMonthGift) {
            maxGift = Math.max(maxGift, gift);
        }
        return maxGift;
    }
}

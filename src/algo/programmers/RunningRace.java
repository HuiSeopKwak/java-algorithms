package algo.programmers;
/***
 * 달리기 경주
 * programmars lv1
 */

import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> nameRank = new HashMap<>();
            Map<Integer, String> rankName = new HashMap<>();

            for (int i = 0; i < players.length; i++) {
                nameRank.put(players[i], i);
                rankName.put(i, players[i]);
            }
            // 역전할 플레이어의 등수 받아오기
            // 그 앞등수 선수의 이름 받아오기
            // 두 map에 등수 교체 진행
            for (int i = 0; i < callings.length; i++) {
                String p1Name = callings[i];
                int p1Rank = nameRank.get(callings[i]);
                String p2Name = rankName.get(p1Rank - 1);
                int p2Rank = nameRank.get(p2Name);

                nameRank.put(p1Name, p1Rank - 1);
                rankName.put(p1Rank - 1, p1Name);
                nameRank.put(p2Name, p2Rank + 1);
                rankName.put(p2Rank + 1, p2Name);

                // System.out.println(nameRank.toString());
            }

            String[] answer = new String[players.length];
            for (int i = 0; i < players.length; i++) {
                answer[i] = rankName.get(i);
            }

            return answer;
        }
    }
}

package algo.programmers;

/***
 * JadenCase 문자열 만들기
 * programmers lv2
 */
public class JadenCase {

    class Solution {
        public String solution(String s) {

            // 공백이 여러개 있을수 있어서 각 공백들 살리기 위해 limit 자리에 -1 추가
            String[] words = s.split(" ", -1);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (j == 0 && !Character.isDigit(c)) {
                        sb.append(Character.toUpperCase(c));
                    }
                    else if (!Character.isDigit(c))
                        sb.append(Character.toLowerCase(c));
                    else
                        sb.append(c);
                }
                if (i != words.length - 1) sb.append(" ");
            }

            String answer = sb.toString();
            System.out.println(answer);
            return answer;
        }
    }

}

package algo.programmers;
/**
 * 가장 큰 수
 * programmars lv2
 */

import java.util.Arrays;

public class BiggestNumber {

    class Solution {
        public String solution(int[] numbers) {
//         String[] nums = new String[numbers.length];

//         for (int i = 0; i < numbers.length; i++)
//             nums[i] = String.valueOf(numbers[i]);

//         Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

//         if (nums[0].equals("0"))
//             return "0";

//         StringBuilder sb = new StringBuilder();
//         for (String s : nums)
//             sb.append(s);

            String[] nums = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                nums[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            StringBuilder sb = new StringBuilder();

            if (nums[0] == "0")
                return "0";

            for (String s : nums)
                sb.append(s);

            return sb.toString();
        }
    }
}

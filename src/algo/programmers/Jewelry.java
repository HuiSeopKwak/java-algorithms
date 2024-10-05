package algo.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Jewelry {
	
	public static void main(String[] args) {
//		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		int left = 0;
//		int right = 0;
//		int select[];
//		
//		Set<String> jewelry = new HashSet<>();
//		
//		for (int i = 0; i < gems.length; i++) {
//			jewelry.add(gems[i]);
//		}
//		
//		select = new int[jewelry.size()];
//		
//		while (left <= right && right < gems.length) {	// right값이 마지막까지 돌때까지 탐색
//			if ()
//		}
		
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
        
        // 1. 대괄호 제거
        str = str.substring(1, str.length() - 1);
        
        // 2. 쉼표 기준으로 문자열을 나눠 배열로 변환
        String[] arr = str.split(",");
        
        // 3. 각 요소에 대해 공백과 따옴표 제거
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim().replaceAll("\"", "");
        }
        
        // 4. 결과 출력
        System.out.println(Arrays.toString(arr));
		
	}

}

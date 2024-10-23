package algo.study2.week11;
/**
 * 백준 11478 서로 다른 부분 문자열의 개수
 * 메모리 : 233144 KB
 * 시간 : 884 ms
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj11478 {

	static Set<String> set = new HashSet<>();
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			check("" + str.charAt(i), i + 1);
		}
		
		System.out.println(set.size());
	}
	
	public static void check(String sstr, int idx) {
		set.add(sstr);
		if (idx < str.length()) {
			check(sstr + str.charAt(idx), idx + 1);
		}
	}
}
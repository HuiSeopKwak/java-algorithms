package algo.study2.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj6603 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> selected = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); 
            }
            
            select(0, 0);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static void select(int idx, int size) {
        if (size == 6) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = idx; i < N; i++) {
            selected.add(arr[i]);
            select(i + 1, size + 1);
            selected.remove(selected.size() - 1);
        }
    }
}

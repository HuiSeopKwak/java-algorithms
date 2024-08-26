package algo.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 8980 택배
 * 메모리 : KB 
 * 시간 : ms
 *
 */
class Box implements Comparable<Box>{    // 보내는 마을, 받는 마을, 최대 박스 수 클래스
    int from;
    int to;
    int pcs;
    
    public Box(int from, int to, int pcs) {
        this.from = from;
        this.to = to;
        this.pcs = pcs;
    }

    @Override
    public int compareTo(Box o) {
    	return this.from == o.from ? this.to - o.to : this.from - o.from;
    }
}

public class Boj8980 {
//public class Main {
    static int N, C, M; // N개는 마을의 수, C는 트럭의 용량, M은 보내는 박스의 개수
    static int[] sensors; // 센서 배열
    static int fr, t, p;    // 보내는 마을, 받는 마을, 최대 박스 수
    static int weight;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        Box[] Boxes = new Box[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            fr = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            
            Boxes[i] = new Box(fr, t, p);
        }
        
        Arrays.sort(Boxes);
        
        
        
    }
}
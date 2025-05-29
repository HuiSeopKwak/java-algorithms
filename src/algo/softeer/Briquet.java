package algo.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Briquet {
    static int n, maxSize;
    static int[] house;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        house = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
            maxSize = Math.max(maxSize, house[i]);
        }

        for (int i = 2; i < maxSize + 1; i++) {
            int tempMax = 0;
            for (int size : house) {
                if (size % i == 0)
                    tempMax++;
            }
            answer = Math.max(tempMax, answer);
        }
        System.out.println(answer);
    }
}

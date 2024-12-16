package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11723 {
    static int M;
    static int bitset;  // 비트 연산을 위한 숫자 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int orderNum;

            switch(order) {
                case "add" :
                    orderNum = Integer.parseInt(st.nextToken());
                    bitset = bitset | 1 << (orderNum - 1);
                    break;
                case "remove" :
                    orderNum = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << (orderNum - 1));
                    break;
                case "check" :
                    orderNum = Integer.parseInt(st.nextToken());
                    if ((bitset & (1 << (orderNum - 1))) == 0)
                        sb.append("0\n");
                    else
                        sb.append("1\n");
                    break;
                case "toggle" :
                    orderNum = Integer.parseInt(st.nextToken());
                    bitset = bitset ^ 1 << (orderNum - 1);
                    break;
                case "all" :
                    bitset = bitset | ~0;
                    break;
                case "empty" :
                    bitset = bitset & 0;
                    break;
                default:
                    return;
            }
        }
        System.out.println(sb);
    }
}

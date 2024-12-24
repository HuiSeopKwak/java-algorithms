package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String temp;
            int count = 0;
            temp = br.readLine();

            for (int i = 0; i < temp.length(); i++) {
                char t = temp.charAt(i);

                if (t == '#')
                    return;

                if (t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U') count++;
                else if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') count++;
            }
            System.out.println(count);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, cnt = 0;
        while(true) {
            cnt++;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0)
                break;
            int ans = 0;
            for(int i = 0; i < 60000; i++) {
                int x = i * (i + 1) / 2;
                if(x + 1 <= a || x + 1 >= b)
                    continue;
                int square = (int) Math.sqrt(x + 1) * (int)Math.sqrt(x + 1);
                if(square == x + 1)
                    ans++;
            }
            System.out.println("Case " + cnt + ": " + ans);
        }
    }
}
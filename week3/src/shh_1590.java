import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class shh_1590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int minvalue = Integer.MAX_VALUE;

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (S + I * (C - 1) < T) continue;

            int start = 0;
            int end = C - 1;
            int ans = Integer.MAX_VALUE;

            while (start <= end) {
                int mid = (start + end) / 2;
                int currentValue = S + I * mid;

                if (currentValue >= T) {
                    ans = currentValue;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (ans != Integer.MAX_VALUE) {
                minvalue = Math.min(minvalue, ans - T);
            }
        }

        if (minvalue == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minvalue);
        }
    }
}

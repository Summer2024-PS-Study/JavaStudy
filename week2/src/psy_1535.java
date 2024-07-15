import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_1535 {
    static int N;
    static int[] L, R;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        N = Integer.parseInt(token[0]);
        L = new int[N];
        R = new int[N];

        // i번째 사람에게 인사할 때 잃는 체력
        token = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            L[i] = Integer.parseInt(token[i]);
        }

        // i번째 사람에게 인사할 때 얻는 기쁨
        token = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            R[i] = Integer.parseInt(token[i]);
        }

        System.out.println(subset_happy(0,0, 0));
    }

    // 합해서 99이하가 되는 경우의 수
    // idx: 현재 처리중인 인덱스
    // strength_sum: 현재까지 소모한 체력
    // joy_sum: 기쁨의 최댓값
    static int subset_happy(int idx, int strength_sum, int joy_sum) {
        if (strength_sum > 99)
            return 0;

        if (idx == N)
            return joy_sum;

        // 현재 요소를 선택하지 않는 경우
        int without = subset_happy(idx + 1, strength_sum, joy_sum);

        // 현재 요소를 선택하는 경우
        int with = subset_happy(idx+1, strength_sum+L[idx], joy_sum+R[idx]);

        return Math.max(with, without);
    }
}

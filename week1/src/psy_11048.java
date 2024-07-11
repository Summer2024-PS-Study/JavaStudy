import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        // N,M 입력받기
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        int[][] arr = new int[N][M]; // 사탕의 갯수
        int[][] dp = new int[N+1][M+1]; // 사탕의 최댓값

        // 미로 내 사탕 갯수 입력받기
        for (int i = 0; i<N ; i++) {
            token = br.readLine().split(" ");
            for (int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(token[j]);
            }
        }

        // 주울 수 있는 사탕의 최댓값 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][M]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_2458 {
    private static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        int[][] graph = new int[N][N];

        // 인접행렬 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    graph[i][j] = 0; // 자기 자신으로의 경로는 0
                } else {
                    graph[i][j] = INF; // 그 외의 경로는 무한대 (INF)
                }
            }
        }

        // 간선 추가
        for (int i = 0; i < M; i++) {
            token = br.readLine().split(" ");
            graph[Integer.parseInt(token[0]) - 1][Integer.parseInt(token[1]) - 1] = 1;
        }

        // 플로이드-워셜 알고리즘 수행
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && (graph[i][j] != INF || graph[j][i] != INF)) {
                    count++;
                }
            }
            if (count == N - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}

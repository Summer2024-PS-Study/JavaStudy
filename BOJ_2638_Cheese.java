package Main;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[][] cheese;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void checkMelting(int x, int y) {
        int count = 0;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (isValid(nx, ny) && cheese[nx][ny] == 3)
                count++;
        }
        if (count >= 2) // remaining of the cheese is turned '2'. It'll be eliminated later
            cheese[x][y] = 2;
    }

    //The array that aligned the outer will be turned '3' by DFS
    static void checkAir(int x, int y) {
        visited[x][y] = true;
        cheese[x][y] = 3; // 3 means the outer space of the cheese

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isValid(nx, ny))
                continue;
            if (visited[nx][ny] || cheese[nx][ny] == 1 || cheese[nx][ny] == 2)
                continue;
            checkAir(nx, ny);
        }
    }

    public static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++)
                cheese[i][j] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            visited = new boolean[N][M];
            checkAir(0, 0);
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (cheese[i][j] == 1)
                        checkMelting(i, j);

            int restOfCheese = 0;
            for (int i = 0; i < N; i++) { // eliminate melted cheese
                for (int j = 0; j < M; j++) {
                    if (cheese[i][j] == 1)
                        restOfCheese++;
                    if (cheese[i][j] == 2)
                        cheese[i][j] = 0;
                }
            }
            answer++;
            if (restOfCheese == 0)
                break;
        }

        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
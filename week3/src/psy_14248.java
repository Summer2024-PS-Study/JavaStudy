import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class psy_14248 {
    public static boolean[] visitedFlag; // 돌의 방문 여부
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        int n = Integer.parseInt(token[0]);
        int[] stone = new int[n+1];
        visitedFlag = new boolean[n+1];


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        token = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            stone[i] = Integer.parseInt(token[i-1]);
        }

        token = br.readLine().split(" ");
        int Ai = Integer.parseInt(token[0]);

        for (int i = 1; i <= n; i++) {
            if (i+stone[i]<=n) {
                graph.get(i).add(i+stone[i]);
            }
            if (i-stone[i]>0) {
                graph.get(i).add(i-stone[i]);
            }
        }
        System.out.println(dfs(Ai));
    }

    public static int dfs(int point) {
        int visited = 0;

        visitedFlag[point] = true;
        visited++;

        for (int node : graph.get(point)) {
            if (!visitedFlag[node]) {
                visited += dfs(node);
            }
        }

        return visited;
    }
}
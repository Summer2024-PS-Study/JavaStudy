import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class psy_1939 {
    public static int[][] arr;
    public static int N;
    private static boolean[] visited;
    private static List<List<Integer>> allPaths = new ArrayList<>();
    private static int max_weight = 0;

    static class Graph {
        public Graph(int N) {
            arr = new int[N+1][N+1];
        }

        public List<List<Integer>> findAllPath(int start, int end) {
            boolean[] visited = new boolean[N+1];
            List<Integer> currentPath = new ArrayList<>();
            search(start, end, visited, currentPath, allPaths);
            return allPaths;
        }

        public static void search(int current, int end, boolean[] visited, List<Integer> currentPath, List<List<Integer>> allPaths) {
            visited[current] = true;
            currentPath.add(current);

            if (current == end) {
                allPaths.add(new ArrayList<>(currentPath));
            } else {
                for (int neighbor = 1; neighbor <= N; neighbor++) {
                    if (arr[current][neighbor] != 0 && !visited[neighbor]) {
                        search(neighbor, end, visited, currentPath, allPaths);
                        if (max_weight < arr[current][neighbor])
                            max_weight = arr[current][neighbor];
                    }
                }
            }

            // Backtrack
            visited[current] = false;
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        Graph graph = new Graph(N);
        arr = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            token = br.readLine().split(" ");
            arr[Integer.parseInt(token[0])][Integer.parseInt(token[1])] = Integer.parseInt(token[2]);
            arr[Integer.parseInt(token[1])][Integer.parseInt(token[0])] = Integer.parseInt(token[2]);
        }

        token = br.readLine().split(" ");
        int DP = Integer.parseInt(token[0]);
        int AP = Integer.parseInt(token[1]);

        List<List<Integer>> allPaths = graph.findAllPath(AP, DP);

        System.out.println(max_weight);
    }
}


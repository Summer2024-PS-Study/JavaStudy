import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class psy_1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] inputs = new String[N];
        int[][] arr = new int[N][N];
        ArrayList<ArrayList<Integer>> link = new ArrayList<>();
        int[] link_node = new int[N];

        for (int i = 0; i < N; i++) {
            link.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextLine();
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < inputs[i].length(); j++) {
                if (inputs[i].charAt(j) == 'Y') {
                    sum += 1;
                    arr[i][j] = 1;
                    link.get(i).add(j);
                }
            }
            link_node[i] = sum;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                    visited[j] = true;
                }
            }

            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < N; k++) {
                        if (arr[j][k] == 1 && k != i && !visited[k]) {
                            sum++;
                            visited[k] = true;
                        }
                    }
                }
            }

            if (max < sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}

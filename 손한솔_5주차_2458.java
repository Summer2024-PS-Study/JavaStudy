import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int graph[][] = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    if(graph[i][k] + graph[k][j] == 2)
                        graph[i][j] = 1;

        for(int i = 1; i <= n; i++) {
            int flag = 1;
            for(int  j = 1; j <= n; j++){
                if(i == j)
                    continue;
                if(graph[i][j] == 0 && graph[j][i] == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                ans++;
        }
        System.out.println(ans);
    }
}
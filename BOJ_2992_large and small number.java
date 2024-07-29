package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    boolean visited[] = new boolean[6];
    int n;
    char a[] = new char[6];
    char b[] = new char[6];
    int min = 987654321;

    public static void solve(int cnt){
        if(cnt == n){
            aVal = Integer.valueOf(String.valueOf(a);
            bVal = Integer.valueOf(String.valueOf(b);
            if(aVal < bVal)
                if(min > bVal)
                    min = bVal;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                b[cnt] = a[i];
                solve(cnt + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        a = temp.toCharArray();
        n = a.length();
        b = a.clone();
        solve(0);
        if(min == 987654321)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
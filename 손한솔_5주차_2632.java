import java.io.*;
import java.util.*;

public class Main3 {
    public static void calCombOfPizza(int size, int[] pizza, HashMap<Integer, Integer> pizzaHash) {
        for (int i = 0; i < size; i++) { // starting point of the combination
            int pizzaSum = pizza[i];
            // aggregate the sum of pizza size when pizza i is added
            pizzaHash.put(pizzaSum, pizzaHash.getOrDefault(pizzaSum, 0) + 1);
            // Add one more case(combination) to the case of pizzaSum

            for (int j = 1; j < size - 1; j++) { // in case of getting j more pizza slices
                pizzaSum += pizza[(i + j) % size];
                pizzaHash.put(pizzaSum, pizzaHash.getOrDefault(pizzaSum, 0) + 1);
            }
        }

        pizzaHash.put(0, pizzaHash.getOrDefault(0, 0) + 1); // in cases of that no pizza slices are used
        int totalSum = 0;
        for(int i = 0; i < size; i++)
            totalSum += pizza[i];
        pizzaHash.put(totalSum, pizzaHash.getOrDefault(totalSum, 0) + 1); // in cases of that every pizza slice is used
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int key = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] aPizza = new int[m];
        int[] bPizza = new int[n];
        HashMap<Integer, Integer> pizzaHashA = new HashMap<>();
        HashMap<Integer, Integer> pizzaHashB = new HashMap<>();

        for (int i = 0; i < m; i++)
            aPizza[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            bPizza[i] = Integer.parseInt(br.readLine());

        calCombOfPizza(m, aPizza, pizzaHashA);
        calCombOfPizza(n, bPizza, pizzaHashB);

        int res = 0;

        // number of cases using i size on pizza A * (key that customer want - number of cases using i size on pizza B)
        for (int i = 0; i <= key; i++)
            res += pizzaHashA.getOrDefault(i, 0) * pizzaHashB.getOrDefault(key - i, 0);

        System.out.println(res);
    }
}
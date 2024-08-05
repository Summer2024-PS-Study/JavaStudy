import java.util.*;

public class Main {
    // caculate satisfaction based on the question
    public static double getSatisfaction(int[] teamScores) {
        return 1 - (Math.abs((teamScores[0] + teamScores[1]) / 2.0 - (teamScores[2] + teamScores[3]) / 2.0) / 10.0);
    }
    
    public static void permute(int[] arr, int k, List<int[]> permutations) {
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1, permutations);
            swap(arr, k, i);
        }
        if (k == arr.length - 1) {
            permutations.add(arr.clone());
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = scanner.nextInt();
        }

        // make permutation for backtracking
        List<int[]> permutations = new ArrayList<>();
        permute(scores, 0, permutations);

        double answer = 0;

        for (int[] perm : permutations) {
            int[] team1 = Arrays.copyOfRange(perm, 0, 4);
            int[] team2 = Arrays.copyOfRange(perm, 4, 8);
            // permutations elements in index 0 ~ 3 are team1
            // permutations elements in index 4 ~ 7 are team1
            
            double team1Satisfaction = getSatisfaction(team1);
            double team2Satisfaction = getSatisfaction(team2);

            double minSatisfaction = Math.min(team1Satisfaction, team2Satisfaction);

            if (answer < minSatisfaction) {
                answer = minSatisfaction;
            }
        }

        System.out.println(answer);
        scanner.close();
    }
}
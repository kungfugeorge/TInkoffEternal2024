import java.util.Scanner;

// Another partial solution

public class Task12b {
    public static long countReachableSums(long N, int A, int B, int C) {
        int maxCheck = A * B * C;
        boolean[] dp = new boolean[maxCheck];
        dp[0] = true;

        int[] coins = {A, B, C};
        for (int coin : coins) {
            for (int i = coin; i < maxCheck; i++) {
                if (dp[i - coin]) {
                    dp[i] = true;
                }
            }
        }

        long countReachableSumsUpToMaxCheck = 0;
        for (int i = 1; i < maxCheck; i++) {
            if (dp[i]) {
                countReachableSumsUpToMaxCheck++;
            }
        }

        long fullBlocks = N / maxCheck;
        long remaining = N % maxCheck;

        long totalReachableSums = fullBlocks * countReachableSumsUpToMaxCheck;

        for (int i = 1; i <= remaining; i++) {
            if (dp[i]) {
                totalReachableSums++;
            }
        }

        return totalReachableSums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        long result = countReachableSums(N, A, B, C);
        System.out.println(result);
    }
}

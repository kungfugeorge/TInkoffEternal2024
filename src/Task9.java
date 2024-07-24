import java.util.Scanner;

// PS

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 101;
        int n = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int INF = (int) 1e9;
        int[][] dp = new int[N][N];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i][j], (dp[i - 1][j] + arr[i]));
                if (arr[i] > 100) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], (dp[i - 1][j] + arr[i]));
                }
                if (j >= 1) {
                    dp[i][j - 1] = Math.min(dp[i][j - 1], (dp[i - 1][j]));
                }
            }
        }
        int ans = INF;
        for (int j = 0; j <= n; j++) {
            ans = Math.min(ans, dp[n][j]);
        }
        System.out.println(ans);
    }
}

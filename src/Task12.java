import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Partial solution

public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int[] coins = new int[3];
        for (int i = 0; i < 3; i++) {
            coins[i] = sc.nextInt();
        }
        List<Integer> wallet = fillWallet(N, coins);
        System.out.println(wallet.size());
    }

    private static List<Integer> fillWallet(long n, int[] coins) {
        boolean[] dp = new boolean[(int) (n + 1)];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int coin : coins) {
                    if (i + coin <= n) {
                        dp[i + coin] = true;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                list.add(i);
            }
        }
        return list;
    }
}

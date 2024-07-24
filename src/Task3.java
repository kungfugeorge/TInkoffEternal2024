import java.util.Scanner;

// OK

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int id = sc.nextInt();
        id--;

        int ans = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            int h = a[x];
            boolean flag = true;
            int dist = 0;
            for (int i = x; i < n; i++) {
                if (i != x) {
                    dist += a[i] - a[i - 1];
                }
                if (id == i && dist > t) {
                    flag = false;
                    break;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (x == 0) {
                    break;
                }
                dist += a[i + 1] - a[i];
                if (id == i && dist > t && id < x) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans = Math.min(ans, dist);
            }

            flag = true;
            dist = 0;
            for (int i = x; i >= 0; i--) {
                if (i != x) {
                    dist += a[i + 1] - a[i];
                }
                if (id == i && dist > t) {
                    flag = false;
                    break;
                }
            }
            for (int i = 1; i < n; i++) {
                if (x == n - 1) {
                    break;
                }
                dist += a[i] - a[i - 1];
                if (id == i && dist > t && id > x) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.min(ans, dist);
            }
        }
        System.out.println(ans);
    }
}

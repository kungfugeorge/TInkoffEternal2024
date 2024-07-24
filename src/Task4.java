import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// OK

public class Task4 {
    public static void main(String[] args) {
        final int N = 1001;
        int n, k;
        long[] a = new long[N];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        ArrayList<Long> b = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            int x = 1;
            while (a[i] > 0) {
                long ch = (a[i] % 10);
                a[i] = (a[i] / 10);
                b.add(((9 - ch) * x));
                x *= 10;
            }
        }
        b.sort(Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < Math.min(k, b.size()); i++) {
            long x = b.get(i);
            ans += x;
        }
        System.out.println(ans);
    }
}
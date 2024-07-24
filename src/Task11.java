import java.util.Scanner;

public class Task11 {

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) // Если exp нечетное
                result = (result * base) % mod;
            exp = exp >> 1; // exp = exp / 2
            base = (base * base) % mod; // base = base^2 % mod
        }
        return result;
    }

    static long modInverse(long a, long p) {
        return modPow(a, p - 2, p);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int p = scanner.nextInt();

        long sum = 0;

        for (int x = l; x <= r; x++) {
            sum = (sum + modInverse(x, p)) % p;
        }

        System.out.println(sum);
    }
}

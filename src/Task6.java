import java.util.Scanner;

// OK

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }

        int cntC = 0;
        int cntN = 0;
        int C = (n / 2);
        int N = ((n + 1) / 2);
        int A = 0;
        int B = 0;
        int ansI = 0;
        int ansJ = 0;
        for (int i = 1; i <= n; i++) {
            cntC += (arr[i] % 2 == 0 ? 1 : 0);
            cntN += (arr[i] % 2 == 1 ? 1 : 0);
            if (i % 2 == 1 && arr[i] % 2 == 0) {
                A++;
                ansI = i;
            }
            if (i % 2 == 0 && arr[i] % 2 == 1) {
                B++;
                ansJ = i;
            }
        }
        if (A == 0 && B == 0) {
            if (cntC >= 2) {
                System.out.println("2 4");
            } else if (cntN >= 2) {
                System.out.println("1 3");
            } else {
                System.out.println("-1 -1");
            }
            return;
        }
        if (C == cntC && N == cntN && A == 1 && B == 1) {
            System.out.println(ansI + " " + ansJ);
        } else {
            System.out.println("-1 -1");
        }
    }
}

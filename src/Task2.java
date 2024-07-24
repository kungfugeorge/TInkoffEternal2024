import java.util.Scanner;

// OK

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        long step = 1;
        int N = 0;
        while (step < s) {
            step *= 2;
            N++;
        }
        System.out.println(N);
    }
}

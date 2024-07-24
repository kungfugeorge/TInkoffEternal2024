import java.util.Scanner;

// OK

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int cost = a;

        if (b >= d) {
            System.out.println(cost);
        } else {
            int raz = (d - b);
            cost += (raz * c);
            System.out.println(cost);
        }
    }
}

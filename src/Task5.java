import java.util.Scanner;

// OK

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            long ch = i;
            while (true) {
                if (ch > r) {
                    break;
                }
                if (ch >= l && ch <= r) {
                    count++;
                }
                ch = (ch * 10 + i);
            }
        }
        System.out.println(count);
    }
}

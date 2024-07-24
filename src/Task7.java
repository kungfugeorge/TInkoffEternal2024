import java.util.*;

// PS

public class Task7 {

    public static List<Integer> findCycle(int n, int[] a) {
        boolean[] visited = new boolean[n + 1];
        int current = 1;

        while (!visited[current]) {
            visited[current] = true;
            current = a[current - 1];
        }

        int cycleStart = current;
        List<Integer> cycle = new ArrayList<>();
        while (true) {
            cycle.add(current);
            current = a[current - 1];
            if (current == cycleStart) {
                break;
            }
        }

        return cycle;
    }

    public static int[] solveSecretSanta(int n, int[] a) {
        List<Integer> cycle = findCycle(n, a);

        if (cycle.size() == n && cycle.get(0) == 1) {
            return new int[]{-1, -1};
        }

        Set<Integer> cycleSet = new HashSet<>(cycle);
        for (int i = 0; i < n; i++) {
            if (!cycleSet.contains(i + 1)) {
                for (int j = 0; j < n; j++) {
                    if (a[j] == cycle.get(0)) {
                        return new int[]{j + 1, i + 1};
                    }
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] result = solveSecretSanta(n, a);
        System.out.println(result[0] + " " + result[1]);
    }
}

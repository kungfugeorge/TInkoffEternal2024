import java.util.Scanner;

// CE

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение координат переговорки
        double roomX = scanner.nextDouble();
        double roomY = scanner.nextDouble();

        // Чтение координат плана
        double[] plan = new double[8];
        for (int i = 0; i < 8; i++) {
            plan[i] = scanner.nextDouble();
        }

        // Координаты диагоналей переговорки
        Point roomDiagonal1Start = new Point(0, 0);
        Point roomDiagonal1End = new Point(roomX, roomY);
        Point roomDiagonal2Start = new Point(roomX, 0);
        Point roomDiagonal2End = new Point(0, roomY);

        // Координаты диагоналей плана
        Point planDiagonal1Start = new Point(plan[0], plan[1]);
        Point planDiagonal1End = new Point(plan[4], plan[5]);
        Point planDiagonal2Start = new Point(plan[2], plan[3]);
        Point planDiagonal2End = new Point(plan[6], plan[7]);

        // Найти точки пересечения диагоналей
        Point roomIntersection = getIntersection(roomDiagonal1Start, roomDiagonal1End, roomDiagonal2Start, roomDiagonal2End);
        Point planIntersection = getIntersection(planDiagonal1Start, planDiagonal1End, planDiagonal2Start, planDiagonal2End);

        // Проверка, совпадают ли точки пересечения
        if (roomIntersection.equals(planIntersection)) {
            System.out.printf("%.5f %.5f\n", roomIntersection.x, roomIntersection.y);
        } else {
            System.out.println("No such point exists.");
        }

        scanner.close();
    }

    // Метод нахождения точки пересечения двух отрезков
    private static Point getIntersection(Point p1, Point p2, Point p3, Point p4) {
        double a1 = p2.y - p1.y;
        double b1 = p1.x - p2.x;
        double c1 = a1 * p1.x + b1 * p1.y;

        double a2 = p4.y - p3.y;
        double b2 = p3.x - p4.x;
        double c2 = a2 * p3.x + b2 * p3.y;

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            // Линии параллельны
            return null;
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
    }

    // Вспомогательный класс для представления точки
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Point point = (Point) obj;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }
    }
}


//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Task8 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double[] p1 = new double[2];
//        double[] p2 = new double[8];
//        for (int i = 0; i < p1.length; i++) {
//            p1[i] = sc.nextDouble();
//        }
//        for (int i = 0; i < p2.length; i++) {
//            p2[i] = sc.nextDouble();
//        }
//        List<double[]> A1 = new ArrayList<>();
//        List<double[]> A2 = new ArrayList<>();
//        A1.add(new double[]{0, 0});
//        A1.add(new double[]{p1[0], 0});
//        A1.add(new double[]{p1[0], p1[1]});
//        A1.add(new double[]{0, p1[1]});
//
//        A2.add(new double[]{p2[0], p2[1]});
//        A2.add(new double[]{p2[2], p2[3]});
//        A2.add(new double[]{p2[4], p2[5]});
//        A2.add(new double[]{p2[6], p2[7]});
//
//
//    }
//
//    public static boolean ok(double[] a, double[] x){
//        return true;
//    }
//}

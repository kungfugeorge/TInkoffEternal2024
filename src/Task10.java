import java.util.*;
import java.awt.geom.*;

// OK

public class Task10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Point2D.Double[] points = new Point2D.Double[n];

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point2D.Double(x, y);
        }

        double totalArea = polygonArea(points);
        double left = Arrays.stream(points).mapToDouble(p -> p.x).min().getAsDouble();
        double right = Arrays.stream(points).mapToDouble(p -> p.x).max().getAsDouble();
        double eps = 1e-7;

        while (right - left > eps) {
            double mid = (left + right) / 2;
            if (cutArea(points, mid) * 2 < totalArea) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.printf("%.7f\n", (left + right) / 2);
    }

    private static double polygonArea(Point2D.Double[] points) {
        double area = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            Point2D.Double p1 = points[i];
            Point2D.Double p2 = points[(i + 1) % n];
            area += p1.x * p2.y - p2.x * p1.y;
        }

        return Math.abs(area) / 2.0;
    }

    private static double cutArea(Point2D.Double[] points, double xLine) {
        List<Point2D.Double> leftPolygon = new ArrayList<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            Point2D.Double p1 = points[i];
            Point2D.Double p2 = points[(i + 1) % n];

            if (p1.x <= xLine) leftPolygon.add(p1);
            if ((p1.x < xLine && p2.x > xLine) || (p1.x > xLine && p2.x < xLine)) {
                double t = (xLine - p1.x) / (p2.x - p1.x);
                double y = p1.y + t * (p2.y - p1.y);
                leftPolygon.add(new Point2D.Double(xLine, y));
            }
        }

        return polygonArea(leftPolygon.toArray(new Point2D.Double[0]));
    }
}

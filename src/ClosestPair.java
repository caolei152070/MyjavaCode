import java.util.*;

// Point 放在 ClosestPair 外面，不要写到 ClosestPair {} 里面
class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

public class ClosestPair {

    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Object[] bruteForce(Point[] points, int l, int r) {
        double minDist = Double.MAX_VALUE;
        Point pA = null, pB = null;

        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                double d = distance(points[i], points[j]);
                if (d < minDist) {
                    minDist = d;
                    pA = points[i];
                    pB = points[j];
                }
            }
        }
        return new Object[]{minDist, pA, pB};
    }

    public static Object[] stripClosest(List<Point> strip, double d) {
        double minDist = d;
        Point pA = null, pB = null;
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() &&
                    (strip.get(j).y - strip.get(i).y) < minDist &&
                    j <= i + 6; j++) {
                double dist = distance(strip.get(i), strip.get(j));
                if (dist < minDist) {
                    minDist = dist;
                    pA = strip.get(i);
                    pB = strip.get(j);
                }
            }
        }
        return new Object[]{minDist, pA, pB};
    }

    public static Object[] divide(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }
        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        Object[] leftRes = divide(points, left, mid);
        double dLeft = (double) leftRes[0];
        Point pL1 = (Point) leftRes[1];
        Point pL2 = (Point) leftRes[2];

        Object[] rightRes = divide(points, mid + 1, right);
        double dRight = (double) rightRes[0];
        Point pR1 = (Point) rightRes[1];
        Point pR2 = (Point) rightRes[2];

        double dMin;
        Point pa, pb;
        if (dLeft < dRight) {
            dMin = dLeft;
            pa = pL1;
            pb = pL2;
        } else {
            dMin = dRight;
            pa = pR1;
            pb = pR2;
        }

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < dMin) {
                strip.add(points[i]);
            }
        }

        Object[] stripRes = stripClosest(strip, dMin);
        double dStrip = (double) stripRes[0];
        Point ps1 = (Point) stripRes[1];
        Point ps2 = (Point) stripRes[2];

        if (dStrip < dMin) {
            return new Object[]{dStrip, ps1, ps2};
        } else {
            return new Object[]{dMin, pa, pb};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n(n>=100): ");
        int n = sc.nextInt();
        if (n < 100) {
            System.out.println("n必须大于等于100");
            sc.close();
            return;
        }

        Random rand = new Random();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble() * 100;
            double y = rand.nextDouble() * 100;
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        Object[] result = divide(points, 0, n - 1);

        double minDistance = (double) result[0];
        Point point1 = (Point) result[1];
        Point point2 = (Point) result[2];

        System.out.println("==== 结果 ====");
        System.out.printf("最小距离 = %.4f%n", minDistance);
        System.out.println("距离最小的两个点坐标：");
        System.out.println("点1：" + point1);
        System.out.println("点2：" + point2);
        sc.close();
    }
}
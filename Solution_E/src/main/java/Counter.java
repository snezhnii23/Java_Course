import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Counter {

    public String count(double a, double b, double c) {
        if (a == 0) {
            double x1 = -c / b;
            return String.format("x = %f" + '\n', x1);
        }

        double d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));

        if (d > 0) {
            double x1 = (-b + sqrt_val) / (2 * a);
            double x2 = (-b - sqrt_val) / (2 * a);
            return String.format("x1 = %f, x2 = %f" + '\n', x1, x2);
        } else if (d == 0) {
            double x1 = -(double) b / (2 * a);
            return String.format("x = %f" + '\n', x1);
        } else {
            return "D<0 no real roots" + '\n';
        }
    }
}
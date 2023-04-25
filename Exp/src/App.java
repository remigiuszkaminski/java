import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class App {

    public static double factorial(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double power(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }


    public static double taylor_exp(double x, int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            double numerator = power(x, i);
            double denominator = factorial(i);

            result += numerator / denominator;
        }
        return result;
    }

    public static double taylor_exp_end(double x, int n) {
        double result = 0;
        for (int i = n; i >= 0; i--) {
            double numerator = power(x, i);
            double denominator = factorial(i);

            result += numerator / denominator;
        }
        return result;
    }

    public static double taylor_exp_prev(double x, int n) {
        double result = 1;
        double previous = 1;

        for (int i = 1; i <= n; i++) {
            double term = previous * x / i;
            previous = term;
            result += previous;
        }
        return result;
    }

    public static double taylor_exp_prev_end(double x, int n) {
        double previous = power(x, n) / factorial(n);
        double result = previous;

        for (int i = n; i >= 0; i--) {
            double term = previous * i / x;
            result += term;
            previous = term;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("exp_function.csv");
        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 4 * Math.PI / 1_000_000) {
            double builtInExp = Math.exp(x);

            double taylorExp1 = taylor_exp(x, 20);

            double taylorExp2 = taylor_exp_end(x, 20);

            double taylorExp3 = taylor_exp_prev(x, 20);

            double taylorExp4 = taylor_exp_prev_end(x, 20);

            fw.write(String.format(Locale.US, "%.2f;%.15f;%.15f;%.15f;%.15f;%.15f%n", x, builtInExp, taylorExp1,
                    taylorExp2, taylorExp3, taylorExp4));
        }
        fw.close();

        //sprawdzenie hipotezy 2
        double err = Math.exp(Math.PI) - taylor_exp(Math.PI, 20);
        double err2 = Math.exp(Math.PI * 2) - taylor_exp(Math.PI * 2, 20);
        System.out.println(err);
        System.out.println(err2);

        //sprawdzenie pytania 1
        FileWriter fw2 = new FileWriter("exp_function_dokl.csv");
        for (int i = 0; i <= 20; i += 1) {
            double error = Math.exp(Math.PI) - taylor_exp(Math.PI, i);

            fw2.write(String.format(Locale.US, "%d;%.15f%n", i, error));
        }
        fw2.close();
    }
}
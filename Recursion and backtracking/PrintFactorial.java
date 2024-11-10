import java.util.*;

public class printFactorial {

  static int calculateFactorial(int n) {

    if (n == 0) {
      return 1;
    }

    int val = calculateFactorial(n - 1);
    int factorial = n * val;

    return factorial;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(calculateFactorial(n));

    sc.close();
  }
}

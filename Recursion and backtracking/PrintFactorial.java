import java.util.*;

public class printFactorial {

 METHOD 1
  
 /* static int calculateFactorial(int n) {

    if (n == 0) {
      return 1;
    }

    int val = calculateFactorial(n - 1);
    int factorial = n * val;

    return factorial;
  } */

  METHOD 2
  X^n = x^(n/2) * x^(n/2)
   /* static int calculateFactorial(int n) {

    if (n == 0) {
      return 1;
    }

    int multi = power(m, n/2);
    int m = multi * multi;

    //WHEN N IS ODD
    if(n % 2 == 1){
        m = m * x;
        }
   return multi;
  } */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(calculateFactorial(n));

    sc.close();
  }
}

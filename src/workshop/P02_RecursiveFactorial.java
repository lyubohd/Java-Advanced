package workshop;

import java.util.Scanner;

public class P02_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(factorial(n));
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        long currentFactorial = factorial(n - 1);
        return n * currentFactorial;
    }
}

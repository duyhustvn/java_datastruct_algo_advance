public class Fibonacci {
    public int getFibonacci(int n) {
        int[] fibonacciSeries = new int[n];
        if (n == 1 || n == 2) {
            return 1;
        } else if (n >= 3) {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] fibonacciSeries = new int[4];
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < fibonacciSeries.length; i++) {
            fibonacciSeries[i] = fibonacci.getFibonacci(i);
        }

        for (int i = 0; i < fibonacciSeries.length; i++) {
            System.out.print(fibonacciSeries[i] + " ");
        }
    }
}
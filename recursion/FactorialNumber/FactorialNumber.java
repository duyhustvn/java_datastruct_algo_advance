public class FactorialNumber {
    public int factory(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return n;
        }
        if (n > 1) {
            return n * factory(n-1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FactorialNumber factorialNumber = new FactorialNumber();
        int n = factorialNumber.factory(3);
        System.out.println(n);
    }
}
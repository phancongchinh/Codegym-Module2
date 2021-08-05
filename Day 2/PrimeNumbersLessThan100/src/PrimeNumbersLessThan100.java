public class PrimeNumbersLessThan100 {
    public static void main(String[] args) {
        int count = 1;
        for(int i = 0; i < 100; i++){
            if (isPrime(i)) {
                System.out.println("Prime " + count + ": " + i);
                count++;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num) ; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

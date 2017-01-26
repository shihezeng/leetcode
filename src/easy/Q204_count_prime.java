package easy;

//https://leetcode.com/problems/count-primes/
public class Q204_count_prime {
    public static int countPrimes(int n) {
        if (n <= 2) return 0;
        int result = 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i)) {
                result++;
            }
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i < n / 2; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) count++;
        }
        return count;
    }

    public static int countPrimes3(int n) {
        if (n < 3) return 0;
        boolean[] f = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            // already decremented
            if (f[i]) continue;

            // i*i is composite number
            // i*i + i is also composite number
            // the reason we skip i*i + i because it's even already
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(countPrimes(4));
        // System.out.println(countPrimes(19));
        // System.out.println(countPrimes(25));
        // System.out.println(countPrimes(276));
        // System.out.println(countPrimes3(4));
        // System.out.println(countPrimes3(19));
        // System.out.println(countPrimes3(25));
        System.out.println(countPrimes3(20));
    }

}

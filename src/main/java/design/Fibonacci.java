package design;

public class Fibonacci {

    int fibo(int n) {
        if(n < 0) return -1;
        else if (n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

    int fiboRec(int n) {

        if(n < 0) return -1;
        if(n == 0) return 0;
        if(n == 1 ) return 1;

        int a = 1, b = 0;
        int sum = 1;

        for (int i = 1; i < n; i++) {
            a = b;
            b = sum;
            sum = a + b;
            //a = 5;b
            //b = 8;sum
            //sum = a + b;
        }
        return sum;

    }
}

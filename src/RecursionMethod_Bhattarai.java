import java.util.Iterator;
import java.util.Stack;

public class RecursionMethod_Bhattarai {
    public static int factorial(int n){
        int result = 1;
        Stack<Integer> multiplicants = new Stack<Integer>();

        while (n > 0){
            multiplicants.push(n);
            n=n-1;
        }

        for (Integer val:multiplicants){
            result=result*val;
        }

        return result;
    }

    public static int powerNumber(int a, int n){
        while (n > 0){
            a = a * a;
            n=n-1;
        }
        return a;
    }

    public static int sum(int n){
        int result = 0;
        while (n > 0){
            result=result+n;
            n--;
        }
        return result;
    }

    public static int sumMN(int m,int n){
        int result = 0;
        int counter = 0;

        while(n>0){
            result = result +  m + counter;
            n--;
            counter++;
        }
        return result;
    }

    public static int fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int gcd(int a, int b){
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}

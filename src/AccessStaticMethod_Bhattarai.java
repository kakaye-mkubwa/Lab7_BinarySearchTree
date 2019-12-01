import java.util.Scanner;

public class AccessStaticMethod_Bhattarai {

    private static int counter = 1;
    public static void main(String[] args){
        if (counter > 0){
            displayMainMenu();
        }
    }

    public static void displayMainMenu(){
        String menu = "\tAccessStaticMethod_Bhattarai.java\n" +
                "1. n! (Factorial of an integer n)\n" +
                "2. a^n(a power n)\n" +
                "3. Sum(n)\n" +
                "4. Sum(m,n)\n" +
                "5. Fibonnacci sequence Fn\n" +
                "6. GCD (The greatest common divisor of m and n\n" +
                "0. Exit\n";
        System.out.println(menu);

        Scanner menuScanner = new Scanner(System.in);
        switch (menuScanner.nextInt()){
            case 1:
                factorial();
                break;
            case 2:
                powerOfNumber();
                break;
            case 3:
                sumSingleParam();
                break;
            case 4:
                sumDoubleParam();
                break;
            case 5:
                fibonacciSequence();
                break;
            case 6:
                gcd();
                break;
            case 0:
                exit();
        }
    }

    /**
     * Perform exit call
     */
    private static void exit() {
        counter = 0;
        System.exit(0);
    }

    private static void gcd() {
        int num1,num2;
        Scanner gcdScanner  = new Scanner(System.in);
        System.out.print("Please enter numbers(2) to find their gcd\n Number 1: ");
        num1 = gcdScanner.nextInt();
        System.out.print("Number 2: ");
        num2=gcdScanner.nextInt();

        System.out.println("The GCD of "+num1+" and "+ num2 + " is "+RecursionMethod_Bhattarai.gcd(num1,num2));
    }

    private static void fibonacciSequence() {
        Scanner fibonacciScanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = fibonacciScanner.nextInt();
        System.out.println("Fibonacci sequence of "+num+" is "+ RecursionMethod_Bhattarai.fibonacci(num));
    }

    private static void sumDoubleParam() {
        int num1,num2;
        Scanner sumScanner = new Scanner(System.in);
        System.out.println("Enter numbers to find their sum\n Number 1: ");
        num1 = sumScanner.nextInt();
        System.out.println("Number 2: ");
        num2 = sumScanner.nextInt();

        System.out.println("Result: "+RecursionMethod_Bhattarai.sumMN(num1,num2));
    }

    private static void sumSingleParam() {
        int n;
        Scanner sumScanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        n = sumScanner.nextInt();

        System.out.println("Result : "+ RecursionMethod_Bhattarai.sum(n));
    }

    private static void powerOfNumber() {
        int number,power;
        Scanner powerScanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        number = powerScanner.nextInt();
        System.out.print("Enter power: ");
        power = powerScanner.nextInt();

        System.out.println("The value of "+number+" raised to power "+power+" is "+RecursionMethod_Bhattarai.powerNumber(number,power));
    }

    private static void factorial() {
        Scanner factorialScanner = new Scanner(System.in);
        System.out.println("Enter number to calculate its factorial: ");
        int num = factorialScanner.nextInt();
        System.out.print("The factorial of "+num+" is "+RecursionMethod_Bhattarai.factorial(num));
    }

}

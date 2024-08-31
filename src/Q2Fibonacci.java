import java.util.Scanner;

public class Q2Fibonacci {

    public boolean CalcFibonnaci(int n) {
        int a = 0;
        int b = 1;
        int c;

        while (true) {
            if (a == n) {
                return true;
            } else if (a > n) {
                return false;
            }
            c = a + b;
            a = b;
            b = c;
        }
    }

    public void getResults() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro para checar se faz parte da sequência Fibonacci: ");
        int n = scanner.nextInt();
        if (CalcFibonnaci(n)) {
            System.out.println(n + " faz parte da sequência de Fibonacci");
        } else {
            System.out.println(n + " não faz parte da sequência de Fibonacci");
        }
    }

}

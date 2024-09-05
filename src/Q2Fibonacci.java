import java.util.Scanner;

public class Q2Fibonacci implements Questao {
    private int n;
    private final Scanner scanner;
    private boolean isFibonacci;
    private boolean readDataCalled;
    private boolean processResultsCalled;


    public Q2Fibonacci() {
        this.n = 0;
        scanner = new Scanner(System.in);
        isFibonacci = false;
        readDataCalled = false;
        processResultsCalled = false;
    }

    @Override
    public void processResults() {

        if (!readDataCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        processResultsCalled = true;
        int a = 0;
        int b = 1;
        int c;

        boolean fibonacciFound = false;
        boolean numberGreaterThanN = false;

        while (!fibonacciFound && !numberGreaterThanN) {
            if (a == n) {
                isFibonacci = true;
                fibonacciFound = true;
            } else if (a > n) {
                isFibonacci = false;
                numberGreaterThanN = true;
            }
            c = a + b;
            a = b;
            b = c;
        }
    }

    @Override
    public void readData() {

        System.out.println("Digite um número inteiro para checar se faz parte da sequência Fibonacci: ");
        n = scanner.nextInt();
        readDataCalled = true;

    }

    @Override
    public String getResults() {
        if (!readDataCalled || !processResultsCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        return isFibonacci ? "O número " + n + " faz parte da sequência Fibonacci" : "O número " + n + " não faz parte da sequência Fibonacci";
    }

}

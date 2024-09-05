import java.util.Scanner;

public class Q5Inverter implements Questao {
    private String inputString;
    private String reversedString;
    private boolean readDataCalled;
    private boolean processResultsCalled;

    private final Scanner scanner;

    public Q5Inverter() {
        this.inputString = "";
        this.reversedString = "";
        this.readDataCalled = false;
        this.processResultsCalled = false;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void readData() {
        System.out.println("Digite uma palavra para inverter: ");
        inputString = scanner.nextLine();
        readDataCalled = true;
    }

    @Override
    public void processResults() {
        if (!readDataCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        processResultsCalled = true;
        reversedString = inverterString(inputString);
    }

    @Override
    public String getResults() {
        if (!readDataCalled || !processResultsCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        return "Palavra invertida: " + reversedString;
    }

    private String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int esquerda = 0;
        int direita = caracteres.length - 1;

        while (esquerda < direita) {
            char temp = caracteres[esquerda];
            caracteres[esquerda] = caracteres[direita];
            caracteres[direita] = temp;
            esquerda++;
            direita--;
        }

        return new String(caracteres);
    }
}

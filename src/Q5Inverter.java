import java.util.Scanner;

public class Q5Inverter {
    public String inverterString(String str) {
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

    public void getResults() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra para inverter: ");
        String word = scanner.nextLine();
        System.out.println("Palavra invertida: " + inverterString(word));
    }
}

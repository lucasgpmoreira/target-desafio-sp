import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Q2Fibonacci fibonacci = new Q2Fibonacci();
        Q3FaturamentoFuncoes faturamentoFuncoes = new Q3FaturamentoFuncoes();
        Q4FaturamentoMensal faturamento = new Q4FaturamentoMensal();
        Q5Inverter inverter = new Q5Inverter();

        while (true) {
            System.out.println("--------------------");
            System.out.println("Olá equipe target, digite qual o número referente a questão que deseja executar: ");
            System.out.println("2 - Fibonacci");
            System.out.println("3 - Faturamento Funções");
            System.out.println("4 - Faturamento Mensal");
            System.out.println("5 - Inverter String");

            int option = scanner.nextInt();

            switch (option) {
                case 2:
                    fibonacci.readData();
                    fibonacci.processResults();
                    System.out.println(fibonacci.getResults());
                    break;
                case 3:
                    faturamentoFuncoes.readData();
                    faturamentoFuncoes.processResults();
                    System.out.println(faturamentoFuncoes.getResults());
                    break;
                case 4:
                    faturamento.readData();
                    faturamento.processResults();
                    System.out.println(faturamento.getResults());
                    break;
                case 5:
                    inverter.readData();
                    inverter.processResults();
                    System.out.println(inverter.getResults());
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }
    }
}
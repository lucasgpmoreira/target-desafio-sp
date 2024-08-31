public class Q3FaturamentoFuncoes {

    private static final int[] FATURAMENTO = {1400, 1800, 1550, 1700, 2100, 1650, 1850,
            1500, 1400, 1600, 2000, 1750, 1650, 1800,
            1900, 2100, 2200, 1800, 2000, 1900, 1750};

    public int calcularMenorValor(int[] faturamento) {
        int menor = faturamento[0];
        for (int valor : faturamento) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    public int calcularMaiorValor(int[] faturamento) {
        int maior = faturamento[0];
        for (int valor : faturamento) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public int contarDiasAcimaDaMedia(int[] faturamento) {
        int soma = 0;
        for (int valor : faturamento) {
            soma += valor;
        }
        int media = soma / faturamento.length;

        int count = 0;
        for (int valor : faturamento) {
            if (valor > media) {
                count++;
            }
        }
        return count;
    }

    public void getResults() {
        int menorValor = calcularMenorValor(FATURAMENTO);
        int maiorValor = calcularMaiorValor(FATURAMENTO);
        int diasAcimaDaMedia = contarDiasAcimaDaMedia(FATURAMENTO);

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Q4FaturamentoMensal {

    private Map<String, Double> faturamentoPorEstado;

    public Q4FaturamentoMensal() {
        faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);
    }

    public double calcularTotalFaturamento() {
        double total = 0;
        for (double valor : faturamentoPorEstado.values()) {
            total += valor;
        }
        return total;
    }

    public void getResults() {
        double totalFaturamento = calcularTotalFaturamento();
        System.out.println("Total de Faturamento: R$" + (totalFaturamento + "").replace(".", ","));

        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double porcentagem = (faturamento / totalFaturamento) * 100;
            System.out.println("Estado: " + estado);
            System.out.println("Faturamento: R$" + (faturamento + "").replace(".", ","));
            System.out.println("Porcentagem do Total: " + ((int) porcentagem) + "," + ((int) ((porcentagem - (int) porcentagem) * 100)) + "%");
            System.out.println();
        }
    }
}

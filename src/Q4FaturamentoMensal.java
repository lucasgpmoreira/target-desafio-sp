import java.util.HashMap;
import java.util.Map;

public class Q4FaturamentoMensal implements Questao {

    private Map<String, Double> faturamentoPorEstado;
    private double totalFaturamento;
    private boolean readDataCalled;
    private boolean processResultsCalled;

    public Q4FaturamentoMensal() {
        this.faturamentoPorEstado = new HashMap<>();
        this.totalFaturamento = 0;
        this.readDataCalled = false;
        this.processResultsCalled = false;
    }

    @Override
    public void readData() {
        faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);
        totalFaturamento = 0;
        readDataCalled = true;

    }

    @Override
    public void processResults() {
        if (!readDataCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        this.totalFaturamento = calcularTotalFaturamento();
        processResultsCalled = true;
    }

    @Override
    public String getResults() {
        if (!readDataCalled || !processResultsCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }

        StringBuilder results = new StringBuilder();
        results.append("Total de Faturamento: R$")
                .append(String.format("%.2f", totalFaturamento).replace(".", ","))
                .append("\n");

        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double porcentagem = (faturamento / totalFaturamento) * 100;
            results.append("Estado: ").append(estado).append("\n")
                    .append("Faturamento: R$")
                    .append(String.format("%.2f", faturamento).replace(".", ","))
                    .append("\n")
                    .append("Porcentagem do Total: ")
                    .append(String.format("%d,%02d%%", (int) porcentagem, (int) ((porcentagem - (int) porcentagem) * 100)))
                    .append("\n\n");
        }
        return results.toString();
    }


    private double calcularTotalFaturamento() {
        double total = 0;
        for (double valor : faturamentoPorEstado.values()) {
            total += valor;
        }
        return total;
    }
}

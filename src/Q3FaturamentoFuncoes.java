import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q3FaturamentoFuncoes implements Questao {
    private ArrayList<JSONObject> lista;
    private int menorValor;
    private int maiorValor;
    private int diasAcimaDaMedia;
    private boolean readDataCalled;
    private boolean processResultsCalled;

    public Q3FaturamentoFuncoes() {
        this.lista = new ArrayList<>();
        this.menorValor = 0;
        this.maiorValor = 0;
        this.diasAcimaDaMedia = 0;
        this.readDataCalled = false;
        this.processResultsCalled = false;
    }

    @Override
    public void readData() {
        System.out.println("Lendo dados do arquivo JSON...");
        readDataCalled = true;

        try {
            JSONObject json = new JSONObject(new JSONTokener(new FileReader("src/dados.json")));
            JSONArray jsonArray = json.getJSONArray("dados");
            for (int i = 0; i < jsonArray.length(); i++) {
                lista.add(jsonArray.getJSONObject(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void processResults() {
        if (!readDataCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }
        processResultsCalled = true;
        this.menorValor = calcularMenorValor(lista);
        this.maiorValor = calcularMaiorValor(lista);
        this.diasAcimaDaMedia = contarDiasAcimaDaMedia(lista);
    }

    @Override
    public String getResults() {
        if (!readDataCalled || !processResultsCalled) {
            throw new IllegalStateException("all methods must be called in order (readData, processResults, getResults)");
        }

        return "Menor valor: " + menorValor + "\n" +
                "Maior valor: " + maiorValor + "\n" +
                "Dias acima da média: " + diasAcimaDaMedia;
    }

    private int calcularMenorValor(ArrayList<JSONObject> lista) {
        int menor = lista.get(0).getInt("valor");
        for (JSONObject jsonObject : lista) {
            if (jsonObject.getInt("valor") < menor) {
                menor = jsonObject.getInt("valor");
            }
        }
        return menor;
    }

    private int calcularMaiorValor(ArrayList<JSONObject> lista) {
        int maior = lista.get(0).getInt("valor");
        for (JSONObject jsonObject : lista) {
            if (jsonObject.getInt("valor") > maior) {
                maior = jsonObject.getInt("valor");
            }
        }
        return maior;
    }

    private int contarDiasAcimaDaMedia(ArrayList<JSONObject> lista) {
        int soma = 0;
        for (JSONObject jsonObject : lista) {
            soma += jsonObject.getInt("valor");
        }
        int media = soma / lista.size();
        int diasAcimaDaMedia = 0;
        for (JSONObject jsonObject : lista) {
            if (jsonObject.getInt("valor") > media) {
                diasAcimaDaMedia++;
            }
        }
        return diasAcimaDaMedia;
    }
}

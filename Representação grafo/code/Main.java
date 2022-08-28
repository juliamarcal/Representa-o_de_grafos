import java.io.*;

public class Main {
    public static void main(String[] args) {
        String nomeArq = "../arq/";
        String numV = "";

        MyIO.print("\nDigite o nome do arquivo que deve ser lido: ");
        nomeArq += MyIO.readLine();

        MyIO.print("\nDigite o nome de um vertice qualquer: ");
        numV = MyIO.readLine();

        MyIO.println("\n==============================================================\n");

        Grafo g = new Grafo( "../arq/"+nomeArq );

        g.findGrauEntrada(numV);
        g.findGrauSaida(numV);
        g.findPredecessores(numV);
        g.findSucessores(numV);

    }
}


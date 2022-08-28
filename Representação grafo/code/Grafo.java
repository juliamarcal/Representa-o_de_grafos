public class Grafo {

    ListaSucessores listaSucessores;
    ListaPredecessores listaPredecessores;

    Grafo(String NomeArq) {
        Arq.openRead(NomeArq);
        String line = Arq.readLine(); // leitura da primeira linha do arquivo
        String[] params = line.split(" ");

        int numVertices = Integer.parseInt(params[0]);
        int numArestas = Integer.parseInt(params[params.length-1]);
        
        listaSucessores = new ListaSucessores(numVertices);
        listaPredecessores = new ListaPredecessores(numVertices);

        String vSaida = "";
        String vEntrada = "";
        for (int i=0; i<numArestas; i++) {
            line = Arq.readLine();
            line = line.trim();

            params = line.split(" ");

            vSaida = params[0];
            vEntrada = params[params.length-1];
            
            listaSucessores.addElemento(vSaida, vEntrada);
            listaPredecessores.addElemento(vEntrada, vSaida);
        }

        Arq.close();
    }

    public void findGrauEntrada(String v) {
        MyIO.println( " - Grau de entrada = " + listaPredecessores.countGrauEntrada(v) + "\n" );
    }

    public void findGrauSaida(String v) {
        MyIO.println( " - Grau de saida = " + listaSucessores.countGrauSaida(v) + "\n" );
    }

    public void findSucessores(String v) {
        MyIO.println( " - Conjunto de sucessores = " + listaSucessores.getSucessores(v) + "\n" );
    }

    public void findPredecessores(String v) {
        MyIO.println( " - Conjunto de predecessores = " + listaPredecessores.getPredecessores(v) + "\n" );
    }

    public void printGrafo() {
        MyIO.println("sucessores:");
        listaSucessores.printLista();

        MyIO.println("\n\npredecessores:");
        listaPredecessores.printLista();
    }

}


public class ListaSucessores {
    Cell[] verticesBase;
    int quantElementosBaseInseridos;

    ListaSucessores(int quantElBase){
        verticesBase = new Cell[quantElBase];
        quantElementosBaseInseridos = 0;
    }

    public void addElemento ( String vBase, String vProx ) {
        vBase.trim();
        int posBase = findPosVBase(vBase);

        if ( posBase == -1 ) {
            verticesBase[quantElementosBaseInseridos] = new Cell(vBase);
            posBase = quantElementosBaseInseridos;
            quantElementosBaseInseridos++;
        }
 
        Cell aux = verticesBase[posBase];
        while(aux.prox != null) {
            aux = aux.prox;
        }
        aux.prox = new Cell(vProx);
    }

    public int findPosVBase ( String v ) {
        for ( int i=0; i < quantElementosBaseInseridos; i++ ) {
            if ( verticesBase[i].v.equals(v) ) {
                return i;
            }
        }
        return -1; // vertice procurado nao se encontra no vetor
    }

    public void printLista() {
        for (int i=0; i<quantElementosBaseInseridos; i++) {
            Cell aux = verticesBase[i];
            do {
                MyIO.print(aux.v);
                MyIO.print(" -> ");
                
                aux = aux.prox; 
                
            } while(aux.prox != null);
            MyIO.print(aux.v);
            MyIO.print(" -> ");
            MyIO.print("...\n");
        }
    }

    public int countGrauSaida (String v) {
        int contGrau = 0;

        if (findPosVBase(v) == -1) {
            return contGrau;
        }
         
        Cell aux = verticesBase[findPosVBase(v)];
        do {
            contGrau++;
            aux = aux.prox;
        } while(aux.prox != null);

        return contGrau;

        
    }

    public String getSucessores(String v) {

        if (findPosVBase(v) != -1) {
            Cell aux = verticesBase[findPosVBase(v)];
            aux = aux.prox; 
            String sucessores = "";
            sucessores +="{ ";
            do {
                sucessores += aux.v;
                sucessores += ", ";
                
                aux = aux.prox; 
                
            } while(aux.prox != null);
            sucessores += aux.v;
            sucessores +=" }";

            return sucessores;
        } else {
            return "vertice nao apresenta sucessores";
        }

        
        
    }

}

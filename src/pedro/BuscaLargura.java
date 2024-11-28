package pedro;

import pedro.Objects.Aresta;
import pedro.Objects.Vertice;
import java.util.ArrayList;

public class BuscaLargura {
    static ArrayList<Vertice> lista1 = new ArrayList<>();
    static ArrayList<Vertice> lista2 = new ArrayList<>();

    public static int buscar(Vertice de, Vertice para) {
        lista1.add(de);
        ArrayList<Vertice> listaAtual = lista1;
        ArrayList<Vertice> listaProx = lista2;
        int dist = -1;

        while(true){
            for(Vertice v: listaAtual){
                if(v == para){
                    return dist + 1;
                }
                for(Aresta a: v.saindo){
                    listaProx.add(a.para);
                }
            }
            listaAtual.clear();
            ArrayList<Vertice> holder = listaAtual;
            listaAtual = listaProx;
            listaProx = holder;

            dist++;
        }
    }
}

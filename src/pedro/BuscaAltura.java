package pedro;

import pedro.Objects.Aresta;
import pedro.Objects.Vertice;
import pedro.View.GraphView;

import java.awt.*;
import java.util.ArrayList;

public class BuscaAltura {
    private static boolean found = false;

    public static int buscar(Vertice de, Vertice para, GraphView panel) throws InterruptedException {
        return buscaRecursiva(new Aresta[]{}, de, para, 0, panel);
    }

    private static int buscaRecursiva(Aresta[] arestas, Vertice de, Vertice para, int cont, GraphView panel) throws InterruptedException {
        if(found){
            return 0;
        }
        if(cont > 0){
            Thread.sleep(1000);
            panel.highlightAresta(de.chegando.getFirst(), Color.blue);
        }
        if(de == para){
            found = true;
            panel.highlightVertice(para, Color.GREEN);
            return cont;
        }
        int[] responses = new int[de.saindo.size()];
        for(int i = 0; i < de.saindo.size(); i++){
            Aresta a = de.saindo.get(i);
            responses[i] = buscaRecursiva(arestas, a.para, para, cont + 1, panel);
        }
        return handler(responses);
    }

    private static int handler(int [] responses){
        if(responses.length == 0){
            return 0;
        }

        int biggest = 0;
        for (int respons : responses) {
            if (respons > biggest) {
                biggest = respons;
            }
        }
        return biggest;
    }
}

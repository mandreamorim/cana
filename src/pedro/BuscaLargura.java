package pedro;

import pedro.Objects.Aresta;
import pedro.Objects.Vertice;
import pedro.View.GraphView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuscaLargura {
    static ArrayList<Vertice> lista1 = new ArrayList<>();
    static ArrayList<Vertice> lista2 = new ArrayList<>();

    public static int buscar(Vertice de, Vertice para, GraphView panel) throws InterruptedException {
        lista1.add(de);
        ArrayList<Vertice> listaAtual = lista1;
        ArrayList<Vertice> listaProx = lista2;
        int dist = -1;

        while(true){
            for(Vertice v: listaAtual){
                Thread.sleep(1000);
                if(v == para){
                    panel.highlightVertice(v, Color.GREEN);
                    panel.highlightAresta(v.chegando.getFirst(), Color.blue);
                    return dist + 1;
                }
                if(dist > -1){
                    for(Aresta a: traceBack(v, de)){
                        panel.highlightAresta(a, Color.blue);
                    }
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

    public static ArrayList<Aresta> traceBack(Vertice v, Vertice raiz){
        ArrayList<Aresta> caminho = new ArrayList<>();
        Vertice vertice = v;
        while(true){
            if(vertice == raiz){
                return caminho;
            }
            Aresta a = vertice.chegando.getFirst();
            caminho.add(a);
            vertice = a.de;
        }
    }
}

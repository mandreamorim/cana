package pedro.Objects;

import java.util.ArrayList;

public class Vertice {
    public String nome;
    public int[] pos;
    public ArrayList<Aresta> saindo;
    public ArrayList<Aresta> chegando;

    public Vertice(String nome) {
        this.nome = nome;
        saindo = new ArrayList<>();
        chegando = new ArrayList<>();
    }

    public Vertice(String nome, int[] pos) {
        this.nome = nome;
        this.pos = pos;
        saindo = new ArrayList<>();
        chegando = new ArrayList<>();
    }
    public static void createLink(Vertice p, Vertice q, ArrayList<Aresta> lista){
        Aresta a = new Aresta(p, q);
        p.saindo.add(a);
        q.chegando.add(a);
        lista.add(a);
    }

    public static void createLink(Vertice p, Vertice q){
        Aresta a = new Aresta(p, q);
        p.saindo.add(a);
        q.chegando.add(a);
    }
}

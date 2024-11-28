package pedro;

import pedro.Objects.Aresta;
import pedro.Objects.Vertice;
import pedro.View.GraphView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Demo extends JPanel{
    static ArrayList<Vertice> vertices = new ArrayList<>();
    static ArrayList<Aresta> arestas = new ArrayList<>();
    static JFrame frame;
    static GraphView panel;

    public static void main(String[] args) throws InterruptedException {
        Vertice marcos = new Vertice("Marcos", new int[]{1, 1});
        Vertice pedro = new Vertice("Pedro", new int[]{5,1});
        Vertice enrico = new Vertice("Enrico", new int[]{3,4});
        Vertice mael = new Vertice("Mael", new int[]{3,1});
        Vertice kauan = new Vertice("Kauan", new int[]{3,6});
        Vertice ronaldo = new Vertice("Ronaldo", new int[]{3,8});
        Vertice samuel = new Vertice("Samuel", new int[]{5, 7});
        Vertice hahaha = new Vertice("Hahaha da Silva", new int[]{5,9});
        Vertice bereats = new Vertice("Bereats", new int[]{7,4});
        Vertice superr = new Vertice("Super", new int[]{5,4});
        Vertice pompeu = new Vertice("Pompeu", new int[]{7,9});
        Vertice rammus = new Vertice("Rammus", new int[]{7,1});
        Vertice professor = new Vertice("Professor", new int[]{9,9});

        vertices.add(marcos);
        vertices.add(pedro);
        vertices.add(enrico);
        vertices.add(mael);
        vertices.add(kauan);
        vertices.add(ronaldo);
        vertices.add(samuel);
        vertices.add(hahaha);
        vertices.add(bereats);
        vertices.add(superr);
        vertices.add(rammus);
        vertices.add(pompeu);
        vertices.add(professor);

        Vertice.createLink(marcos, mael, arestas);
        Vertice.createLink(marcos, enrico, arestas);
        Vertice.createLink(marcos, kauan, arestas);
        Vertice.createLink(marcos, ronaldo, arestas);
        Vertice.createLink(mael, pedro, arestas);
        Vertice.createLink(ronaldo, samuel, arestas);
        Vertice.createLink(ronaldo, hahaha, arestas);
        Vertice.createLink(samuel, bereats, arestas);
        Vertice.createLink(kauan, superr, arestas);
        Vertice.createLink(hahaha, pompeu, arestas);
        Vertice.createLink(pedro, rammus, arestas);
        Vertice.createLink(pompeu, professor, arestas);


        frame = new JFrame("Graph Visualization");
        panel = new GraphView(vertices, arestas);
        frame.add(panel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
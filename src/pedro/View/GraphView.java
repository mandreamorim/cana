package pedro.View;

import pedro.Objects.Aresta;
import pedro.Objects.Vertice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphView extends JPanel {
    private final ArrayList<Vertice> vertices;
    private final ArrayList<Aresta> arestas;
    private final Map<Aresta, Color> edgeColor = new HashMap<>();
    private final Map<Vertice, Color> vertexColors = new HashMap<>();

    public GraphView(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());


        for (Aresta aresta : arestas) {
            Color color = edgeColor.getOrDefault(aresta, Color.darkGray);
            g2.setColor(color);
            int[] start = scaleCoordinates(aresta.de.pos[0], aresta.de.pos[1]);
            int[] end = scaleCoordinates(aresta.para.pos[0], aresta.para.pos[1]);
            g2.drawLine(start[0], start[1], end[0], end[1]);
        }


        for (Vertice vertice : vertices) {
            Color color = vertexColors.getOrDefault(vertice, Color.LIGHT_GRAY);
            g2.setColor(color);
            int[] scaledPos = scaleCoordinates(vertice.pos[0], vertice.pos[1]);
            g2.fillOval(scaledPos[0] - 15, scaledPos[1] - 15, 30, 30);

            g2.setColor(Color.ORANGE);
            g2.drawString(vertice.nome, scaledPos[0] - 20, scaledPos[1] + 35);
        }
    }


    public void highlightVertice(Vertice vertice, Color color) {
        vertexColors.put(vertice, color);
        repaint();
    }

    public void highlightAresta(Aresta aresta, Color color) {
        edgeColor.put(aresta, color);
        repaint();
    }


    private int[] scaleCoordinates(int x, int y) {
        int scaledX = (int) (x * (getWidth() - 40) / 10.0 + 20);
        int scaledY = (int) (y * (getHeight() - 40) / 10.0 + 20);
        return new int[]{scaledX, scaledY};
    }

}

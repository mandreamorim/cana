package caxeiroviajante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TspVisualizer extends JPanel {
    private final Map<Character, int[]> cityCoordinates;
    public String path;

    public TspVisualizer(ArrayList<City> cities, String path) {
        this.cityCoordinates = new HashMap<>();
        for (City city : cities) {
            cityCoordinates.put(city.label.charAt(0), city.position);
        }
        this.path = path;
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offset = 50; // Deslocamento para afastar do canto

        g.setColor(Color.BLACK);
        // Desenha as cidades e suas letras
        for (Map.Entry<Character, int[]> entry : cityCoordinates.entrySet()) {
            int[] pos = entry.getValue();
            g.fillOval(pos[0] * 50 + offset, pos[1] * 50 + offset, 10, 10);
            g.drawString(String.valueOf(entry.getKey()), pos[0] * 50 + offset + 5, pos[1] * 50 + offset - 5);
        }

        // Desenha o caminho
        g.setColor(Color.RED);
        try{
            for (int i = 0; i < path.length() - 1; i++) {
                char current = path.charAt(i);
                char next = path.charAt(i + 1);
                int[] posCurrent = cityCoordinates.get(current);
                int[] posNext = cityCoordinates.get(next);
                drawArrowAtMidpoint(g, posCurrent[0] * 50 + offset + 5, posCurrent[1] * 50 + offset + 5,
                        posNext[0] * 50 + offset + 5, posNext[1] * 50 + offset + 5);
            }
        } catch (Exception ignored){}
    }

    public void drawArrow(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha a linha principal
        g2d.drawLine(x1, y1, x2, y2);

        // Calcula o ângulo da linha
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Define o tamanho e a largura da cabeça da seta
        int arrowLength = 10;
        int arrowWidth = 5;

        // Calcula as coordenadas da cabeça da seta
        int xArrow1 = (int) (x2 - arrowLength * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowLength * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowLength * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowLength * Math.sin(angle + Math.PI / 6));

        // Desenha a cabeça da seta
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(x2, y2);
        arrowHead.addPoint(xArrow1, yArrow1);
        arrowHead.addPoint(xArrow2, yArrow2);
        g2d.fillPolygon(arrowHead);
    }

    public void drawArrowAtMidpoint(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha a linha principal
        g2d.drawLine(x1, y1, x2, y2);

        // Calcula o ponto médio
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        // Calcula o ângulo da linha
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Define o tamanho e a largura da cabeça da seta
        int arrowLength = 10;
        int arrowWidth = 5;

        // Calcula as coordenadas da cabeça da seta no ponto médio
        int xArrow1 = (int) (midX - arrowLength * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (midY - arrowLength * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (midX - arrowLength * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (midY - arrowLength * Math.sin(angle + Math.PI / 6));

        // Desenha a cabeça da seta no ponto médio
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(midX, midY);
        arrowHead.addPoint(xArrow1, yArrow1);
        arrowHead.addPoint(xArrow2, yArrow2);
        g2d.fillPolygon(arrowHead);
    }
}
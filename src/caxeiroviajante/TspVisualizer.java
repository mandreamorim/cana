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
                g.drawLine(posCurrent[0] * 50 + offset + 5, posCurrent[1] * 50 + offset + 5,
                        posNext[0] * 50 + offset + 5, posNext[1] * 50 + offset + 5);
            }
        } catch (Exception ignored){}
    }
}
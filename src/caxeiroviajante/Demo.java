package caxeiroviajante;

import pedro.BuscaLargura;
import pedro.Objects.Aresta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

import static caxeiroviajante.CaxeiroViajante.cities;
import static caxeiroviajante.CaxeiroViajante.finalList;

public class Demo {
//    static TspVisualizer visualizer;

    public static void main(String[] args) {
        cities.add(new City("A", new int[]{0, 0}));
        cities.add(new City("B", new int[]{3, 5}));
        cities.add(new City("C", new int[]{6, 2}));
        cities.add(new City("D", new int[]{8, 5}));
        cities.add(new City("E", new int[]{2, 2}));
        cities.add(new City("F", new int[]{1, 4}));
        cities.add(new City("G", new int[]{3, 8}));
        cities.add(new City("H", new int[]{4, 7}));
        cities.add(new City("I", new int[]{0, 9}));
        cities.add(new City("J", new int[]{5, 0}));
//        cities.add(new City("K", new int[]{0, 2}));
//        cities.add(new City("L", new int[]{6, 4}));
//        cities.add(new City("M", new int[]{2, 8}));
//        cities.add(new City("N", new int[]{5, 1}));
//        cities.add(new City("O", new int[]{7, 3}));
//        cities.add(new City("P", new int[]{8, 8}));
//        cities.add(new City("Q", new int[]{3, 1}));

//        CaxeiroViajante.findDistances();
//        for (int i = 0; i < CaxeiroViajante.paths.size(); i ++){
//            System.out.println(CaxeiroViajante.paths.get(i).toString());;
//        }
//        visualizer = new TspVisualizer(cities, "");
//        JFrame frame = new JFrame("TSP Path Visualization");
//        frame.add(visualizer);
//        frame.setSize(600, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        ArrayList<Integer> total = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++){
            total.add(i);
        }

        CaxeiroViajante.permutateCourses("", 0.0, total);

        CaxeiroViajante.finalList.sort(Comparator.comparingDouble(f -> f.distance));
//        updateVis(finalList.getFirst().path, visualizer);

        for (int i = 0; i < 10; i++) {
            System.out.println("Caminho: " + finalList.get(i).path + ", Distância: " + finalList.get(i).distance);
        }
    }

//    public static void updateVis(String path, TspVisualizer vis){
//        vis.path = path;
//        vis.repaint();
//    }
}

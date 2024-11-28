package caxeiroviajante;

import java.util.ArrayList;
import java.util.Collections;

//import static caxeiroviajante.Demo.updateVis;
//import static caxeiroviajante.Demo.visualizer;

public class CaxeiroViajante {
    static public ArrayList<City> cities = new ArrayList<>();
    static public ArrayList<Path> paths = new ArrayList<>();
    static public ArrayList<Final> finalList =  new ArrayList<>();

    private static double calculateDistance(City c1, City c2) {
        int dx = c1.position[0] - c2.position[0];
        int dy = c1.position[1] - c2.position[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void permutateCourses(String path, double distance, int previous ,ArrayList<Integer> remaining){
//        updateVis(path, visualizer);
        if(remaining.isEmpty()){
            finalList.add(new Final(path,distance));
//            addOrdenado(finalList, new Final(path, distance));
            return;
        }
        for(int i = 0; i < remaining.size(); i++){
            String newPath = path + cities.get(remaining.get(i)).label;
            double newDistance = distance + calculateDistance(cities.get(previous), cities.get(remaining.get(i)));
            ArrayList<Integer> newList = (ArrayList<Integer>) remaining.clone();
            int newCityIndex = remaining.get(i);
            newList.remove(i);
            permutateCourses(newPath, newDistance, newCityIndex, newList);
        }
    }

    public static void permutateCourses(String path, double distance, ArrayList<Integer> remaining){
//        updateVis(path, visualizer);
        if(remaining.isEmpty()){
            finalList.add(new Final(path,distance));
//            addOrdenado(finalList, new Final(path, distance));
            return;
        }
        int size = remaining.size();
        for(int i = 0; i < size; i++){
            String newPath = path + cities.get(remaining.get(i)).label;
            int newCityIndex = remaining.get(i);
            ArrayList<Integer> newList = (ArrayList<Integer>) remaining.clone();
            newList.remove(i);
            permutateCourses(newPath, distance, newCityIndex, newList);
        }
    }

//    public static void addOrdenado(ArrayList<Final> lista, Final elemento) {
//        int pos = Collections.binarySearch(lista, elemento);
//
//        // Se não encontrou a posição, binarySearch retorna (-(insertion point) - 1)
//        if (pos < 0) pos = -(pos + 1);
//
//        lista.add(pos, elemento);
//    }
}

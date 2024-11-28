package casadepraia;

import casadepraia.Objects.File;

import java.util.ArrayList;
import java.util.Comparator;

public class Algo {
    public static ArrayList<File> DoTheThing(int capacity) {
        ArrayList<File> result = new ArrayList<>();
        ArrayList<File> files = new ArrayList<>();

        files.add(new File(500, 60));
        files.add(new File(300, 50));
        files.add(new File(123, 28));
        files.add(new File(150, 20));
        files.add(new File(50, 10));
        files.add(new File(10, 8));
        files.add(new File(30, 5));
        files.add(new File(3, 4));
        files.add(new File(1, 1));
        files.sort((f1, f2) -> Double.compare(f2.density, f1.density));

        int current = 0;
        int pointer = 0;
        while (current < capacity) {
            if(!(pointer < files.size())) {
                pointer = 0;
            }
            File file = files.get(pointer);
            if(file.size <= (capacity - current)){
                result.add(file);
                current += file.size;
            } else {
                pointer++;
            }
        }
        return result;
    }
}

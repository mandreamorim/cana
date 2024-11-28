package casadepraia;

import casadepraia.Objects.File;

import java.util.ArrayList;

import static casadepraia.Algo.DoTheThing;

public class Demo {
    public static void main(String[] args) {
        ArrayList<File> files = DoTheThing(200);
        int totalPages = 0;
        int cost = 0;
        for(File file : files) {
            totalPages += file.pages;
            cost += file.size;
        }

        System.out.println("Pages: " + totalPages);
        System.out.println("Cost: " + cost);
    }
}

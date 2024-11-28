package pedro;

import pedro.Objects.Vertice;

public class DemoLargura extends Demo{
    public static void main(String[] args) throws InterruptedException {
        Demo.main(args);

        Vertice marcos = vertices.get(0);
        Vertice pedro = vertices.get(1);
        Vertice enrico = vertices.get(2);
        Vertice mael = vertices.get(3);
        Vertice kauan = vertices.get(4);
        Vertice ronaldo = vertices.get(5);
        Vertice samuel = vertices.get(6);
        Vertice hahaha = vertices.get(7);
        Vertice bereats = vertices.get(8);
        Vertice superr = vertices.get(9);
        Vertice pompeu = vertices.get(10);
        Vertice rammus = vertices.get(11);

        System.out.println("Distância:" + BuscaLargura.buscar(marcos, bereats));

    }
}


;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Planificador {
    static ArrayList listaDeEstructuras;
    static ArrayList listaDeTropas;
    static ArrayList listaDeHeroes;

    public static void main(String[] args) {
        inicializar(args[0],args[1],args[2]);
        System.out.println(((ObjetoMejorable)(listaDeHeroes.get(0))).getCoste(38));
    }

    private static void inicializar(String ficheroEstructuras, String ficheroTropas, String ficheroHeroes){
        listaDeEstructuras = new ArrayList<Estructura>();
        listaDeTropas = new ArrayList<Tropa>();
        listaDeHeroes = new ArrayList<Heroe>();
        for(int o=0;o<3;o++){
            Scanner s = null;
            String entrada = "";
            String [] arr;
            String nombreObjeto = "";
            char tipo = ' ';
            String tipoRecurso = "";
            int[] tiempos;
            int[] costes;
            int niveles;
            String ficheroFuente="";
            ArrayList listaActual = new ArrayList();
            switch (o){
                case 0:
                    ficheroFuente = ficheroEstructuras;
                    listaActual = listaDeEstructuras;
                    break;
                case 1:
                    ficheroFuente = ficheroTropas;
                    listaActual = listaDeTropas;
                    break;
                case 2:
                    ficheroFuente = ficheroHeroes;
                    listaActual = listaDeHeroes;
                    break;
            }
            try {
                s = new Scanner(new FileReader(ficheroFuente));
                while(s.hasNext()){
                    entrada = s.nextLine();
                    nombreObjeto = entrada.split(" ")[0];
                    tipo = entrada.split(" ")[1].charAt(0);
                    switch(tipo){
                        case 'g': tipoRecurso = "ORO";break;
                        case 'e': tipoRecurso = "ELIXIR";break;
                        case 'o': tipoRecurso = "OSCURO";break;
                    }
                    entrada = s.nextLine();
                    arr = entrada.split(" ");
                    niveles = arr.length;
                    tiempos = new int[niveles];
                    costes = new int[niveles];
                    for(int i=0;i<niveles;i++){
                        costes[i] = Integer.parseInt(arr[i].split(",")[0]);
                        tiempos[i] = Integer.parseInt(arr[i].split(",")[1]);
                    }
                    listaActual.add(new Estructura(niveles,tiempos,costes,tipoRecurso));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }finally {
                if(s!=null)
                    s.close();
            }
        }
    }
}
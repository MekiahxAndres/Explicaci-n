package ui;

import java.util.Scanner;

public class Explicacion{

    public static Double[] presupuesto;
    public static String[] lugar;
    public static String[] depto;
    public static Scanner reader;

    public static void main (String[] x){
        System.out.println("Bienvenido voluntario a la aplicación de Gestion de Lugares Biodiversos COP 16 Cali - Colombia."); 

        inicializarGlobales();
        menu();  
    }

    public static void inicializarGlobales() {
        reader = new Scanner(System.in);
        lugar = new String[30];
        depto = new String[30];
        presupuesto = new Double[30];
    }


    public static void menu(){
        boolean salir = false;
        do {
            System.out.println("Te presentamos las siguientes opciones, ingresa:" +
                               "\n1. Para registrar un lugar con diversidad biologica" +
                               "\n2. Para consultar presupuesto" +
                               "\n3. Salir");
            int opcion = reader.nextInt();
            reader.nextLine(); 

            switch (opcion) {

                case 1:
                    registrarLugar();
                    break;

                case 2:
                    consultarPromedioPresupuesto();
                    break;

                case 3:
                    System.out.println("Adios");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no valida.");
                    break;
            }

        } while (!salir);
    }


    public static void registrarLugar() {
        System.out.println("Ingresa el nombre del lugar biodiverso:");
        String nombreLugar = reader.nextLine();

        System.out.println("Ingresa el departamento:");
        String departamento = reader.nextLine();
        System.out.println("Ingresa presupuesto:");
        Double presup = reader.nextDouble();

        // Guardar en los arreglos
        for (int i = 0; i < lugar.length; i++) {
            if (lugar[i] == null) {
                lugar[i] = nombreLugar;
                depto[i] = departamento;
                presupuesto[i] = presup;
                System.out.println("Lugar registrado con exito.");
                break;
            }
        }
    }

     public static void consultarPromedioPresupuesto() {
        System.out.println("Seleccione uno de los cuatro departamentos a revisar el promedio presupuestal: Valle, Choco, Cauca o Nariño");
        String departamento = reader.nextLine();

        int count = 0;
        double suma = 0.0;

        // Calcular promedio
        for (int i = 0; i < depto.length; i++) {
            if (depto[i] != null && depto[i].equalsIgnoreCase(departamento)) {
                suma += presupuesto[i];
                count++;
            }
        }

        if (count > 0) {
            double promedio = suma / count;
            System.out.println("El promedio presupuestal para el departamento de " + departamento + " en los lugares biodiversos ingresados es de " + promedio + " COP");
        } else {
            System.out.println("No hay lugares registrados en el departamento de " + departamento);
        }
    }   
}
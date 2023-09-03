//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 01/09/2023
//Última modificación: 03/09/2023

//Importamos las librerías a utilizar
import java.util.Scanner;
import java.util.ArrayList;

public class Universidad {
    //Declaración de variables
    private static ArrayList<Alumno> estudiantes = new ArrayList<Alumno>();
    private static Scanner teclado = new Scanner(System.in);
    private static String Seleccion1;
    private static boolean verificador1 = true;
    private static ArrayList<Sede> sedes = new ArrayList<Sede>();
    private static Calculo calculo = new Calculo();


    
    public static void main(String[] args){
        //Se colocan los constructores de las sedes y se agregan al ArrayList
        Sede sede1 = new Sede(1);
        sedes.add(sede1);
        Sede sede2 = new Sede(2);
        sedes.add(sede2);
        Sede sede3 = new Sede(3);
        sedes.add(sede3);

        //Menu principal
        while(verificador1){
            System.out.println("Muy buen día querido usuario, ¿qué desea hacer?");
            System.out.println("***** Sección Principal *****");
            System.out.println("1. Agregar nuevo alumno");
            System.out.println("2. Conocer datos estadísticos de examen");
            System.out.println("3. Salir");
            Seleccion1 = teclado.nextLine();

            //Se agrega un nuevo estudiante
            if (Seleccion1.equals("1")){
                estudiantes.add(new Alumno());
            }

            //Cargamos todas las notas a las sedes
            else if (Seleccion1.equals("2")){
                sedes.get(0).manejoNotas(estudiantes);
                sedes.get(1).manejoNotas(estudiantes);
                sedes.get(2).manejoNotas(estudiantes);
                calculo.calculoSedes(sedes);
            }

            //Salimos del programa
            else if (Seleccion1.equals("3")){
                System.out.println("Qué tenga un buen día :)) ");
                verificador1 = false;
            }

            //Código a mostrar si se ingresa una opción invalida
            else{
                System.out.println("Por favor, verifique que esté seleccionando una opción válida.");
            }
        }


        
    }
}

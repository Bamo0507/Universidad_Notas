//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 01/09/2023
//Última modificación: 03/09/2023

//Librerias a utilizar
import java.util.Scanner;


public class Alumno {
    //Declaración de variables a utilizar
    private String Nombre = "";
    private String Apellido = "";
    private String Codigo_Unico = "";
    private String Fecha_Nacimiento = "";
    private String Correo = "";
    private String Done ="";
    private boolean Verificador = true;
    private boolean verificador2 = true;
    private static boolean verificador3 = true;
    private String Examen = "";
    private int Check = 0;
    private static String sede ="";
    private int[] mate = new int[2];
    private int[] leng = new int[2];
    private int[] quim = new int[2];
    private int[] fis = new int[2];
    private int[] comp = new int[2];
    private int[] estd = new int[2];
    private int numSede;
    private static int nota;
    private static boolean intVal = false;
    private static Scanner teclado = new Scanner(System.in);

    //Constructor, se solicita toda su información al alumno
    public Alumno() {
        System.out.println("~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~");
        System.out.println("--- Hola, muy buen día querido estudiante :) ---");
        System.out.println("A continuación, le solicitaremos todos sus datos...");
        System.out.println("-------------------");
        System.out.println("¿Cuál es su nombre? (Solo escriba su primer nombre por favor)");
        Nombre = teclado.nextLine();
        System.out.println("-------------------");
        System.out.println("¿Cuál es su apellido? (Solo escriba su primer apellido por favor)");
        Apellido = teclado.nextLine();
        System.out.println("-------------------");
        System.out.println("¿Cuál es su código de estudiante?");
        Codigo_Unico = teclado.nextLine();
        System.out.println("-------------------");
        System.out.println("Indique su fecha de nacimiento: ");
        Fecha_Nacimiento = teclado.nextLine();
        System.out.println("-------------------");
        System.out.println("Por favor, indique cuál es su correo.");
        Correo = teclado.nextLine();
        System.out.println("-------------------");
        //Se verifica que se haya hecho un examen o no para saber cómo proceder
        while (Verificador){
            System.out.println("¿Se ha realizado algún exámen hasta la fecha?");
            System.out.println("1. Sí \n" + "2. No");
            Done = teclado.nextLine();
            if (Done.equals("1") || Done.equals("2")){
                Verificador = false;
            }
            else {
                System.out.println("-------------------");
                System.out.println("Por favor, asegurese que esté seleccionando la opción 1 o 2 :) ");
                System.out.println("-------------------");
            }        
        }

        //Código a mostrar si no se ha hecho un examen
        if (Done.equals("2")){
            System.out.println("-------------------");
            System.out.println("Por favor vuelva a ingresar cuando ya haya hecho algún exámen ;) ");
            System.out.println("-------------------");
        }

        //Codigo a mostrar si sí se ha hecho algún examen
        else if (Done.equals("1")){
            while (verificador2){
                //Averiguamos qué examenes ha hecho
                System.out.println("¿Qué exámenes se ha hecho?");
                System.out.println("0. Matemática \n1. Lenguaje \n2. Química \n3. Física \n4. Comprensión Lectora \n5. Estadística \n6. Salir \n"); 
                Examen = teclado.nextLine();

                //Registramos la sede en la que se hizo el examen, y la nota
                switch(Examen){
                    case "0":
                        Check = 1;
                        menuSede();
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        mate[0] = numSede;
                        mate[1] = nota;
                        break;
                    
                    case "1":
                        Check = 1;
                        menuSede();
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        leng[0] = numSede;
                        leng[1] = nota;
                        break;

                    case "2":
                        Check = 1;
                        menuSede();
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        quim[0] = numSede;
                        quim[1] = nota;
                        break;

                    case "3":
                        Check = 1;
                        menuSede(); 
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        fis[0] = numSede;
                        fis[1] = nota;
                        break;

                    case "4":
                        Check = 1;
                        menuSede();
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        comp[0] = numSede;
                        comp[1] = nota;
                        break;

                    case "5":
                        Check = 1;
                        menuSede();
                        numSede = Integer.parseInt(sede);
                        verificarInt();
                        estd[0] = numSede;
                        estd[1] = nota;
                        break;

                    //Salimos del menu del alumno para los examenes
                    case "6":
                        if (Check == 1) {
                            System.out.println("Muchas gracias por su atención :D ");
                            verificador2 = false;
                            break;
                        }

                    //Se asegura que se ingrese un examen dado que se mencionó que sí se ha realizado uno
                        else {
                            System.out.println("Mencionó que sí realizó un examen, por favor, ingreselo.");
                        }

                    //Se ingresa número erróneo
                    default:
                        System.out.println("Asegurese de colocar una opción válida.");
                        System.out.println("");

                        
                }

            }
        }
    }

    //Desplega el menu para que el usuario elija una sede
    public static void menuSede(){
        verificador3 = true;
        while (verificador3){
            System.out.println("¿Dónde realizó el examen?");
            System.out.println("1. Sede Central \n2. Sede Sur \n3. Sede Norte");
            sede = teclado.nextLine();
            if (sede.equals("1") || sede.equals("2") || sede.equals("3")){
                verificador3 = false;
            }
            else {
                System.out.println("Por favor ingresar un valor válido.");
            }
        }
    }

    //Verificamos que se esté trabajando con un entero cuando se ingrese la nota
    public static void verificarInt (){
        do {
            System.out.println("¿Cuál fue su nota en este examen?");
            System.out.println("Por favor, asegurese que esté ingresando un entero.");
            if(teclado.hasNextInt()){
                nota = teclado.nextInt();
                intVal = true;
            } else {
                System.out.println("Por favor, ingresar un entero válido.");
                teclado.nextLine();
            } 
        } while (!intVal);
    }

    //Getters de los Arrays que contienen la sede y nota que ha obtenido el usuario
    public int[] getMate(){
        return this.mate;
    }

    public int[] getLeng(){
        return this.leng;
    }

    public int[] getQuim(){
        return this.quim;
    }

    public int[] getFis(){
        return this.fis;
    }

    public int[] getComp(){
        return this.comp;
    }

    public int[] getEstd(){
        return this.estd;
    }

}

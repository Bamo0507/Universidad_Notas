//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 01/09/2023
//Última modificación: 03/09/2023

//Se importan todas las librerías que se han utilizado
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


public class Calculo {
    //Declaracion de todas las variables
    private int Sum_tot = 0;
    private int Cant_est = 0; 
    private float Pt_medio = 0;
    private int Moda = 0;
    private int Suma_desv = 0;
    private double Desviacion = 0;
    private int Max;
    private int Min;

    //Analisis de todas las sedes
    public void calculoSedes(ArrayList<Sede> sedes){
        //Recorremos el arraylist de las sedes
        for(Sede sede : sedes) {
            //Se indica la sede en la que nos encontramos
            System.out.println("");
            System.out.println(sede.toString());
            System.out.println("=============================================");

            //Información de los examenes de mate
            System.out.println("------Examen Matematica------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getNotasMate().isEmpty()){
                System.out.println("No se han registrado datos para esta sede en este examen...");
            } else {
                calculoExamen(sede.getNotasMate());
            }
            System.out.println("----------");

            //Informacion de los examenes de lenguaje
            System.out.println("------Examen Lenguaje------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getNotasLenguaje().isEmpty()){
                System.out.println("No se han registrado datos para esta sede en este examen...");
            } else {
                calculoExamen(sede.getNotasLenguaje());
            }
            System.out.println("----------");

            //Informacion de examenes quimica
            System.out.println("------Examen Quimica------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getNotasQuimica().isEmpty()){
                System.out.println("No se han registrado datos para esta sede en este examen...");
            } else {
                calculoExamen(sede.getNotasQuimica());
            }
            System.out.println("----------");

            //Informacion de examenes fisica
            System.out.println("------Examen Fisica------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getNotasFisica().isEmpty()){
                System.out.println("No se han registrado datos para esta sede en este examen...");
            } else{
                calculoExamen(sede.getNotasFisica());
            }
            System.out.println("----------");

            //Informacion de examenes de CompLectora
            System.out.println("------Examen Comprension Lectora------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getComprension().isEmpty()){
                System.out.println("No se han registrado datos para este examen...");
            } else{
                calculoExamen(sede.getComprension());
            }
            System.out.println("----------");

            //Información de examenes Estadística
            System.out.println("------Examen Estadística------");
            //Se comprueba que se tengan notas en este examen
            if(sede.getEstadistica().isEmpty()){
                System.out.println("No se han registrado datos para este examen...");
            } else{
                calculoExamen(sede.getEstadistica());
            }
            System.out.println("----------");
            System.out.println("=============================================");
            System.out.println("");
        }
    }

    //Se hacen los cálculos dado un ArrayList de notas, es decir, para un curso
    public void calculoExamen(ArrayList<Integer> notas){
        float Promedio = 0;
        //Suma de todas las notas para el promedio
        for(int nota : notas) {
            Sum_tot += nota;
        }
        //Cant datos
        Cant_est = notas.size();
        //Mediana
        Collections.sort(notas);
        if (Cant_est % 2 == 0) {
            int mitad1 = notas.get(Cant_est / 2-1);
            int mitad2 = notas.get(Cant_est / 2);
            Pt_medio = (mitad1 + mitad2) /2;
        } else {
            Pt_medio = notas.get(Cant_est / 2);
        }
        //Moda
        Map<Integer, Integer> frecuencias = new HashMap<>();
        int frecuenciaMaxima = 0;
        for (int nota : notas) {
            int frecuencia = frecuencias.getOrDefault(nota, 0) + 1;
            frecuencias.put(nota, frecuencia);
            if (frecuencia > frecuenciaMaxima){
                Moda = nota;
                frecuenciaMaxima = frecuencia;
            }
        }
        //Promedio
        Promedio = Sum_tot/Cant_est;

        //Desviacion estándar
        if (notas.size() > 1) {
            for(int nota: notas) {
            float diferencia = nota - Promedio;
            Suma_desv += Math.pow(diferencia, 2);
            }
            float varianza = Suma_desv/(Cant_est -1);
            Desviacion = Math.sqrt(varianza);
        }
        

        //Max y Min
        Max = Collections.max(notas);
        Min = Collections.min(notas);

        //Display de toda la información estadística
        System.out.println("=============================================");
        System.out.println("Se han registrado un total de: " + Cant_est + " estudiantes.");
        System.out.println("La nota más alta ha sido de: " + Max + ".");
        System.out.println("La nota más baja ha sido de: " + Min + ".");
        System.out.println("El promedio ha sido de: " + Promedio + ".");
        System.out.println("La mediana está en: " + Pt_medio + ".");
        System.out.println("La moda es de: " + Moda + ".");
        System.out.println("La desviación estándar fue de: " + Desviacion + ".");
        //Se muestra cuando solo se tenga un dato para un tipo de examen
        if (Desviacion == 0){
            System.out.println("No se pudo calcular la desviación estándar muestral, solo se ha registrado un dato para este examen en esta sede.");
        }
        System.out.println("=============================================");

    }

}

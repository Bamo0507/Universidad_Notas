//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 01/09/2023
//Última modificación: 03/09/2023

//Se importan las librarías a utilizar
import java.util.ArrayList;

public class Sede {
    //Declaracion de todas las variables a emplear
    private int numSede;
    private ArrayList<Integer> notasMate = new ArrayList<>();
    private ArrayList<Integer> notasLenguaje = new ArrayList<>();
    private ArrayList<Integer> notasQuimica = new ArrayList<>();
    private ArrayList<Integer> notasFisica = new ArrayList<>();
    private ArrayList<Integer> notasComprension = new ArrayList<>();
    private ArrayList<Integer> notasEstadistica = new ArrayList<>();
    private int[] notAl = new int[2];
    private String nombreSede;

    //Se establece el número de sede y su nombre
    public Sede(int numSede){
        this.numSede = numSede;
        if (numSede == 1){
            nombreSede = "Sede Central";
        }
        else if (numSede == 2){
            nombreSede = "Sede Sur";
        }
        else if (numSede == 3){
            nombreSede = "Sede Norte";
        }
    }

    //Se estudia si el examen se hizo en esa sede, y se almacenan las notas
    public void manejoNotas(ArrayList<Alumno> estudiantes){
        //Corremos todo el arraylist de estudiantes
        for(Alumno alumno: estudiantes){
            notAl = alumno.getMate();
            if (notAl[0] == numSede){
                notasMate.add(notAl[1]);
            }
            notAl = alumno.getLeng();
            if (notAl[0] == numSede){
                notasLenguaje.add(notAl[1]);
            }
            notAl = alumno.getQuim();
            if (notAl[0] == numSede){
                notasQuimica.add(notAl[1]);
            }
            notAl = alumno.getFis();
            if(notAl[0] == numSede){
                notasFisica.add(notAl[1]);
            }
            notAl = alumno.getComp();
            if(notAl[0] == numSede){
                notasComprension.add(notAl[1]);
            }
            notAl = alumno.getEstd();
            if(notAl[0] == numSede){
                notasEstadistica.add(notAl[1]);
            }

            
        }
    }

    //Getters para todos los ArrayLists de las notas de examen
    public ArrayList<Integer> getNotasMate() {
        return notasMate;
    }

    public ArrayList<Integer> getNotasLenguaje() {
        return notasLenguaje;
    }

    public ArrayList<Integer> getNotasQuimica() {
        return notasQuimica;
    }

    public ArrayList<Integer> getNotasFisica() {
        return notasFisica;
    }

    public ArrayList<Integer> getComprension() {
        return notasComprension;
    }

    public ArrayList<Integer> getEstadistica() {
        return notasEstadistica;
    }

    //Mensaje de retorno para cada sede
    public String toString(){
        return numSede + ". " + nombreSede +  " Datos Estadísticos: ";
    }

 }



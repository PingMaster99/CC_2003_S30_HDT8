import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * <h1>Main</h1>
 *<p>
 * Main class used to run the patient attention app
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-01
 **/
public class Main {
    public static void main(String[] args) {

        // patientDat contains all patients in the file
        ArrayList<Paciente> patientData = new ArrayList<>();    // Data obtained from text file

        // Used to get input
        Scanner input = new Scanner(System.in);

        // Prints the main menu by default, JCF implementation is used
        System.out.println("Asistente de pacientes virtual");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Indique el tipo de implementacion que desea utilizar: ");
        System.out.println("1 -> Implementacion de VectorHeap con PriorityQueue");
        System.out.println("2 -> Implementacion de Java Collections Framework");
        System.out.println("-----------------------------------------------------------------------------------------");

        String choice = input.nextLine();   // Gets input

        // Reads the document
        try {
            BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
            String line;

            // Saves each patient found
            while((line = reader.readLine()) != null) {
                String patientIntel[] = line.split(",");
                Paciente patient = new Paciente(patientIntel[0], patientIntel[1], patientIntel[2]);
                patientData.add(patient);
            }

        // If document is not found
        } catch (Exception E) {
            System.err.println("Hubo un error al leer el documento");
            System.err.println("Por favor asegurese de que el nombre de este sea 'pacientes.txt'");
        }

        // VectorHeap implementation
        if(choice.equals("1")) {
            System.out.println("Utilizando VectorHeap con PriorityQueue");
            VectorHeap<Paciente> patientHeap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue

            // Adds all patients to the heap
            for(int i = 0; i < patientData.size(); i++) {
                patientHeap.add(patientData.get(i));
            }

            // Returns the patients according to priority
            while (patientHeap.size() > 0){
                Paciente currentPatient = patientHeap.remove();
                attendPatient(currentPatient);
            }

        // JCF implementation
        } else {
            System.out.println("Utilizando Java Collections Framework");
            PriorityQueue<Paciente> patientQueue = new PriorityQueue<Paciente>();   // Using JCF

            // Adds all patients to the queue
            for(int i = 0; i < patientData.size(); i++) {
                patientQueue.add(patientData.get(i));
            }

            // Returns the patients according to priority
            while(patientQueue.size() > 0) {
                Paciente currentPatient = patientQueue.remove();
                attendPatient(currentPatient);
            }
        }

        // Once all patients are attended
        System.out.println();
        System.out.println("Gracias por ayudar a salvar vidas, su trabajo por hoy ha terminado");
        System.out.println("No olvide lavar sus manos :)");
    }

    /**
     * Method that displays the current patient and waits for the next one
     */
    public static void attendPatient(Paciente patient) {

        // To wait for input
        Scanner next = new Scanner(System.in);
        // Patient information
        String name = patient.getPatientName();
        String symptoms = patient.getSymptoms();
        String priority = patient.getPriority();

        // Prints needed data
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Atendiendo paciente");
        System.out.println("Nombre: " + name);
        System.out.println("Padecimientos:" + symptoms);
        System.out.println("Prioridad:" + priority);

        // Added an easter egg
        if(symptoms.equals(" COVID-19")) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ADVERTENCIA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("                      Este paciente padece de Coronavirus, \n" +
                    "          se recomienda enviarlo inmediatamente a un hospital designado" );
            System.out.println();
            System.out.println("                              No ha contagiado a nadie");
            System.out.println("     Segun el analisis por inteligencia artificial, el paciente se curara en 3 dias");
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        // Waits for confirmation that the doctor is finished
        System.out.println("Presione enter cuando desee atender al siguiente");
        System.out.print(">>");
        next.nextLine();
    }
}

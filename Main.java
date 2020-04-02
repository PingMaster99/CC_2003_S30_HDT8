import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // patientDat contains all patients in the file
        ArrayList<Paciente> patientData = new ArrayList<>();    // Data obtained from text file

        Scanner input = new Scanner(System.in);
        System.out.println("Indique el tipo de implementacion que desea utilizar: ");
        System.out.println("1 -> Implementacion de VectorHeap con PriorityQueue");
        System.out.println("2 -> Implementacion de Java Collections Framework");
        String choice = input.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
            String line;

            while((line = reader.readLine()) != null) {
                String patientIntel[] = line.split(",");
                Paciente patient = new Paciente(patientIntel[0], patientIntel[1], patientIntel[2]);
                patientData.add(patient);
            }

        } catch (Exception E) {
            System.err.println("Hubo un error al leer el documento");
            System.err.println("Por favor asegurese de que el nombre de este sea 'pacientes.txt'");
        }


        if(choice.equals("1")) {
            System.out.println("Utilizando VectorHeap con PriorityQueue");
            VectorHeap<Paciente> patientHeap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue
            for(int i = 0; i < patientData.size(); i++) {
                patientHeap.add(patientData.get(i));
            }

            for(int i = 0; patientHeap.size() > 0; i++){
                Paciente currentPatient = patientHeap.remove();
                attendPatient(currentPatient);
            }


        } else {
            System.out.println("Utilizando Java Collections Framework");
            PriorityQueue<Paciente> patientQueue = new PriorityQueue<Paciente>();   // Using JCF
            for(int i = 0; i < patientData.size(); i++) {
                patientQueue.add(patientData.get(i));
            }

            for(int i = 0; patientQueue.size() > 0; i++){
                Paciente currentPatient = patientQueue.remove();
                attendPatient(currentPatient);
            }
        }
        System.out.println();
        System.out.println("Gracias por ayudar a salvar vidas, su trabajo por hoy ha terminado");
        System.out.println("No olvide lavar sus manos :)");
    }

    public static void attendPatient(Paciente patient) {
        Scanner next = new Scanner(System.in);
        String name = patient.getPatientName();
        String symptoms = patient.getSymptoms();
        String priority = patient.getPriority();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Atendiendo paciente");
        System.out.println("Nombre: " + name);
        System.out.println("Padecimientos:" + symptoms);
        System.out.println("Prioridad:" + priority);

        // Added an easter egg
        if(symptoms.equals(" COVID-19")) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ADVERTENCIA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("                  Este paciente padece de Coronavirus, \n" +
                    "      se recomienda enviarlo inmediatamente a un hospital designado" );
            System.out.println();
            System.out.println("   Segun el analisis por inteligencia artificial, el paciente se curara en 3 dias");

        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Presione enter cuando desee atender al siguiente");
        System.out.print(">>");
        next.nextLine();
    }
}

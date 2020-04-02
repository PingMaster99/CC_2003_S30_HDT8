import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Queues are initialized before to avoid code repetition below
        ArrayList<Paciente> patientData = new ArrayList<>();    // Data obtained from text file
        VectorHeap<Paciente> patientHeap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue
        PriorityQueue<Paciente> patientQueue = new PriorityQueue<Paciente>();   // Using JCF

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
            for(int i = 0; i < patientData.size(); i++) {
                patientHeap.add(patientData.get(i));
            }

        } else {
            System.out.println("Utilizando Java Collections Framework");
            for(int i = 0; i < patientData.size(); i++) {
                patientQueue.add(patientData.get(i));
            }
        }
    }
}

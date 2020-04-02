import static org.junit.Assert.*;
/**
 * <h1>VectorHeapTest</h1>
 *<p>
 * Tests for the add and remove methods of VectorHeap
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-01
 **/
public class VectorHeapTest {


    @org.junit.Test
    public void add() {
        // Makes a new vector heap
        VectorHeap<Paciente> siuHeap = new VectorHeap<>();

        // Patients to be added
        Paciente paciente = new Paciente("Elmer Curio", "Comio mucho", "B");
        Paciente elBicho = new Paciente("Cristiano Ronaldo", "Bichos","A");
        Paciente laPulga = new Paciente("Lionel Messi", "Genius", "A");

        // Adding patients
        siuHeap.add(paciente);
        siuHeap.add(elBicho);
        siuHeap.add(laPulga);

        // Tests
        assertEquals(3, siuHeap.size());    // All patients were added

        // Check correct priority
        assertEquals(siuHeap.remove().getPatientName(),"Cristiano Ronaldo");
        assertEquals(siuHeap.remove().getPatientName(),"Lionel Messi");
        assertEquals(siuHeap.remove().getPatientName(),"Elmer Curio");
    }

    @org.junit.Test
    public void remove() {
        // Makes a new vector heap
        VectorHeap<Paciente> removeHeap = new VectorHeap<>();

        // Patient to be added
        Paciente zoilaFlor = new Paciente("Zoila Flor", "Olor a rosas", "A");
        removeHeap.add(zoilaFlor);

        // Checks that its removing correctly
        assertEquals(removeHeap.remove().getPriority(),"A");
    }
}
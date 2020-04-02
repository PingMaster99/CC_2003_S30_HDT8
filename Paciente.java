/**
 * <h1>Paciente</h1>
 *<p>
 * Class that stores the information of a patient and allows to compare
 * their priority.
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-01
 **/
public class Paciente implements Comparable<Paciente>{
    String patientName;
    String symptoms;
    String priority;

    /**
     * Paciente constructor, returns a patient with the needed information
     * @param patientName name of the patient
     * @param  symptoms symptoms he or she is presenting
     * @param  priority priority in the queue
     */
    Paciente(String patientName, String symptoms, String priority) {
        this.patientName = patientName;
        this.symptoms = symptoms;
        this.priority = priority;
    }

    /**
     * Compares the priority of patients
     * @param otherPatient patient to be compared to
     */
    @Override
    public int compareTo(Paciente otherPatient) {
        if(this.priority.compareTo(otherPatient.priority) > 0) {
            return 1;   // Patient has less priority
        } else if (this.priority.compareTo(otherPatient.priority) < 0) {
            return -1;  // Patient has more priority
        }
        return 0;   // Patient has equal priority
    }

    /**
     * Gets the name of the patient
     * @return name
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Gets the symptoms of the patient
     * @return symptoms
     */
    public String getSymptoms() {
        return symptoms;
    }

    /**
     * Gets the priority of the patient
     * @return priority
     */
    public String getPriority() {
        return priority;
    }
}

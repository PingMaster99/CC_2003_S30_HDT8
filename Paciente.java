public class Paciente implements Comparable<Paciente>{
    String patientName;
    String symptoms;
    String priority;

    Paciente(String patientName, String symptoms, String priority) {
        this.patientName = patientName;
        this.symptoms = symptoms;
        this.priority = priority;
    }

    @Override
    public int compareTo(Paciente otherPatient) {
        if(this.priority.compareTo(otherPatient.priority) > 0) {
            return 1;   // Patient has less priority
        } else if (this.priority.compareTo(otherPatient.priority) < 0) {
            return -1;  // Patient has more priority
        }
        return 0;   // Patient has equal priority
    }

    public String getPatientName() {
        return patientName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getPriority() {
        return priority;
    }
}

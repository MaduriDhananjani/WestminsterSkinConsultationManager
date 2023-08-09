import java.util.Date;

public class Doctor extends Person implements Comparable<Doctor>{ // gui interface ekedi d clz eke object eke  doctor clz eke interface eke hadana  compair krnn puluwan
    private String medicalLicenseNumber;
    private String specialization;

    public Doctor(String name, String surname, Date birthDate, String mobileNumber,  String medicalLicenseNumber, String specialization) {
        super(name, surname, birthDate, mobileNumber); // variables person clz ekata yawnn
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }

    public Doctor(){} // default constructor

    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override //me method ek inherite une parent clz eken
    public int compareTo(Doctor o) {
        return this.getSurname().compareToIgnoreCase(o.getSurname());
    }
}

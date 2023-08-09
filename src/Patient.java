import java.util.Date;
import java.util.UUID;

public class Patient extends Person{   // inherite attribute

    private final int Patientid;  // patient id eka integer ekk widiyta gann eka

    public Patient(String name, String surname, Date birthDate, String mobileNumber) {  //patient details get
        super(name, surname, birthDate, mobileNumber); //refer to super class object ,use to call super clz methods
        this.Patientid = generateUniqueId(); // this-eliminate the confusion between class attributes and parameters with the same name
    }

    public int getPatientid() {
        return this.Patientid;
    } //

    public static int generateUniqueId() {
        UUID randomNumber = UUID.randomUUID();
        String value =""+randomNumber;
        int uid=value.hashCode();
        String filterStr=""+uid;
        value = filterStr.replaceAll("-", "");
        return Integer.parseInt(value);
    }
}

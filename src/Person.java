import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable { // bite widiyata file save wen eka
    private String name;
    private String surname;
    private Date dOB;
    private String mobileNumber;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    Person(){ } //default constructor

    Person(String name,String surname, Date birthDate, String mobileNumber){ // variable send - parameterize consructor
        this.name = name;
        this.surname = surname;
        this.dOB = birthDate;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getdOB() {
        return dOB;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}

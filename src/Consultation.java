import java.util.Date;

public class Consultation extends Doctor{
    private final String timeSlot;
    private final String cost;
    private String notes;
    private final Date date;
    private final String docName;

    public Consultation(String name, String specialization, Date date, String time, String notes, String costOfTheConsultation){
        this.docName = name;
        super.setSpecialization(specialization);
        this.date = date;
        this.timeSlot = time;
        this.notes = notes;
        this.cost = costOfTheConsultation;
    }
    public String getTimeSlot() {
        return timeSlot;
    }

    public String getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDocName(){
        return docName;
    }
    public Date getDate(){
        return date;
    }
}

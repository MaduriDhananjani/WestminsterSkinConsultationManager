import java.util.ArrayList;

public interface SkinConsultationManager {
    void AddDoctor();
    void DeleteDoctor();
    void PrintDoctorList();
    void SaveFile();
    void LoadFile(ArrayList<Doctor> list);

}

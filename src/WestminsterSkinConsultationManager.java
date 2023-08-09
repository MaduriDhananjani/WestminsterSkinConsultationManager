import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements  SkinConsultationManager {
    public static ArrayList<Doctor> doctorslist = new ArrayList<>(10);
    public static final SimpleDateFormat dateOfBirth = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void AddDoctor() { //
        String choice = "";
        do {
            try{
                int count = doctorslist.size();

                //Check whether the list contains total of 10 doctors
                if (!(count == 10)){
                    System.out.println("======================================================================================================================");
                    System.out.println("|" + "                                             Add new doctor                                                        " + "|");
                    System.out.println("======================================================================================================================");
                    System.out.println("Enter the name of the doctor:");
                    String name = "Dr. " + scanner.next();

                    System.out.println("Enter the surname of the doctor:");
                    String surname = scanner.next();

                    System.out.println("Enter the mobile number of the doctor:");
                    String mobileNo = scanner.next();

                    System.out.println("Enter the doctor's Date of Birth(dd/MM/yyyy):");
                    String doctorDob = scanner.next();
                    Date dob = dateOfBirth.parse(doctorDob);

                    System.out.println("Enter the Medical License Number of the doctor:");
                    String mediLiNumber = scanner.next();

                    System.out.println("Select the specialization from the below:");
                    System.out.println("1. Cosmetic dermatology\n2. Medical dermatology,\n3. Paediatric dermatology\n4. Other");
                    int num = scanner.nextInt();
                    String specialization = "";
                    if (num == 1){
                        specialization = "Cosmetic dermatology";
                    } else if (num == 2) {
                        specialization = "Medical dermatology";
                    } else if (num == 3) {
                        specialization = "Paediatric dermatology";
                    } else if (num == 4) {
                        System.out.println("Enter the specialization:");
                        specialization = scanner.next();
                    }else {
                        System.out.println("You entered the wrong selection");
                    }

                    Doctor doctors = new Doctor(name, surname, dob, mobileNo, mediLiNumber, specialization);
                    doctorslist.add(doctors);
                    System.out.println("Doctor added successfully!");
                    System.out.println("\nYou can add " + (10 - (++count)) + " more doctors to the center");

                    System.out.println("Do you want add another doctor?(Y/N):");
                    choice = scanner.next();
                }
                else {
                    System.out.println("Can't add doctors, Your center is full!");
                    break;
                }

            }catch (ParseException e){
                System.out.println("Format of your entered value is invalid!");
            }
            catch (Exception a){
                System.out.println("Doctor can't add to the center, something went wrong!");
            }

        }while (choice.equalsIgnoreCase("Y"));
        System.out.println("Returning to the main menu.......");

    }

    @Override
    public void DeleteDoctor() {
        try{
            System.out.println("======================================================================================================================");
            System.out.println("|" + "                                                  Delete a doctor                                                   " + "|");
            System.out.println("======================================================================================================================");

            System.out.println("Enter the medical license number:");
            String medicalLicence = scanner.next();

            if (!(doctorslist.isEmpty())){
                for (Doctor doctor: doctorslist) {
                    if (medicalLicence.equals(doctor.getMedicalLicenseNumber())) {
                        System.out.println("Do you want to delete doctor " + doctor.getName() + " from the center?(Y/N)");
                        String ans = scanner.next();

                        if (ans.equalsIgnoreCase("y")) {
                            doctorslist.remove(doctor);
                            System.out.println("Doctor deleted successfully!");
                        } else {
                            System.out.println("Returning to the main menu.......");
                        }
                        break;
                    }
                }
            }else {
                System.out.println("Doctor not found!");
            }
        }catch (Exception e){
            System.out.println("Doctor can't delete from the center, Something went wrong!");
        }

    }

    @Override
    public void PrintDoctorList() {
        try{
            System.out.println("======================================================================================================================");
            System.out.println("|" + "                                                   List of Doctors                                                  " + "|");
            System.out.println("======================================================================================================================\n");
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %s\n", "Name", "Surname", "Date of birth", "Mobile number", "Medical License Number", "Specialization\n");

            if (doctorslist.isEmpty()){
                System.out.println("\n");
                System.out.println("                                                  Data not found");
                System.out.println("\n");
            }
            else {
                //creating new arraylist to sort
                ArrayList<Doctor> sortedArrayList = new ArrayList<>(doctorslist.size());
                //add main array list object to new arraylist
                sortedArrayList.addAll(doctorslist);
                //sort new array list using comparable class
                Collections.sort(sortedArrayList);
                for (Doctor doc:
                        sortedArrayList) {
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %s\n", doc.getName(), doc.getSurname(), dateOfBirth.format(doc.getdOB()), doc.getMobileNumber(), doc.getMedicalLicenseNumber(), doc.getSpecialization());
                }
            }
            System.out.println("\n                                                      ***");
        }
        catch (Exception e){
            System.out.println("Can't print the list of the doctors, Something went wrong!");
        }
    }

    @Override
    public void SaveFile() {
        try {
            FileOutputStream fo = new FileOutputStream("DoctorList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Doctor doctor:
                    doctorslist) {
                oos.writeObject(doctor);
            }
            fo.close();
            oos.close();
            System.out.println("Saved to file!");

        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    @Override
    public void LoadFile(ArrayList<Doctor> list){
        try{
            FileInputStream fis = new FileInputStream("DoctorList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try{
                    Doctor doctor = (Doctor) ois.readObject();//
                    list.add(doctor);
                }
                catch (Exception e){
                    break;
                }
            }
            fis.close();
            ois.close();
        }
        catch (IOException e){
            System.out.println("File not found!");
        }
    }
}
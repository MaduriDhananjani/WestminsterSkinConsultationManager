import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean option = true;
        Scanner scanner = new Scanner(System.in);
        WestminsterSkinConsultationManager west = new WestminsterSkinConsultationManager();

        //Initially load all the data from the file
        west.LoadFile(WestminsterSkinConsultationManager.doctorslist);
        ConsultationGUI.LoadFromFile(ConsultationGUI.patients,ConsultationGUI.consultations);

        System.out.println("\n                                      Welcome to Westminster Skin Consultation Manager ");

        do {
            System.out.println("**********************************************************************************************************************");
            System.out.println("|" + "                                                        Menu List                                                   " + "|");
            System.out.println("**********************************************************************************************************************");
            System.out.println("| " + "       1        |                        Add new Doctor                                                           " + " |");
            System.out.println("| " + "       2        |                        Delete a Doctor                                                          " + " |");
            System.out.println("| " + "       3        |                        Print the Doctor List                                                    " + " |");
            System.out.println("| " + "       4        |                        Save in file                                                             " + " |");
            System.out.println("| " + "       5        |                        Open System                                                              " + " |");
            System.out.println("| " + "       0        |                        Quit                                                                     " + " |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

            System.out.println("Enter your selection:");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "1" -> west.AddDoctor();
                case "2" -> west.DeleteDoctor();
                case "3" -> west.PrintDoctorList();
                case "4" -> west.SaveFile();
                case "5" -> EventQueue.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             UnsupportedLookAndFeelException e) {
                        throw new RuntimeException(e);
                    }
                    new SystemGUI();
                });
                case "0" -> option = false;
            }

        } while (option);
        System.out.println("\n                                              Thank you for your time, Bye! :)");
    }
}
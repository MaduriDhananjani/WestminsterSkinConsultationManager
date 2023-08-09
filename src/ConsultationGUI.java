import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ConsultationGUI{
    public static final ArrayList<Patient> patients = new ArrayList<>();
    public static final ArrayList<Consultation> consultations = new ArrayList<>();

    public JFrame background;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField mobileNumberField;
    private JLabel dOBlbl;
    private JLabel  datelbl;
    private JTextArea notesTextArea;
    private DefaultComboBoxModel<Object> docNames = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Object> specializationBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Object> timeSlotBoxModel = new DefaultComboBoxModel<>();
    private JButton backToHomeBtn;
    private String dob;
    private String pickedDate;
    private String nameOfTheDoctor;
    private Date date;
    private Date pickedDate1;
    private JComboBox comboForSpecialization;
    private JComboBox comboBoxForDocName;
    private JComboBox jComboBoxForTime;

    ConsultationGUI() {
        // Creating JFrame
        background = new JFrame();
        background.setTitle("Westminster Skin Consultation Manager");
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background.setSize(1440, 800);
        //background.setResizable(false);
        background.setLayout(null);
        background.setVisible(true);

        backToHomeBtn = new JButton("HOME");
        backToHomeBtn.setBounds(40,10,100,30);
        backToHomeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background.dispose();
                new SystemGUI();
            }
        });
        background.add(backToHomeBtn);



        JLabel patientDetails = new JLabel("Patient Details");
        patientDetails.setFont(new Font("Arial", Font.BOLD, 25));
        patientDetails.setBounds(100, 55, 300, 100);
        background.add(patientDetails);

        JLabel pFirstName = new JLabel("First Name");
        pFirstName.setBounds(40, 150, 100, 35);
        pFirstName.setFont(new Font("MV Boli", Font.PLAIN, 18));
        background.add(pFirstName);

        nameField = new JTextField();
        nameField.setBounds(145, 150, 200, 40);
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBackground(new Color(207, 205, 202));
        background.add(nameField);

        JLabel pSurName = new JLabel("Surname");
        pSurName.setBounds(40, 200, 100, 35);
        pSurName.setFont(new Font("MV Boli", Font.PLAIN, 18));
        background.add(pSurName);

        surnameField = new JTextField();
        surnameField.setBounds(145, 200, 200, 40);
        surnameField.setFont(new Font("Arial", Font.PLAIN, 18));
        surnameField.setBackground(new Color(207, 205, 202));
        background.add(surnameField);

        JLabel pDOB = new JLabel("Date Of Birth");
        pDOB.setBounds(40, 250, 150, 35);
        pDOB.setFont(new Font("MV Boli", Font.PLAIN, 18));
        background.add(pDOB);

        dOBlbl = new JLabel();
        dOBlbl.setBounds(195, 250, 150, 35);
        dOBlbl.setFont(new Font("Arial", Font.PLAIN, 18));
        dOBlbl.setBackground(new Color(207, 205, 202));
        dOBlbl.setOpaque(true);
        background.add(dOBlbl);

        JButton calenderBtn = new JButton();
        calenderBtn.setBounds(350, 250, 40, 40);
        calenderBtn.addActionListener(ae -> dOBlbl.setText(new DateSelect(background).setPickedDate()));
        background.add(calenderBtn);


        JLabel pMobile = new JLabel("Mobile Number");
        pMobile.setBounds(40, 300, 150, 35);
        pMobile.setFont(new Font("MV Boli", Font.PLAIN, 18));
        background.add(pMobile);

        mobileNumberField = new JTextField();
        mobileNumberField.setBounds(195, 300, 200, 40);
        mobileNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        mobileNumberField.setBackground(new Color(207, 205, 202));
        background.add(mobileNumberField);



// Consultation
        JLabel addConsultation = new JLabel("Add Consultation");
        addConsultation.setFont(new Font("Arial", Font.BOLD, 25));
        addConsultation.setBounds(900, 55, 300, 50);

        JLabel selectDocLabel = new JLabel("Select a Doctor");
        selectDocLabel.setBounds(700, 210, 150, 35);
        selectDocLabel.setFont(new Font("MV Boli", Font.PLAIN, 18));

        JLabel labelForSpec = new JLabel("Specialization");
        labelForSpec.setBounds(700, 150, 150, 35);
        labelForSpec.setFont(new Font("MV Boli", Font.PLAIN, 18));

        JLabel forDate = new JLabel("Pick a Date");
        forDate.setBounds(700, 260, 120, 35);
        forDate.setFont(new Font("MV Boli", Font.PLAIN, 18));

        datelbl = new JLabel();
        datelbl.setBounds(855, 260, 150, 35);
        datelbl.setFont(new Font("Arial", Font.PLAIN, 18));
        datelbl.setBackground(new Color(207, 205, 202));
        datelbl.setOpaque(true);

        JButton calenderBtn2 = new JButton();
        calenderBtn2.setBounds(1010, 260, 50, 40);
        calenderBtn2.setIcon(new ImageIcon("calendar.png"));
        calenderBtn2.addActionListener(ae -> datelbl.setText(new DateSelect(background).setPickedDate()));

        JLabel labelForDuration = new JLabel("Time Slot");
        labelForDuration.setBounds(700, 300, 150, 35);
        labelForDuration.setFont(new Font("MV Boli", Font.PLAIN, 18));

        JLabel labelForNote = new JLabel("Add Notes");
        labelForNote.setBounds(700, 350, 100, 35);
        labelForNote.setFont(new Font("MV Boli", Font.PLAIN, 18));

        notesTextArea = new JTextArea();
        notesTextArea.setLineWrap(true);
        notesTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        notesTextArea.setBackground(new Color(207, 205, 202));
        notesTextArea.setOpaque(true);

        JScrollPane textAreaScroll = new JScrollPane(notesTextArea);
        textAreaScroll.setBounds(855, 350, 200, 75);

        JLabel labelForImg = new JLabel("Upload an Image");
        labelForImg.setBounds(700, 430, 170, 35);
        labelForImg.setFont(new Font("MV Boli", Font.PLAIN, 18));

        JButton fileChooser = new JButton("Browse");
        fileChooser.setIcon(new ImageIcon("folder.png"));
        fileChooser.setBounds(875, 430, 150, 35);
        fileChooser.addActionListener(ae -> {
            if (ae.getSource() == fileChooser) {
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
                jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int value = jFileChooser.showSaveDialog(null);

                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = jFileChooser.getSelectedFile();
                    String filePath = selectedImage.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, filePath);
                }
            }
        });

        background.add(addConsultation);
        background.add(selectDocLabel);
        background.add(DoctorNames());
        background.add(labelForSpec);
        background.add(forDate);
        background.add(datelbl);
        background.add(calenderBtn2);
        background.add(labelForDuration);
        background.add(labelForNote);
        background.add(textAreaScroll);
        background.add(labelForImg);
        background.add(fileChooser);
        background.add(Book());
        background.add(ResetButton());
        background.add(ListOfAppointments());
        background.add(DoctorSpecialization());
        background.add(TimeSlot());
    }

    public static void SaveInFile() {
        try {
            FileOutputStream fo = new FileOutputStream("PatientList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Patient patient : patients) {
                oos.writeObject(patient);
            }
            fo.close();
            oos.close();


            FileOutputStream fo1 = new FileOutputStream("Consultation.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fo1);

            for (Consultation consultation : consultations) {
                oos1.writeObject(consultation);
            }
            fo1.close();
            oos1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void LoadFromFile(ArrayList<Patient> listOfPatients, ArrayList<Consultation> listOfConsultation) {
        try {
            FileInputStream fis = new FileInputStream("PatientList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileInputStream fis1 = new FileInputStream("Consultation.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            while (true) {
                try {
                    Patient patient = (Patient) ois.readObject();
                    Consultation consultation = (Consultation) ois1.readObject();
                    listOfPatients.add(patient);
                    listOfConsultation.add(consultation);
                } catch (Exception e) {
                    break;
                }
            }
            fis1.close();
            ois1.close();
            fis.close();
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private JComboBox DoctorNames() {
        comboBoxForDocName = new JComboBox(docNames);
        comboBoxForDocName.setBounds(855, 210, 200, 40);
        comboBoxForDocName.setFont(new Font("Arial", Font.PLAIN, 15));
        return comboBoxForDocName;
    }

    private JComboBox DoctorSpecialization() {
        int count = WestminsterSkinConsultationManager.doctorslist.size();
        String[] specialization = new String[count];
        int iteration = 0;
        for (Doctor doc : WestminsterSkinConsultationManager.doctorslist) {
            specialization[iteration] = doc.getSpecialization();
            iteration++;
        }

        specializationBoxModel.addElement("-- Select --");
        docNames.addElement("-- Select --");

        //removing all duplicate elements in the array
        for (int i = 0; i < count; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (specialization[i].equals(specialization[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                specializationBoxModel.addElement(specialization[i]);
            }
        }

        comboForSpecialization = new JComboBox(specializationBoxModel);
        comboForSpecialization.setBounds(855, 150, 200, 40);
        comboForSpecialization.setFont(new Font("Arial", Font.PLAIN, 15));
        comboForSpecialization.addActionListener(ae -> {
            if (ae.getSource() == comboForSpecialization) {
                docNames.removeAllElements();
                for (Doctor doctor : WestminsterSkinConsultationManager.doctorslist) {
                    if (doctor.getSpecialization().equals(comboForSpecialization.getSelectedItem())) {
                        docNames.addElement(doctor.getName() + " " + doctor.getSurname());
                    }
                }
            }
        });
        return comboForSpecialization;
    }

    private JButton Book() {
        JButton book = new JButton("Book Now");
        book.setBounds(700, 500, 150, 35);
        book.setFont(new Font("MV Boli", Font.BOLD, 12));
        book.setForeground(Color.BLUE);
        book.addActionListener(ae -> {
            if (ae.getSource() == book) {
                if (!nameField.getText().isEmpty() && !surnameField.getText().isEmpty() && !dOBlbl.getText().isEmpty() && !mobileNumberField.getText().isEmpty()) {
                    String firstName = nameField.getText();
                    String lastName = surnameField.getText();
                    try {
                        dob = dOBlbl.getText();
                        date = WestminsterSkinConsultationManager.dateOfBirth.parse(dob);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String mobile = mobileNumberField.getText();

                    String specialization = (String) DoctorSpecialization().getSelectedItem();
                    String doctorName = (String) DoctorNames().getSelectedItem();
                    try {
                        pickedDate = datelbl.getText();
                        pickedDate1 = WestminsterSkinConsultationManager.dateOfBirth.parse(pickedDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String time = (String) TimeSlot().getSelectedItem();
                    String notes = notesTextArea.getText();

                    int flag = 0;

                    for (Patient patient : patients) {
                        if (firstName.equalsIgnoreCase(patient.getName()) && lastName.equalsIgnoreCase(patient.getSurname())) {
                            flag = 1;
                            break;
                        }
                    }
                    int yesOrNo;
                    if (flag == 1) {
                        yesOrNo = JOptionPane.showConfirmDialog(background, "Consultation Fee :- £25\nDo you want to book the consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (yesOrNo == 0) {
                            String consultationFee = "£25";
                            Consultation consultation = new Consultation(doctorName, specialization, pickedDate1, time, notes, consultationFee);
                            Patient patient = new Patient(firstName, lastName, date, mobile);
                            patients.add(patient);
                            consultations.add(consultation);
                            JOptionPane.showMessageDialog(background, "Your consultation reserved Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        yesOrNo = JOptionPane.showConfirmDialog(background, "Consultation Fee :- £15\nDo you want to book the consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (yesOrNo == 0) {
                            String consultationFee = "£15";
                            Consultation consultation = new Consultation(doctorName, specialization, pickedDate1, time, notes, consultationFee);
                            Patient patient = new Patient(firstName, lastName, date, mobile);
                            patients.add(patient);
                            consultations.add(consultation);
                            JOptionPane.showMessageDialog(background, "Your consultation reserved Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    if (yesOrNo == 1) {
                        JOptionPane.showMessageDialog(background, "Cancelled!", "ALERT!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    SaveInFile();
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(background, "Please fill all the fields.", "ALERT!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return book;
    }

    private JComboBox TimeSlot() {
        ArrayList<String> doctors = new ArrayList<>();

        timeSlotBoxModel.addElement("-- Select --");
        timeSlotBoxModel.addElement("8 a.m. - 9 a.m.");
        timeSlotBoxModel.addElement("9 a.m. - 10 a.m.");
        timeSlotBoxModel.addElement("10 a.m. - 11 a.m.");
        timeSlotBoxModel.addElement("11 a.m. - 12 a.m.");
        timeSlotBoxModel.addElement("2 p.m. - 3 p.m.");
        timeSlotBoxModel.addElement("3 p.m. - 4 p.m.");
        timeSlotBoxModel.addElement("4 p.m. - 5 p.m.");
        timeSlotBoxModel.addElement("5 p.m. - 6 p.m.");

        jComboBoxForTime = new JComboBox(timeSlotBoxModel);
        jComboBoxForTime.setBounds(855, 300, 200, 40);
        jComboBoxForTime.setFont(new Font("Arial", Font.PLAIN, 15));
        jComboBoxForTime.addActionListener(ae -> {
            if (ae.getSource() == jComboBoxForTime) {
                if (!doctorAvailable()) {
                    var yesOrNo = JOptionPane.showConfirmDialog(background, "Doctor is not available in selected date and time.\nDo you want allocate another the doctor to this specific date and time?", "ALERT!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (yesOrNo == 0) {
                        docNames.removeAllElements();
                        for (Doctor doc : WestminsterSkinConsultationManager.doctorslist) {
                            String name = doc.getName() + " " + doc.getSurname();
                            if (doc.getSpecialization().equals(comboForSpecialization.getSelectedItem()) && !name.equalsIgnoreCase(nameOfTheDoctor)) {
                                for (Consultation consultation : consultations) {
                                    if (name.equalsIgnoreCase(consultation.getName()) && Objects.equals(comboForSpecialization.getSelectedItem(), consultation.getSpecialization())) {
                                        try {
                                            if (!(consultation.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()) && WestminsterSkinConsultationManager.dateOfBirth.parse(datelbl.getText()).equals(consultation.getDate()))) {
                                                doctors.add(name);
                                                break;
                                            }
                                        } catch (ParseException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else {
                                        doctors.add(name);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        for (String name :
                doctors) {
            for (Consultation consul :
                    consultations) {
                try {
                    if (!(name.equals(consul.getName()) && WestminsterSkinConsultationManager.dateOfBirth.parse(datelbl.getText()).equals(consul.getDate()) && consul.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()))){
                        docNames.addElement(name);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return jComboBoxForTime;
    }

    private boolean doctorAvailable() {
        for (Consultation consultation : consultations) {
            try {
                if (consultation.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()) && Objects.equals(comboBoxForDocName.getSelectedItem(), consultation.getDocName()) && Objects.equals(comboForSpecialization.getSelectedItem(), consultation.getSpecialization()) && WestminsterSkinConsultationManager.dateOfBirth.parse(datelbl.getText()).equals(consultation.getDate())) {
                    nameOfTheDoctor = (String) comboBoxForDocName.getSelectedItem();
                    return false;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }


    private JButton ListOfAppointments() {
        JButton listOfAppointment = new JButton("List of Appointments");
        listOfAppointment.setBounds(900, 500, 200, 35);
        listOfAppointment.setFont(new Font("MV Boli", Font.BOLD, 12));
        listOfAppointment.addActionListener(ae -> {
            if (ae.getSource() == listOfAppointment) {
                new AppointsGUI();
            }
        });
        return listOfAppointment;
    }

    private JButton ResetButton() {
        JButton reset = new JButton("Reset");
        reset.setBounds(1150, 500, 150, 35);
        reset.setFont(new Font("MV Boli", Font.BOLD, 12));
        reset.setForeground(Color.RED);
        reset.addActionListener(ae -> {
            if (ae.getSource() == reset) {
                Reset();
            }
        });
        return reset;
    }

    private void Reset() {
        String def = "";
        nameField.setText(def);
        surnameField.setText(def);
        mobileNumberField.setText(def);
        dOBlbl.setText(def);
        datelbl.setText(def);
        notesTextArea.setText(def);
        specializationBoxModel.removeAllElements();
        DoctorSpecialization();
        DoctorNames();
        timeSlotBoxModel.removeAllElements();
        TimeSlot();
        datelbl.setText(def);
        notesTextArea.setText(def);
    }
}

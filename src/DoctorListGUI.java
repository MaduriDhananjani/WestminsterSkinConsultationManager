import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorListGUI{
    private JButton backToHomeBtn;
    public JFrame background;

    DoctorListGUI(){
        //Code for the Frame
        background = new JFrame();
        background.setTitle("Westminster Skin Consultation Manager");
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close button
        background.setSize(1440, 800);
        background.setResizable(false);
        background.setLayout(null);
        background.setVisible(true);
        background.add(ScrollPane());

        backToHomeBtn = new JButton("Home");
        backToHomeBtn.setBounds(40,50,100,50);
        backToHomeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background.dispose();
                new SystemGUI();
            }
        });
        background.add(backToHomeBtn);// backtohomebtn ek ba

    }

    private JScrollPane ScrollPane(){
        final JScrollPane scrollPane;
        //Creating an object of custom table model class
        ListTableModel model = new ListTableModel(WestminsterSkinConsultationManager.doctorslist);

        //Defining the table
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.gray);
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Ariel", Font.TYPE1_FONT,13));
        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("Ariel", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.getTableHeader().setForeground(Color.BLUE);
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 120, 1300,583);
        return scrollPane;
    }
}

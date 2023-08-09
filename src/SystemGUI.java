import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SystemGUI{
    private final JButton button1;

    public SystemGUI(){
        JFrame background = new JFrame();
        background.setTitle("Westminster Skin Consultation Manager");
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background.setSize(1440, 800);
        background.setResizable(false);
        background.setLayout(null);
        background.setVisible(true);


        //Adding welcome letter to the JFrame
        JLabel heading = new JLabel("Skin Consultation Manager");
        heading.setBounds(370, 25, 1100,50);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Ariel", Font.BOLD,45));
        background.add(heading);

        //Adding buttons to the login page
        button1 = new JButton("Doctor Information");
        button1.setBounds(300,270,800,130);
        button1.setFont(new Font("Comic Sans", Font.ITALIC,25));
        button1.addActionListener(e -> {
            if (e.getSource() == button1){
                background.dispose();
                new DoctorListGUI();
            }
        });
                background.add(button1);

        //Adding second button to the frame
        JButton button2 = new JButton("Book a Consultation");
        button2.setBounds(300,450,800,130);
        button2.setFont(new Font("Comic Sans", Font.ITALIC,25));
        button2.addActionListener(e -> {
            background.dispose();
            new ConsultationGUI();
        });
                background.add(button2);
    }
}

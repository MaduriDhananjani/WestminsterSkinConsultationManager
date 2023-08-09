import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppointsGUI {
    public JFrame background;

    AppointsGUI(){ // method
        background = new JFrame();
        background.setTitle("Westminster Skin Consultation Manager");
        background.setSize(1300, 683); //window size
        background.setResizable(false);// size ek change krnn baha
        background.setLayout(null);//
        background.setVisible(true); // window eka penawad ndd
        background.add(Table());

    }


    private JScrollPane Table(){
        AppointsTableModel appointmentTableModel = new AppointsTableModel(ConsultationGUI.patients, ConsultationGUI.consultations);

        JTable table = new JTable(appointmentTableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(236,150,129));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Calibri", Font.PLAIN,13));

        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(150,50));
        table.getTableHeader().setForeground(new Color(1,6,65));
        table.setAutoCreateRowSorter(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(9).setPreferredWidth(170);
        //table.getColumnModel().getColumn(10).setPreferredWidth(60);

        JMenuItem add = new JMenuItem("Add new Consultation");
        JMenuItem delete = new JMenuItem("Delete selected Consultation");

        add.addActionListener(ae -> {
            new ConsultationGUI();
        });

        delete.addActionListener(ae -> {
            int row = table.getSelectedRow();
            if (row != -1){
                table.remove(row);

            }
        });
        JPopupMenu jPopupMenu = new JPopupMenu();
        jPopupMenu.add(add);
        jPopupMenu.add(new JSeparator());
        jPopupMenu.add(delete);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)){
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(60, 85, 1170, 500);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        return jScrollPane;
    }
}

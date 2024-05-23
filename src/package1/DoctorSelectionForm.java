package package1;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class DoctorSelectionForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorSelectionForm frame = new DoctorSelectionForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DoctorSelectionForm() {
        setTitle("Doctor Selection Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDoctorName = new JLabel("Doctor Name");
        lblDoctorName.setBounds(10, 25, 100, 14);
        contentPane.add(lblDoctorName);

        JComboBox<String> cbDoctorName = new JComboBox<>();
        cbDoctorName.setBounds(120, 22, 150, 22);
        contentPane.add(cbDoctorName);
        cbDoctorName.addItem("Sevda");
        cbDoctorName.addItem("Mert");
        cbDoctorName.addItem("Ali");

        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(10, 60, 100, 14);
        contentPane.add(lblDepartment);

        JComboBox<String> cbDepartment = new JComboBox<>();
        cbDepartment.setBounds(120, 57, 150, 22);
        contentPane.add(cbDepartment);
        cbDepartment.addItem("Cardiology");
        cbDepartment.addItem("Ophthalmology");
        cbDepartment.addItem("Psychiatry");

        JLabel lblTime = new JLabel("Select Time");
        lblTime.setBounds(10, 95, 100, 14);
        contentPane.add(lblTime);

        JComboBox<String> cbTime = new JComboBox<>();
        cbTime.setBounds(120, 92, 150, 22);
        contentPane.add(cbTime);
        cbTime.addItem("8:00");
        cbTime.addItem("8:30");
        cbTime.addItem("9:00");
        cbTime.addItem("9:30");
        cbTime.addItem("10:00");

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String doctorName = cbDoctorName.getSelectedItem().toString();
                String department = cbDepartment.getSelectedItem().toString();
                String time = cbTime.getSelectedItem().toString();
                
                // Burada seçilen doktor adı, departmanı ve saati kaydedebilir veya kullanabilirsiniz.
                System.out.println("Selected Doctor: " + doctorName);
                System.out.println("Selected Department: " + department);
                System.out.println("Selected Time: " + time);

                // Kayıt başarılı mesajı
                JOptionPane.showMessageDialog(contentPane, "Save successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnSave.setBounds(120, 150, 150, 23);
        contentPane.add(btnSave);

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openHospitalForm();
            }
        });
        btnBack.setBounds(120, 190, 150, 23);
        contentPane.add(btnBack);
    }

    private void openHospitalForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalForm hospitalForm = new HospitalForm();
                    hospitalForm.setVisible(true);
                    dispose(); // Mevcut formu kapat
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

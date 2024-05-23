package package1;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtDepartment;
    private JTable table;
    HospitalDb hospitalDb = new HospitalDb();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalForm frame = new HospitalForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HospitalForm() throws SQLException {
        setTitle("Hospital Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Hospital ID");
        lblNewLabel.setBounds(10, 25, 70, 14);
        contentPane.add(lblNewLabel);
        
        txtId = new JTextField();
        txtId.setBounds(90, 22, 32, 20);
        contentPane.add(txtId);
        txtId.setColumns(10);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 53, 80, 14);
        contentPane.add(lblName);
        
        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(90, 50, 86, 20);
        contentPane.add(txtName);
        
        JLabel lblDepartment = new JLabel("Surname");
        lblDepartment.setBounds(10, 82, 71, 14);
        contentPane.add(lblDepartment);
        
        txtDepartment = new JTextField();
        txtDepartment.setColumns(10);
        txtDepartment.setBounds(90, 79, 86, 20);
        contentPane.add(txtDepartment);
        
        JLabel lblLocation = new JLabel("Gender");
        lblLocation.setBounds(10, 116, 71, 14);
        contentPane.add(lblLocation);
        
        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(90, 112, 109, 23);
        contentPane.add(rdbtnFemale);
        rdbtnFemale.setActionCommand("Female");
        
        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(90, 137, 109, 23);
        contentPane.add(rdbtnMale);
        rdbtnMale.setActionCommand("Male");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rdbtnFemale);
        genderGroup.add(rdbtnMale);
        
        JLabel lblCategory = new JLabel("Department");
        lblCategory.setBounds(10, 171, 71, 14);
        contentPane.add(lblCategory);
        
        JComboBox<String> cbCategory = new JComboBox<>();
        cbCategory.setBounds(90, 167, 84, 22);
        contentPane.add(cbCategory);
        cbCategory.addItem("Cardiology");
        cbCategory.addItem("Ophthalmology");
        cbCategory.addItem("Psychiatry");
        
       
        
        JLabel lblNewLabel_1 = new JLabel("Patient Registration List");
        lblNewLabel_1.setBounds(207, 25, 150, 14);
        contentPane.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(207, 53, 300, 126);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Hospital h = new Hospital();
                h.sethId(Integer.parseInt(txtId.getText()));
                h.setName(txtName.getText());
                h.setDepartment(txtDepartment.getText());
                h.setLocation(genderGroup.getSelection().getActionCommand());
                h.setCategory(cbCategory.getSelectedItem().toString());
                
                
                try {
                    hospitalDb.saveHospital(h);
                    refreshHospitalTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnSave.setBounds(190, 200, 120, 23);
        contentPane.add(btnSave);

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openHospitalLoginForm();
            }
        });
        btnBack.setBounds(320, 200, 120, 23);
        contentPane.add(btnBack);
        
        JButton btnMoreInfo = new JButton("MORE INFORMATION");
        btnMoreInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDoctorSelectionForm();
            }
        });
        btnMoreInfo.setBounds(227, 243, 180, 25);
        contentPane.add(btnMoreInfo);

        refreshHospitalTable(); // Tabloyu başlangıçta güncelleyelim
    }

    private void refreshHospitalTable() {
        try {
            ResultSet temp_rs = hospitalDb.getHospitals();
            int columnNumber = temp_rs.getMetaData().getColumnCount();
            String columnNames[] = new String[columnNumber];
            
            for (int i = 0; i < columnNumber; i++) {
                columnNames[i] = temp_rs.getMetaData().getColumnName(i+1);
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            
            table.setModel(model);
            
            while(temp_rs.next()) {
                Object array[] = new Object[columnNumber];
                for (int i = 0; i < array.length; i++) {
                    array[i] = temp_rs.getObject(i+1);
                }
                model.addRow(array);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openHospitalLoginForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalLoginForm loginForm = new HospitalLoginForm();
                    loginForm.setVisible(true);
                    dispose(); // Mevcut formu kapat
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void openDoctorSelectionForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorSelectionForm doctorSelectionForm = new DoctorSelectionForm();
                    doctorSelectionForm.setVisible(true);
                    dispose(); // Mevcut formu kapat
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}




























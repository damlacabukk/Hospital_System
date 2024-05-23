package package1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalLoginForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalLoginForm frame = new HospitalLoginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HospitalLoginForm() {
        setTitle("Hospital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); 
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLUE); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLUE);
        contentPane.add(mainPanel, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        buttonPanel.setBackground(Color.BLUE);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        
        JLabel titleLabel = new JLabel("CABUK HOSPITAL");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(titleLabel);

       
        JButton btnHospitalForm = new JButton("MAKE AN APPOINTMENT");
        btnHospitalForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openHospitalForm();
            }
        });
        btnHospitalForm.setBackground(Color.WHITE);
        buttonPanel.add(btnHospitalForm);

        
        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBackground(Color.WHITE); 
        buttonPanel.add(btnExit);

        setLocationRelativeTo(null); 
    }

    private void openHospitalForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalForm hospitalForm = new HospitalForm();
                    hospitalForm.setVisible(true);
                    dispose(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckNameAndTrackNum extends JFrame implements ActionListener {
    private JPanel pnlTop, pnlMain;
    private JLabel lblAlibaba, lblParcelID, lblCustomerName, lblStatus;
    private JTextField txtParcelID, txtCustomerName;
    private JButton btnTrack;
    public CheckNameAndTrackNum() {
        // Create frame
        JFrame frame = new JFrame("Parcel Collection Application");
        frame.setSize(600, 500); // Set initial size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create top panel
        pnlTop = new JPanel();
        pnlTop.setBackground(new Color(72, 61, 139)); // Dark slate blue
        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Create Alibaba label with custom styling
        lblAlibaba = new JLabel("Tanjung Parcel Collection");
        lblAlibaba.setFont(new Font("Arial", Font.BOLD, 24));
        lblAlibaba.setForeground(Color.WHITE); // Set text color to white
        pnlTop.add(lblAlibaba);

        // Add top panel to the frame's NORTH position
        frame.add(pnlTop, BorderLayout.NORTH);

        // Create main panel for center content
        pnlMain = new JPanel();
        pnlMain.setLayout(null); // Use null layout for absolute positioning
        pnlMain.setBackground(new Color(230, 230, 250)); // Light lavender background
        frame.add(pnlMain, BorderLayout.CENTER); // Add main panel to the center of the frame

        // Create components with adjusted styling
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        lblParcelID = new JLabel("Enter parcel ID:");
        lblParcelID.setFont(labelFont);
        lblParcelID.setBounds(150, 40, 200, 25); // Center horizontally

        txtParcelID = new JTextField();
        txtParcelID.setFont(labelFont);
        txtParcelID.setBounds(150, 70, 200, 25);

        lblCustomerName = new JLabel("Enter customer name:");
        lblCustomerName.setFont(labelFont);
        lblCustomerName.setBounds(150, 100, 200, 25); // Center horizontally

        txtCustomerName = new JTextField();
        txtCustomerName.setFont(labelFont);
        txtCustomerName.setBounds(150, 130, 200, 25);

        btnTrack = new JButton("Track parcel");
        btnTrack.setFont(buttonFont);
        btnTrack.setBackground(new Color(100, 149, 237)); // Cornflower blue
        btnTrack.setBackground(Color.RED);
        btnTrack.setForeground(Color.WHITE);
        btnTrack.setBounds(150, 160, 200, 25); // Adjusted size to match receiver's name input field

        lblStatus = new JLabel("Status:");
        lblStatus.setFont(labelFont);
        lblStatus.setBounds(150, 220, 350, 25); // Position below delivered checkbox

        // Add components to main panel
        pnlMain.add(lblParcelID);
        pnlMain.add(txtParcelID);
        pnlMain.add(lblCustomerName);
        pnlMain.add(txtCustomerName);
        pnlMain.add(btnTrack);
        pnlMain.add(lblStatus);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);

        btnTrack.addActionListener(this);

        // Show frame
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTrack) {

        }
    }

}

// Method to validate receiver's name (only letters and spaces allowed)
//    private static boolean isValidReceiverName(String name) {
//        return name.matches("[a-zA-Z ]+");
//    }
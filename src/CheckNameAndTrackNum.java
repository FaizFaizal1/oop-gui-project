import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckNameAndTrackNum extends JFrame implements ActionListener {
    private JPanel pnlTop, pnlMain;
    private JLabel lblStoreName, lblParcelIDOrCName;
    private JTextField txtParcelIDOrCName;
    private JButton btnCheckParcelID;
    private JRadioButton rbParcelID, rbCustomerName;
    public CheckNameAndTrackNum() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,500);
        super.setTitle("Parcel Collection Application");

        Container cp = super.getContentPane();
        cp.setLayout(new BorderLayout());

        // Create top panel
        pnlTop = new JPanel();
        pnlTop.setBackground(new Color(72, 61, 139)); // Dark slate blue
        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Create store name label with custom styling
        lblStoreName = new JLabel("Tanjung Parcel Collection");
        lblStoreName.setFont(new Font("Arial", Font.BOLD, 24));
        lblStoreName.setForeground(Color.WHITE); // Set text color to white
        pnlTop.add(lblStoreName);

        // Add pnlTop to north of content pane
        cp.add(pnlTop, BorderLayout.NORTH);

        // Create main panel for center content
        pnlMain = new JPanel();
        pnlMain.setLayout(null); // Use null layout for absolute positioning
        pnlMain.setBackground(new Color(230, 230, 250)); // Light lavender background

        // Add pnlMain to center of content pane
        cp.add(pnlMain, BorderLayout.CENTER);

        // Create components with adjusted styling
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        lblParcelIDOrCName = new JLabel("Enter parcel ID or customer name:");
        lblParcelIDOrCName.setFont(labelFont);
        lblParcelIDOrCName.setBounds(150, 40, 200, 25); // Center horizontally

        txtParcelIDOrCName = new JTextField();
        txtParcelIDOrCName.setFont(labelFont);
        txtParcelIDOrCName.setBounds(150, 70, 200, 25);

        rbParcelID = new JRadioButton("Parcel ID");
        rbParcelID.setBounds(375, 70, 100, 25); // Adjusted size to match receiver's name input field

        rbCustomerName = new JRadioButton("Customer name");
        rbCustomerName.setBounds(400, 70, 100, 25); // Adjusted size to match receiver's name input field

        btnCheckParcelID = new JButton("Track");
        btnCheckParcelID.setFont(buttonFont);
        btnCheckParcelID.setBackground(new Color(100, 149, 237)); // Cornflower blue
        btnCheckParcelID.setBackground(Color.RED);
        btnCheckParcelID.setForeground(Color.WHITE);
        btnCheckParcelID.setBounds(350, 100, 100, 25); // Adjusted size to match receiver's name input field

        // Add components to main panel
        pnlMain.add(lblParcelIDOrCName);
        pnlMain.add(txtParcelIDOrCName);
        pnlMain.add(rbParcelID);
        pnlMain.add(rbCustomerName);
        pnlMain.add(btnCheckParcelID);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - super.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - super.getHeight()) / 2);
        super.setLocation(centerX, centerY);

        // Register elements
        btnCheckParcelID.addActionListener(this);

        // Show frame
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DBHelper db = new DBHelper();
        ArrayList<Customer> customers = db.getAllCustomers();
        ArrayList<String> parcelIDs = new ArrayList<String>();
        ArrayList<String> customerNames = new ArrayList<String>();
        for (Customer customer : customers) {
            parcelIDs.add(customer.getParcelID());
            customerNames.add(customer.getCustomerName());
        }

        if (e.getSource() == btnCheckParcelID) {
            if (parcelIDs.contains(txtParcelIDOrCName.getText())) {
                JOptionPane.showMessageDialog(this,"Your parcel arrived at Tanjung!");
                new Pickup();
                super.dispose();
            } else {
                JOptionPane.showMessageDialog(this,"No parcel with that ID");
            }
//        } else if (e.getSource() == btnCheckCustomerName) {
//            if (customerNames.contains(txtCustomerName.getText())) {
//                JOptionPane.showMessageDialog(this,"Your parcel arrived at Tanjung!");
//                new Pickup();
//                super.dispose();
//            } else {
//                JOptionPane.showMessageDialog(this,"No parcel with that name");
//            }
        }
    }

    public static void main(String[] args) {
        new CheckNameAndTrackNum();
    }
}
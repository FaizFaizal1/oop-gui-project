import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class CheckNameAndParcelID extends JFrame implements ActionListener {
    private JLabel lblStoreName, lblTitle;
    private JTextField txtParcelDetail;
    private JButton btnCheckParcelDetail;
    private JRadioButton rbParcelID, rbCustomerName;
    private ButtonGroup bgParcelInfo;
    private static String orderID;
    public CheckNameAndParcelID() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,300);
        super.setTitle("Parcel Collection Application");

        Container cp = super.getContentPane();
        cp.setLayout(new BorderLayout());

        // Create top panel
        JPanel pnlTop = new JPanel();
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
        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null); // Use null layout for absolute positioning
        pnlMain.setBackground(new Color(230, 230, 250)); // Light lavender background

        // Add pnmMain to center of content pane

        // Create components with adjusted styling
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        lblTitle = new JLabel("Check your parcel");
        lblTitle.setFont(labelFont);
        lblTitle.setBounds(150, 40, 275, 25); // Center horizontally

        txtParcelDetail = new JTextField();
        txtParcelDetail.setFont(labelFont);
        txtParcelDetail.setBounds(150, 70, 200, 25);


        rbParcelID = new JRadioButton("Parcel ID");
        rbParcelID.setBounds(350, 70, 90, 25); // Center horizontally
        rbParcelID.setBackground(new Color(230, 230, 250)); // Light lavender background

        rbCustomerName = new JRadioButton("Customer name");
        rbCustomerName.setBounds(440, 70, 125, 25); // Center horizontally
        rbCustomerName.setBackground(new Color(230, 230, 250)); // Light lavender background

        bgParcelInfo = new ButtonGroup();
        bgParcelInfo.add(rbParcelID);
        bgParcelInfo.add(rbCustomerName);

        btnCheckParcelDetail = new JButton("Track");
        btnCheckParcelDetail.setFont(buttonFont);
        btnCheckParcelDetail.setBackground(new Color(100, 149, 237)); // Cornflower blue
        btnCheckParcelDetail.setBackground(Color.RED);
        btnCheckParcelDetail.setForeground(Color.WHITE);
        btnCheckParcelDetail.setBounds(150, 100, 100, 25);
        
        // Add components to main panel
        pnlMain.add(lblTitle);
        pnlMain.add(txtParcelDetail);
        pnlMain.add(rbParcelID);
        pnlMain.add(rbCustomerName);
        pnlMain.add(btnCheckParcelDetail);

        cp.add(pnlMain, BorderLayout.CENTER);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - super.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - super.getHeight()) / 2);
        super.setLocation(centerX, centerY);

        // Register elements
        btnCheckParcelDetail.addActionListener(this);

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

        if (e.getSource() == btnCheckParcelDetail) {
            if (rbParcelID.isSelected()) {
                if (parcelIDs.contains(txtParcelDetail.getText())) {
                    JOptionPane.showMessageDialog(this,"Your parcel arrived at Tanjung!");

                    for (int i=0; i < parcelIDs.size(); i++) {
                        if (parcelIDs.get(i).equals(txtParcelDetail.getText())) {
                            orderID = Integer.toString(customers.get(i).getCustomerId());
                            break;
                        }
                    }

                    new Pickup();
                    super.dispose();
                } else {
                    JOptionPane.showMessageDialog(this,"No parcel with that ID");
                }
            } else {
                if (customerNames.contains(txtParcelDetail.getText())) {
                    JOptionPane.showMessageDialog(this,"Your parcel arrived at Tanjung!");

                    for (int i=0; i < parcelIDs.size(); i++) {
                        if (customerNames.get(i).equals(txtParcelDetail.getText())) {
                            orderID = Integer.toString(customers.get(i).getCustomerId());
                            break;
                        }
                    }

                    new Pickup();
                    super.dispose();
                } else {
                    JOptionPane.showMessageDialog(this,"No parcel with that name");
                }
            }

        }
    }

    public static String getOrderID() {
        return orderID;
    }

    public static void main(String[] args) {
        new CheckNameAndParcelID();
    }
}
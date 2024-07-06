import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class checkNewLayout extends JFrame {
    private JLabel lblStoreName, lblParcelIDOrCName;
    private JTextField txtParcelIDOrCName;
    private JButton btnCheckParcel;
    private JRadioButton rbParcelID, rbCustomerName;
    private ButtonGroup bgInfoType;

    public checkNewLayout() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,500);
        super.setTitle("Parcel Collection Application");

        Container cp = super.getContentPane();
        cp.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////////////////////////////

        // Design north region
        JPanel pnlTop = new JPanel();
        pnlTop.setBackground(new Color(72, 61, 139)); // Dark slate blue
        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Design store name label with custom styling
        lblStoreName = new JLabel("Tanjung Parcel Collection");
        lblStoreName.setFont(new Font("Arial", Font.BOLD, 24));
        lblStoreName.setForeground(Color.WHITE); // Set text color to white
        pnlTop.add(lblStoreName);

        cp.add(pnlTop, BorderLayout.NORTH);

        //////////////////////////////////////////////////////////////////////////////

        // Design center region
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(3,1));
        pnlCenter.setBackground(new Color(230, 230, 250)); // Light lavender background
//        pnlCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Design center for the first row
        JPanel pnlLabel = new JPanel();
        pnlLabel.setLayout(new FlowLayout());
        pnlLabel.setBackground(new Color(230, 230, 250));

        // Create components with adjusted styling
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        lblParcelIDOrCName = new JLabel("Check if parcel arrived at Tanjung");
        lblParcelIDOrCName.setFont(labelFont);
        pnlLabel.add(lblParcelIDOrCName);

        pnlCenter.add(pnlLabel);

        // Design center for second row
        JPanel pnlInput = new JPanel();
        pnlInput.setLayout(new FlowLayout());
        pnlInput.setBackground(new Color(230, 230, 250));

        txtParcelIDOrCName = new JTextField();
        txtParcelIDOrCName.setText("Enter parcel ID or customer name");
        txtParcelIDOrCName.setSize(50,50);
        rbCustomerName = new JRadioButton("Customer name");
        rbCustomerName.setBackground(new Color(230, 230, 250));
        rbParcelID = new JRadioButton("Parcel ID");
        rbParcelID.setBackground(new Color(230, 230, 250));


        // group the radio buttons
        bgInfoType = new ButtonGroup();
        bgInfoType.add(rbCustomerName);
        bgInfoType.add(rbParcelID);

        pnlInput.add(txtParcelIDOrCName);
        pnlInput.add(rbCustomerName);
        pnlInput.add(rbParcelID);

        pnlCenter.add(pnlInput);

        // Design center for third row
        btnCheckParcel = new JButton();
        btnCheckParcel.setBackground(new Color(100, 149, 237)); // Cornflower blue);
        pnlCenter.add(btnCheckParcel);

        cp.add(pnlCenter, BorderLayout.CENTER);
        // end design center
        //////////////////////////////////////////////////////////////////////////////

//        // Create main panel for center content
//        pnlMain = new JPanel();
//        pnlMain.setLayout(new FlowLayout((FlowLayout.CENTER), 20, 20));
//        pnlMain.setBackground(new Color(230, 230, 250)); // Light lavender background
//
//        // Add pnlMain to center of content pane
//        cp.add(pnlMain, BorderLayout.CENTER);


        // Add components to main panel
//        pnlMain.add(lblParcelIDOrCName);
//        pnlMain.add(txtParcelIDOrCName);
//        pnlMain.add(rbParcelID);
//        pnlMain.add(rbCustomerName);
//        pnlMain.add(btnCheckParcelID);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new checkNewLayout();
    }
}

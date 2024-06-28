import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class UICheck extends JFrame {
    private JLabel titleLabel, lblParcelID, lblName;
    private JTextField txtParcelTrackingNumber, txtName;
    private JButton btnTrack;
    
    public UICheck() {
        super.setTitle("Parcel Collection Application");
        super.setSize(600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout(10, 10)); // Main layout

            // Create title label
            titleLabel = new JLabel("Alibaba", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

            // Create panels
            JPanel inputPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // GridLayout for input rows
            JPanel textFieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); // FlowLayout for text fields
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pickupButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            // Create components
            lblParcelID = new JLabel("Enter Parcel ID:");
            txtParcelTrackingNumber = new JTextField(10); // Smaller text field
            JLabel labelReceiverName = new JLabel("Receiver's Name:");
            txtName = new JTextField(10); // Smaller text field
            JButton buttonTrack = new JButton("Track Parcel");
            buttonTrack.setPreferredSize(new Dimension(120, 25)); // Adjust button size

            JCheckBox checkBoxDelivered = new JCheckBox("Delivered");
            JButton buttonPickup = new JButton("Pickup");
            buttonPickup.setVisible(false); // Hide pickup button initially

//            JLabel labelStatus = new JLabel("Status: ");
//            JLabel imageLabel = new JLabel();

            // Add components to textFieldsPanel
            textFieldsPanel.add(lblParcelID);
            textFieldsPanel.add(txtParcelTrackingNumber);
            textFieldsPanel.add(labelReceiverName);
            textFieldsPanel.add(txtName);

            // Add components to buttonPanel
            buttonPanel.add(buttonTrack);
            buttonPanel.add(checkBoxDelivered);

            // Add components to inputPanel
            inputPanel.add(textFieldsPanel);
            inputPanel.add(buttonPanel);

            // Add components to other panels
//            statusPanel.add(labelStatus);
//            imagePanel.add(imageLabel);
            pickupButtonPanel.add(buttonPickup);

            // Add components to frame
            super.add(titleLabel, BorderLayout.NORTH); // Title at the top
            super.add(inputPanel, BorderLayout.CENTER);
            super.add(statusPanel, BorderLayout.SOUTH);
            super.add(imagePanel, BorderLayout.EAST);
            super.add(pickupButtonPanel, BorderLayout.WEST);

//            // Load images
//            ImageIcon vanIcon = new ImageIcon("van.jpg");
//            ImageIcon humanIcon = new ImageIcon("delivered.jpg");
//
//            // Check if images are loaded correctly
//            if (vanIcon.getIconWidth() == -1) {
//                System.out.println("Van image not found");
//            }
//            if (humanIcon.getIconWidth() == -1) {
//                System.out.println("Human image not found");
//            }

            // Add action listener to the button
            buttonTrack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String parcelID = txtParcelTrackingNumber.getText();
                    String receiverName = txtName.getText();
                }
            });

            // Add action listener to the pickup button
            buttonPickup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame pickupFrame = new JFrame("Pickup Details");
                    pickupFrame.setSize(300, 200);
                    pickupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    pickupFrame.setLayout(new FlowLayout());

                    JLabel pickupLabel = new JLabel("Parcel has been picked up by " + txtName.getText());
                    pickupFrame.add(pickupLabel);

                    pickupFrame.setVisible(true);
                }
            });

        // Set frame visibility
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new UICheck();
    }
}


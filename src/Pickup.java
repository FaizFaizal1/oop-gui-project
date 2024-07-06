import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Pickup extends JFrame implements ActionListener {
    private JLabel photoLabel, titleLabel, parcelQuestionLabel;
    private String uploadedPhotoPath;
    private JButton btnYes, btnNo, btnUpload, btnGenerateOrderId;

    public Pickup() {
        super.setTitle("Parcel Delivery System");
        super.setSize(600, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        Container cp = super.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.setBackground(new Color(230, 230, 250));

        JPanel pnlTop = new JPanel();
        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pnlTop.setBackground(new Color(72, 61, 139));  // Dark slate blue

        titleLabel = new JLabel("Parcel Delivery System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pnlTop.add(titleLabel);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(6, 1, 10, 10));
        pnlCenter.setBackground(new Color(230, 230, 250));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        parcelQuestionLabel = new JLabel("Do you want to pick up a parcel?");
        parcelQuestionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        btnYes = new JButton("Yes");
        btnYes.setBackground(new Color(100, 149, 237));  // Cornflower blue
        btnYes.setForeground(Color.WHITE);
        btnYes.setFont(new Font("Arial", Font.PLAIN, 16));

        btnNo = new JButton("No");
        btnNo.setBackground(new Color(255, 69, 0));  // Red
        btnNo.setForeground(Color.WHITE);
        btnNo.setFont(new Font("Arial", Font.PLAIN, 16));

        btnUpload = new JButton("Upload Photo");
        btnUpload.setBackground(new Color(100, 149, 237));
        btnUpload.setForeground(Color.WHITE);
        btnUpload.setFont(new Font("Arial", Font.PLAIN, 16));
        btnUpload.setVisible(false);

        photoLabel = new JLabel("No photo uploaded");
        photoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        photoLabel.setVisible(false);

        btnGenerateOrderId = new JButton("Generate Order ID");
        btnGenerateOrderId.setBackground(new Color(100, 149, 237));
        btnGenerateOrderId.setForeground(Color.WHITE);
        btnGenerateOrderId.setFont(new Font("Arial", Font.PLAIN, 16));
        btnGenerateOrderId.setEnabled(false);
        btnGenerateOrderId.setVisible(false);

        pnlCenter.add(parcelQuestionLabel);
        pnlCenter.add(btnYes);
        pnlCenter.add(btnNo);
        pnlCenter.add(btnUpload);
        pnlCenter.add(photoLabel);
        pnlCenter.add(btnGenerateOrderId);

        cp.add(pnlTop, BorderLayout.NORTH);
        cp.add(pnlCenter, BorderLayout.CENTER);
        
        // Register elements
        btnYes.addActionListener(this);
        btnNo.addActionListener(this);
        btnUpload.addActionListener(this);
        btnGenerateOrderId.addActionListener(this);
        
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnYes) {
            btnYes.setVisible(false);
            btnNo.setVisible(false);
            btnUpload.setVisible(true);
            photoLabel.setVisible(true);
            btnGenerateOrderId.setVisible(true);

        } else if (e.getSource() == btnNo) {
            dispose();  // Close the window

        } else if (e.getSource() == btnUpload) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                uploadedPhotoPath = selectedFile.getAbsolutePath();
                photoLabel.setText("Uploaded: " + selectedFile.getName());
                btnGenerateOrderId.setEnabled(true);
            }

            new ImageGenerator(uploadedPhotoPath);

        } else if (e.getSource() == btnGenerateOrderId) {
            DBHelper db = new DBHelper();
            ArrayList<Customer> customers = db.getAllCustomers();
            ArrayList<String> parcelIDs = new ArrayList<String>();

            for(Customer customer : customers) {
                parcelIDs.add(customer.getParcelID());
            }

            if (uploadedPhotoPath != null && !uploadedPhotoPath.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Your order ID is: " + CheckNameAndParcelID.getOrderID());
            } else {
                JOptionPane.showMessageDialog(null, "Please upload a photo first.");
            }
        }
    }
    public static void main(String[] args) {
        new Pickup();
    }
}
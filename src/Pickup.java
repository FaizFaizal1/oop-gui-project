import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Pickup extends JFrame {
    private JLabel photoLabel;
    private String uploadedPhotoPath;
    private JButton yesButton;
    private JButton noButton;
    private JButton uploadButton;
    private JButton generateOrderIdButton;

    public Pickup() {
        setTitle("Parcel Delivery System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(230, 230, 250));  // Light lavender background

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.setBackground(new Color(72, 61, 139));  // Dark slate blue

        JLabel titleLabel = new JLabel("Parcel Delivery System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 1, 10, 10));
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel parcelQuestionLabel = new JLabel("Do you want to pick up a parcel?");
        parcelQuestionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        yesButton = new JButton("Yes");
        yesButton.setBackground(new Color(100, 149, 237));  // Cornflower blue
        yesButton.setForeground(Color.WHITE);
        yesButton.setFont(new Font("Arial", Font.PLAIN, 16));
        yesButton.addActionListener(new YesButtonListener());

        noButton = new JButton("No");
        noButton.setBackground(new Color(255, 69, 0));  // Red
        noButton.setForeground(Color.WHITE);
        noButton.setFont(new Font("Arial", Font.PLAIN, 16));
        noButton.addActionListener(new NoButtonListener());

        uploadButton = new JButton("Upload Photo");
        uploadButton.setBackground(new Color(100, 149, 237));
        uploadButton.setForeground(Color.WHITE);
        uploadButton.setFont(new Font("Arial", Font.PLAIN, 16));
        uploadButton.addActionListener(new UploadButtonListener());
        uploadButton.setVisible(false);

        photoLabel = new JLabel("No photo uploaded");
        photoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        photoLabel.setVisible(false);

        generateOrderIdButton = new JButton("Generate Order ID");
        generateOrderIdButton.setBackground(new Color(100, 149, 237));
        generateOrderIdButton.setForeground(Color.WHITE);
        generateOrderIdButton.setFont(new Font("Arial", Font.PLAIN, 16));
        generateOrderIdButton.addActionListener(new GenerateOrderIdButtonListener());
        generateOrderIdButton.setEnabled(false);
        generateOrderIdButton.setVisible(false);

        centerPanel.add(parcelQuestionLabel);
        centerPanel.add(yesButton);
        centerPanel.add(noButton);
        centerPanel.add(uploadButton);
        centerPanel.add(photoLabel);
        centerPanel.add(generateOrderIdButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private class YesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            yesButton.setVisible(false);
            noButton.setVisible(false);
            uploadButton.setVisible(true);
            photoLabel.setVisible(true);
            generateOrderIdButton.setVisible(true);
        }
    }

    private class NoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();  // Close the window
        }
    }

    private class UploadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                uploadedPhotoPath = selectedFile.getAbsolutePath();
                photoLabel.setText("Uploaded: " + selectedFile.getName());
                generateOrderIdButton.setEnabled(true);
            }
        }
    }

    private class GenerateOrderIdButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (uploadedPhotoPath != null && !uploadedPhotoPath.isEmpty()) {
                String orderId = generateOrderId();
                JOptionPane.showMessageDialog(null, "Your order ID is: " + orderId);
            } else {
                JOptionPane.showMessageDialog(null, "Please upload a photo first.");
            }
        }

        private String generateOrderId() {
            // Simulate generating an order ID
            return "ORD" + System.currentTimeMillis();
        }
    }
}
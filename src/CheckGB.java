import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckGB extends JFrame implements ActionListener {
    private JPanel pnlTop, pnlMain;
    private JLabel lblStoreName, lblParcelIDOrCName;
    private JTextField txtParcelIDOrCName;
    private JButton btnCheckParcelID;
    private JRadioButton rbParcelID, rbCustomerName;
    public CheckGB() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,500);
        super.setTitle("Parcel Collection Application");

        Container cp = super.getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ///////////////////////////////////////////////////////////////////////////////////////
        // Design first row
        JPanel pnlFirst = new JPanel();
        pnlFirst.setBackground(new Color(72, 61, 139)); // Dark slate blue
//        pnlFirst.setLayout(new GridLayout());
        lblStoreName = new JLabel("Tanjung Parcel Collection");
        lblStoreName.setFont(new Font("Arial", Font.BOLD, 24));
        lblStoreName.setForeground(Color.WHITE);

        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
        btnCheckParcelID = new JButton();
        cp.add(btnCheckParcelID, c);

        // End first row
        ///////////////////////////////////////////////////////////////////////////////////////
        // Design second row

//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridx = 1;
//        c.gridy = 0;
//        JButton btnTest;
//        btnTest = new JButton();
//        cp.add(btnTest, c);


//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 0;
//        c.gridy = 0;
//        cp.add(lblStoreName, c);

        // End first row
        ///////////////////////////////////////////////////////////////////////////////////////






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
        new CheckGB();
    }
}
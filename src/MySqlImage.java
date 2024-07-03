import javax.swing.*;
import java.awt.*;
public class MySqlImage extends JFrame {
    public MySqlImage(String imagePath) {
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Uploaded Image");
        super.setSize(600, 500);
        super.setLocationRelativeTo(null);
        Container cp = super.getContentPane();

        JPanel panel;
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();

                if (image != null) {
                    int x = (getWidth() - image.getWidth(null)) / 2;
                    int y = (getHeight() - image.getHeight(null)) / 2;
                    g.drawImage(image, x, y, this);
                } else {
                    System.out.println("No image found");
                }
            }
        };

        cp.add(panel);

        super.setVisible(true);
    }

    public static void main(String[] args) {
        new MySqlImage("C:\\Users\\wmfbw\\OneDrive\\Documents\\1.jpg");

    }
}
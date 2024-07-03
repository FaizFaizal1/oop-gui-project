import javax.swing.*;
//import org.apache.commons.codec.binary.Base64;
//import java.util.Base64;
import java.awt.*;


public class MySqlImage extends JFrame {

    public MySqlImage(String imagePath) {
        JPanel panel = new JPanel() {
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

        this.getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MySqlImage("C:\\Users\\wmfbw\\Downloads\\dataset\\Chairs, Stools or Benches\\1.jpg");

    }
}
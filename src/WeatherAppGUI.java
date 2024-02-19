import javax.swing.*;
import java.awt.Font;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.io.File;


public class WeatherAppGUI extends JFrame {
    public WeatherAppGUI() {
        // setup the GUI and title
        super("Weather App");

        // When window is closed, programm will end itself
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set size of the window
        setSize(450, 650);

        // set the default location of the window on screen
        setLocationRelativeTo(null);

        // make layout manager to null to manually position the objects in the GUI
        setLayout(null);

        // prevent resizing the window
        setResizable(false);

        addGUI_Components();
    }

    private void addGUI_Components() {
        // search field for weather
        JTextField searchTextField = new JTextField();

        // set the location of the search field
        searchTextField.setBounds(15, 15, 351, 41);

        // change font and style
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        // search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);
    }

    // create images in our GUI window
    private ImageIcon loadImage(String resource_path) {
        try {
            BufferedImage image = ImageIO.read(new File(resource_path));

            return new ImageIcon(image);
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Could not find resource!");
        return null;
    }
}
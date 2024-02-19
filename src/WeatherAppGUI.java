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

        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        
        // center the temperature text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // weather description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        // humidty text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        // windspeed image
        JLabel windSpeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windSpeedImage.setBounds(220, 500, 74, 66);
        add(windSpeedImage);

        // windspeed text
        JLabel windSpeedText = new JLabel("<html><b>WindSpeed</b> 15km/h</html>");
        windSpeedText.setBounds(310, 500, 85, 55);
        windSpeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windSpeedText);

        
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
import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // display the weaterapp GUI
                new WeatherAppGUI().setVisible(true);
            }
        });
    }
}

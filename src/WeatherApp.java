import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// retrieve weather data from API 
// backend will return the latest weather data 
// to the frontend GUI for the user

public class WeatherApp {
    // fetch weather data for location
    public static JSONObject getWeatherData(String location) {
        // get location coordinates from the geolocation 
        JSONArray locationData = getLocationData(locationName);

    }

    // retrieve geographic coordinates 
    private static JSONArray getLocationData(String locationName) {
        // replace any whitespace with a + sign to fetch from API
        locationName = locationName.replaceAll(" ", "+");

        // build API URL with location parameter
        String urlstring = "https://geocoding-api.open-meteo.com/v1/search?name=" +
        locationName + "&count=10&language=en&format=json";

        try {
            // call API and get data as a JSon object
            HttpURLConnection connection = fetchAPIResponse(urlstring);

            if (connection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            } else {
                // store the API results
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(connection.getInputStream());

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private static HttpURLConnection fetchAPIResponse(String urlString) {
        try {
            // try to open a connection
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set request method to get data from the API
            connection.setRequestMethod("GET");

            // connect to the API 
            connection.connect();
            return connection;
        } catch(IOException e) {
            e.printStackTrace();
        } 

        // could not make a connection
        return null;
    }
}

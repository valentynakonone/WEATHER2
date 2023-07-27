package ZAMIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.parser.ParseException;

public class OpenWeatherMapService implements WeatherService {

    private final String apiURL;

    public OpenWeatherMapService(String apiURL) {
        this.apiURL = apiURL;
    }

    @Override
    public String getWeatherData() throws IOException, ParseException {
        StringBuilder jsonData = new StringBuilder();
        URL url = new URL(apiURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (InputStream inputStream = connection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        } finally {
            connection.disconnect();
        }

        return jsonData.toString();
    }
}


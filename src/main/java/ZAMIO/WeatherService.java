package ZAMIO;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public interface WeatherService {
    String getWeatherData() throws IOException, ParseException;

}

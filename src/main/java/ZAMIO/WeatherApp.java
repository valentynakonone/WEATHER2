package ZAMIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WeatherApp {


    public static String parseJSONToText (String jsonData) throws ParseException {


        JSONParser parser = new JSONParser();
        StringBuilder weatherText = new StringBuilder();

        JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
        JSONArray forecasts = (JSONArray) jsonObject.get("list");

        for (Object obj : forecasts) {
            JSONObject forecast = (JSONObject) obj;
            JSONObject main = (JSONObject) forecast.get("main");
            JSONObject weather = (JSONObject) ((JSONArray) forecast.get("weather")).get(0);

            String date = forecast.get("dt_txt").toString();
            String temperature = main.get("temp").toString();
            String description = weather.get("description").toString();


            weatherText.append("Date: ").append(date).append(", Temperature: ").append(temperature).append("℉, Description: ").append(description).append("\n");
        }

        return weatherText.toString();
    }
}

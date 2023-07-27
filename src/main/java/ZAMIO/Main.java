package ZAMIO;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

import static ZAMIO.WeatherApp.parseJSONToText;

public class Main {

    public static void main(String[] args) {

        System.out.println(" 1 - Warsaw, 2 - Kyiv:  ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("THIS IS WEATHER FOR YOU: ");

        if (i == 1) {
            String apiURL = "http://api.openweathermap.org/data/2.5/forecast?id=756135&appid=1a1ba0bd99e2136c0a8c39c70b7cf954";
            WeatherService weatherService = new OpenWeatherMapService(apiURL);
            try {
                String jsonData = weatherService.getWeatherData();
                String weatherText = parseJSONToText(jsonData);
                System.out.println(weatherText);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
                return;
            }

            if (i ==2) {
                String api1URL = "http://api.openweathermap.org/data/2.5/forecast?id=703448&appid=1a1ba0bd99e2136c0a8c39c70b7cf954";

                WeatherService wService = new OpenWeatherMapService(api1URL);
                try {
                    String jsonData = wService.getWeatherData();
                    String weatherText = parseJSONToText(jsonData);
                    System.out.println(weatherText);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }



//http://api.openweathermap.org/data/2.5/forecast?id=756135&appid=1a1ba0bd99e2136c0a8c39c70b7cf954
//http://api.openweathermap.org/data/2.5/forecast?id=703448&appid=1a1ba0bd99e2136c0a8c39c70b7cf954
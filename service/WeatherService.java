package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import model.Weather;
import repository.WeatherRepository;
public class WeatherService {

    private WeatherRepository repo;

    public WeatherService(WeatherRepository repo) {
        this.repo = repo;
    }
    //add weather 
    public void addWeather(Weather w) {
        Weather newWeather = new Weather(w.getCity(), w.getTemp(), w.getDate(), w.getTime());
        repo.save(newWeather);
    }

    //list and view all the weather
   
    public List<Weather> getAllWeather() {
        return repo.getAll();
    }

    //update weather temperature
    public void updateTemperature(String city, String date, String newTemp) {
        for (Weather w : repo.getAll()) {
            if (w.getCity().equals(city) && w.getDate().equals(date)) {
                w.setTemp(newTemp);
            }
        }
    }

    //search weather by city

    public Weather searchByCity(String city) {
        for(Weather w : repo.getAll()) {
            if(w.getCity().equalsIgnoreCase(city)) {
                return w;
            }
        }
        return null;
    }

    public Weather filterByTemp(String temp) {
        for(Weather w : repo.getAll()) {
            if(w.getTemp().equalsIgnoreCase(temp)) {
                return w;
            }
        }
        return null;
    }

    //delete weather data
    public void deleteWeather(String city, String date) {
        repo.delete(city, date);
    }

}






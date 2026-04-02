package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Weather;

public class WeatherRepository {
    private HashMap<String, Weather> weathers = new HashMap<>();

    public void save(Weather w) {
        for(Weather existing : weathers.values()) {
            if (existing.getCity().equals(w.getCity()) &&
                existing.getDate().equals(w.getDate())) {
                return; // avoids Duplicate entry 
            }
        }
        weathers.put(w.getCity(), w);  
    }
    public List<Weather> getAll() {
        return new ArrayList<>(weathers.values());
    }
    public void delete(String city, String date) {
        weathers.remove(city);
    }
    
}

//git init
//git remote add origin <repo-link>
//git add .
//git commit -m "Initial commit"
//git branch -M main
//git push -u origin main


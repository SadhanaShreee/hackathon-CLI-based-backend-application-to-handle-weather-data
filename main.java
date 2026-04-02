import repository.WeatherRepository;
import service.WeatherService;
import model.Weather;
import java.util.*;
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WeatherRepository weatherRepo = new WeatherRepository();
        WeatherService weatherService = new WeatherService(weatherRepo);

        //duplicate data instead of api integration  & also acts as historical data 

        Weather weather1 = new Weather("New York", "20C", "2024-06-01", "12:00");
        Weather weather2 = new Weather("Los Angeles", "25C", "2024-06-01", "12:30");
        Weather weather3 = new Weather("India", "30C", "2026-02-01", "10:00");
        Weather weather4 = new Weather("Chicago", "10C", "2025-06-01", "18:00");
        weatherService.addWeather(weather1);
        weatherService.addWeather(weather2);
        weatherService.addWeather(weather3);
        weatherService.addWeather(weather4);

        while(true) {
            System.out.println("MenuList:");
            System.out.println("1. Add Weather Data");
            System.out.println("2. View Weather Data");
            System.out.println("3. Search Weather Data by city");
            System.out.println("4. Filter By Temperature");
            System.out.println("5. Delete Weather Data");
            System.out.println("6. View Schedules of updates");
            System.out.println("7. Update Weather Data");
            System.out.println("8. Exit");
            System.out.println("Enter your choice:");
            System.out.println("--------------------------------------------------");
            int choice = sc.nextInt(); 
            sc.nextLine(); 

            switch(choice){
                case 1:
                    System.out.println("Enter city:");
                    String city = sc.nextLine();
                    System.out.println("Enter temperature:");
                    String temp = sc.nextLine();
                    System.out.println("Enter date (YYYY-MM-DD):");
                    String date = sc.nextLine();
                    System.out.println("Enter time (HH:MM):");
                    String time = sc.nextLine();
                    Weather newWeather = new Weather(city, temp, date, time);
                    weatherService.addWeather(newWeather);
                    System.out.println("Weather data added successfully!");
                    System.out.println("--------------------------------------------------");   
                    System.out.println("City: " + city + ", Temp: " + temp + ", Date: " + date + ", Time: " + time);
                    System.out.println("--------------------------------------------------");
                    System.out.println();
                    break;
                case 2:
                    for(Weather w : weatherService.getAllWeather()) {
                        System.out.println(w.getCity() + " -> " + w.getTemp() + " -> " + w.getDate() + " -> " + w.getTime());
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("Enter city to search:");
                    String searchCity = sc.nextLine();
                    //call func and check if it exists

                    Weather cityResult = weatherService.searchByCity(searchCity);

                    if(cityResult != null) {
                        System.out.println(cityResult.getCity() + " -> " + cityResult.getTemp() + " -> " + cityResult.getDate() + " -> " + cityResult.getTime());
                    } else {
                        System.out.println("Weather data not found for the specified city.");
                    }
                    break;

                case 4:
                    System.out.println("Enter temperature to filter:");
                    String filterTemp = sc.nextLine();

                    Weather tempResult = weatherService.filterByTemp(filterTemp);

                    if(tempResult != null) {
                        System.out.println(tempResult.getCity() + " -> " + tempResult.getTemp() + " -> " + tempResult.getDate() + " -> " + tempResult.getTime());
                    } else {
                        System.out.println("Weather data not found for the specified temperature.");
                    }
                    break;
                case 5:
                    System.out.println("Enter city & date to delete:");
                    System.out.print("City: ");
                    String dc = sc.nextLine();
                    System.out.print("Date: ");
                    String dd = sc.nextLine();

                    //func call
                    weatherService.deleteWeather(dc, dd);
                    break;


                case 6:
                    System.out.println("Schedules of updates:");
                    System.out.println("1. Daily at 12:00 PM, Weather Data Update");
                    System.out.println("2. Daily at 23:00, Temperature Update");
                    System.out.println("3. Monthly on the 1st at 23:00 to 24:00, System Maintenance");
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Enter city & date to update temperature:");
                    System.out.print("City: ");
                    String uc = sc.nextLine();
                    System.out.print("Date: ");
                    String ud = sc.nextLine();
                    System.out.print("New Temperature: ");
                    String newTemp = sc.nextLine();
                    System.out.println();

                    //func call
                    weatherService.updateTemperature(uc, ud, newTemp);
                    break;
                
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

    }
}
}}

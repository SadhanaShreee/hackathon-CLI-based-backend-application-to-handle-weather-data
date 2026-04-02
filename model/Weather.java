package model;

public class Weather {
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String city;
    private String temp;
    private String date;
    private String time;
    

    public Weather(String city, String temp, String date, String time) {
        this.city = city;
        this.temp = temp;
        this.date = date;
        this.time = time;
    }
}

package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherApplication {

    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        Display display = new StatisticsDisplay(wd);
        wd.setWeather(1,2,4);
    }
}


interface Observer<I> {
    void update(I i);
}

interface Subject<I> {
    void register(I o);

     void notifyObservers();

    void remove(I o);
}

class WeatherData implements  Subject<Observer> {
    private int temp;
    private int pressure;
    private int humidity;
    List<Observer> observers;
    WeatherData() {
       observers = new ArrayList<>();
    }

    public void setWeather(int temp, int pressure, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
observers.forEach(o -> o.update(this));
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }
}

interface Display {

}

class StatisticsDisplay implements Observer<WeatherData>, Display {
    WeatherData weatherData;
    @Override
    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        System.out.println("got the updated temperature");
        // now do statics logic here
    }

    StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }


}
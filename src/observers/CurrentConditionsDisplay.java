package observers;
import subject.WeatherData;
import weather.DisplayElement;
import weather.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("\n📊 CONDICIONES ACTUALES:");
        System.out.printf("   🌡️  Temperatura: %.1f°C\n", temperature);
        System.out.printf("   💧 Humedad: %.1f%%\n", humidity);
        System.out.printf("   🔽 Presión: %.1f hPa\n", pressure);
    }
}

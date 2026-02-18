package observers;
import subject.WeatherData;
import weather.DisplayElement;
import weather.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.currentPressure = 1013.0f;  
        this.lastPressure = 1013.0f;
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("\n🔮 PRONÓSTICO:");
        
        if (currentPressure > lastPressure) {
            System.out.println("   ☀️  Mejorando - Espera clima más cálido");
        } else if (currentPressure < lastPressure) {
            System.out.println("   🌧️  Empeorando - Posible lluvia");
        } else {
            System.out.println("   ⛅ Estable - Más de lo mismo");
        }
        
        System.out.printf("   Presión: %.1f → %.1f hPa\n", lastPressure, currentPressure);
    }
}

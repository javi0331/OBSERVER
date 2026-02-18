package observers;
import subject.WeatherData;
import weather.DisplayElement;
import weather.Observer;

public class PressureDisplay implements Observer, DisplayElement {
    private float pressure;
    private WeatherData weatherData;
 
    public PressureDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("\n🔽 PRESIÓN ATMOSFÉRICA:");
        System.out.printf("   Presión actual: %.1f hPa\n", pressure);
        
        if (pressure < 1000) {
            System.out.println("   📉 Baja presión - Sistema de bajas presiones");
        } else if (pressure > 1020) {
            System.out.println("   📈 Alta presión - Sistema de altas presiones");
        } else {
            System.out.println("   ➡️  Presión normal - Condiciones estables");
        }

        float pressuremmHg = pressure * 0.750062f;
        float pressureinHg = pressure * 0.02953f;
        
        System.out.printf("   Equivalente: %.1f mmHg / %.2f inHg\n", pressuremmHg, pressureinHg);
    }
}

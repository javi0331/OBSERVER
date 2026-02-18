package observers;
import java.util.ArrayList;
import java.util.List;
import weather.DisplayElement;
import weather.Observer;

import subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temperatures;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.temperatures = new ArrayList<>();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        temperatures.add(temperature);
        display();
    }
    
    public void display() {
        if (temperatures.isEmpty()) {
            return;
        }
        
        float sum = 0;
        float max = temperatures.get(0);
        float min = temperatures.get(0);
        
        for (float temp : temperatures) {
            sum += temp;
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }
        
        float avg = sum / temperatures.size();
        
        System.out.println("\n📈 ESTADÍSTICAS:");
        System.out.printf("   Promedio: %.1f°C\n", avg);
        System.out.printf("   Máxima: %.1f°C\n", max);
        System.out.printf("   Mínima: %.1f°C\n", min);
        System.out.printf("   Lecturas: %d\n", temperatures.size());
    }
}

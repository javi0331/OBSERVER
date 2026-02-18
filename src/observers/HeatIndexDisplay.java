package observers;
import subject.WeatherData;
import weather.DisplayElement;
import weather.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private static final double C1 = -8.78469475556;
    private static final double C2 = 1.61139411;
    private static final double C3 = 2.33854883889;
    private static final double C4 = -0.14611605;
    private static final double C5 = -0.012308094;
    private static final double C6 = -0.0164248277778;
    private static final double C7 = 2.211732e-3;
    private static final double C8 = 7.2546e-4;
    private static final double C9 = -3.582e-6;
    
    private float heatIndex;
    private float temperature;
    private float humidity;
    private WeatherData weatherData;
    
    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.heatIndex = calculateHeatIndex(temperature, humidity);
        display();
    }

    private float calculateHeatIndex(float T, float R) {
        double HI = C1 + 
                    C2 * T + 
                    C3 * R + 
                    C4 * T * R + 
                    C5 * T * T + 
                    C6 * R * R + 
                    C7 * T * T * R + 
                    C8 * T * R * R + 
                    C9 * T * T * R * R;
        
        return (float) HI;
    }
    
    public void display() {
        System.out.println("\n🔥 ÍNDICE DE CALOR:");
        System.out.printf("   Sensación térmica: %.1f°C\n", heatIndex);
        

        if (heatIndex < 27) {
            System.out.println("   ✅ Precaución baja - Condiciones normales");
        } else if (heatIndex < 32) {
            System.out.println("   ⚠️  Precaución - Posible fatiga con exposición prolongada");
        } else if (heatIndex < 39) {
            System.out.println("   ⚠️  Precaución extrema - Posible insolación");
        } else if (heatIndex < 51) {
            System.out.println("   🚨 Peligro - Probable insolación");
        } else {
            System.out.println("   ☠️  Peligro extremo - Insolación inminente");
        }
        
        System.out.printf("   (T=%.1f°C, H=%.1f%%)\n", temperature, humidity);
    }
}

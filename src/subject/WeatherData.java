package subject;
import weather.Observer;
import weather.Subject;
import java.util.ArrayList;
import java.util.List;


public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("✓ Observador " + observer.getClass().getSimpleName() + " registrado");
        }
    }
    
    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            System.out.println("✗ Observador " + observer.getClass().getSimpleName() + " removido");
        }
    }
    
    @Override
    public void notifyObservers() {
        System.out.println("\n📢 Notificando a todos los observadores...");
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    

    public void measurementsChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🌡️  NUEVAS MEDICIONES RECIBIDAS");
        System.out.println("=".repeat(60));
        System.out.printf("   Temperatura: %.1f°C\n", temperature);
        System.out.printf("   Humedad: %.1f%%\n", humidity);
        System.out.printf("   Presión: %.1f hPa\n", pressure);
        
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        measurementsChanged();
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
}

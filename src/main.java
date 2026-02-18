import observers.CurrentConditionsDisplay;
import observers.ForecastDisplay;
import observers.HeatIndexDisplay;
import observers.PressureDisplay;
import observers.StatisticsDisplay;
import subject.WeatherData;

public class main {
    
    public static void main(String[] args) {
        System.out.println("╔" + "=".repeat(70) + "╗");
        System.out.println("║" + " ".repeat(15) + "ESTACIÓN METEOROLÓGICA IoT" + " ".repeat(29) + "║");
        System.out.println("║" + " ".repeat(15) + "Patrón Observer - Demo" + " ".repeat(32) + "║");
        System.out.println("╚" + "=".repeat(70) + "╝");

        WeatherData weatherData = new WeatherData();
        
        System.out.println("\n🔧 Inicializando displays...");

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        PressureDisplay pressureDisplay = new PressureDisplay(weatherData);
        
        System.out.println("\n✓ Todos los displays registrados correctamente");

        printSeparator();
        System.out.println("🌅 SIMULACIÓN 1: Día caluroso y húmedo");
        printSeparator();
        weatherData.setMeasurements(32.0f, 80.0f, 1012.5f);

        printSeparator();
        System.out.println("🌤️  SIMULACIÓN 2: Temperatura más fresca");
        printSeparator();
        weatherData.setMeasurements(25.0f, 65.0f, 1015.0f);

        printSeparator();
        System.out.println("⛈️  SIMULACIÓN 3: Bajada de presión (tormenta aproximándose)");
        printSeparator();
        weatherData.setMeasurements(28.0f, 90.0f, 1005.0f);

        printSeparator();
        System.out.println("❄️  SIMULACIÓN 4: Día frío y seco");
        printSeparator();
        weatherData.setMeasurements(15.0f, 40.0f, 1020.0f);

        printSeparator();
        System.out.println("🔥 SIMULACIÓN 5: Día extremadamente caluroso");
        printSeparator();
        weatherData.setMeasurements(38.0f, 85.0f, 1010.0f);

        printSeparator();
        System.out.println("🔧 DEMO: Removiendo display de pronóstico");
        printSeparator();
        weatherData.removeObserver(forecastDisplay);
        
        printSeparator();
        System.out.println("🌡️  SIMULACIÓN 6: Actualización sin pronóstico");
        printSeparator();
        weatherData.setMeasurements(30.0f, 70.0f, 1013.0f);
        
        System.out.println("\n\n╔" + "=".repeat(70) + "╗");
        System.out.println("║" + " ".repeat(20) + "FIN DE LA DEMOSTRACIÓN" + " ".repeat(27) + "║");
        System.out.println("╚" + "=".repeat(70) + "╝");
    }
    
    private static void printSeparator() {
        System.out.println("\n\n" + "─".repeat(70));
    }
}

public class ForecastDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        display();
        weatherData.registerObserver(this);
    }

    public void display() {
        
        if (currentPressure > lastPressure) {
            System.out.println("Forecast: Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
             System.out.println("Forecast: more of the same!");
        } else {
           System.out.println("Forecast: Watch out for cooler, rainy weather!");
        }
    }

    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
//Susan Sarahi Ponce Mejia 19211712

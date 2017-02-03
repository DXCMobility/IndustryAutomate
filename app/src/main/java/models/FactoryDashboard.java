package models;

/**
 * Created by kumardev on 2/3/2017.
 */

public class FactoryDashboard {
    private String status;
    private String power_consumption;
    private String temp;
    private String humidity;

    public FactoryDashboard(String status, String power_consumption, String temp, String humidity) {
        this.status = status;
        this.power_consumption = power_consumption;
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(String power_consumption) {
        this.power_consumption = power_consumption;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}

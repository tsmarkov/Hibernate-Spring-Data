package ferrari;

public class Ferrari implements Car {
    private String model;
    private String driver;

    Ferrari(String driver) {
        this.model = "488-Spider";
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model, this.useBrakes(), this.useGasPedal(), this.driver);
    }
}

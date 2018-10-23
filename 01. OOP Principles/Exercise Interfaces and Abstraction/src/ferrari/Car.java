package ferrari;

public interface Car {
    static final String breaks = "Brakes!";
    static final String gasPedal = "Zadu6avam sA!";

    String getModel();

    String getDriver();

    default String useBrakes() {
        return breaks;
    }

    default String useGasPedal() {
        return gasPedal;
    }
}

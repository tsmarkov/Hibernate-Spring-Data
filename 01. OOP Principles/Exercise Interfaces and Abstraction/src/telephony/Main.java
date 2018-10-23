package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");
        String[] urls = reader.readLine().split(" ");

        Smartphone smartphone = new Smartphone(numbers, urls);

        smartphone.callAllNumbers();
        smartphone.browseAllURLs();
    }
}

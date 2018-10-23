package telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browseable {
    private String[] numbers;
    private String[] urls;

    Smartphone(String[] numbers, String[] urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    void browseAllURLs() {
        for (String url : urls) {
            this.browse(url);
        }
    }

    void callAllNumbers() {
        for (String number : numbers) {
            this.call(number);
        }
    }

    @Override
    public void browse(String url) {
        Pattern pattern = Pattern.compile("^[^0-9]+$");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            System.out.println("Browsing: " + url + "!");
        } else {
            System.out.println("Invalid URL!");
        }
    }

    @Override
    public void call(String number) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            System.out.println("Calling... " + number);
        } else {
            System.out.println("Invalid number!");
        }
    }
}

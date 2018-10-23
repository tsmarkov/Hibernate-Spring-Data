package border_control;

import border_control.entities.Citizen;
import border_control.entities.Identifiable;
import border_control.entities.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiables = new ArrayList<>();

        while (true) {
            String[] input = reader.readLine().split("\\s+");

            if ((input.length == 1 && !input[0].equalsIgnoreCase("end")) || input.length == 0) {
                System.out.println("Invalid Input! Try again...");
            } else if (input[0].equalsIgnoreCase("end")) {
                break;
            } else {
                Identifiable identifiable;

                if (input.length == 2) {
                    String model = input[0];
                    String id = input[1];

                    identifiable = new Robot(model, id);
                } else {
                    String name = input[0];
                    int age = Integer.parseInt(input[1]);
                    String id = input[2];

                    identifiable = new Citizen(name, age, id);
                }

                identifiables.add(identifiable);
            }
        }

        String fakeId = reader.readLine();

        List<Identifiable> detained = identifiables
                .stream()
                .filter(i -> i.getId().endsWith(fakeId))
                .collect(Collectors.toList());

        detained.forEach(e -> System.out.println(e.getId()));
    }
}

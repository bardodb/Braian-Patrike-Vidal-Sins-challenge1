package Gondola;

import java.util.ArrayList;
import java.util.List;

class FerrisWheel {
    private List<Gondola> gondolas;

    public FerrisWheel() {
        gondolas = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            gondolas.add(new Gondola());
        }
    }

    private Gondola getNextEmptyGondola() {
        for (Gondola gondola : gondolas) {
            if (gondola.isEmpty()) {
                return gondola;
            }
        }
        return null; // No empty gondolas available
    }
    public void board(int gondolaNumber, Person... passengers) {
        Gondola gondola = gondolas.get(gondolaNumber - 1);
        if (gondola != null) {
            if (passengers.length == 1) {
                gondola.setPassenger(passengers[0]);
            } else {
                if (passengers.length == 2 && passengers[0] instanceof Child) {
                    Child child = (Child) passengers[0];
                    Adult father = child.getFather();
                    if (father != null && father.equals(passengers[1])) {
                        gondola.setPassenger(passengers[0]);
                        gondola.setPassenger(passengers[1]);
                    } else {
                        System.out.println("ERROR: " + child.name +" can only ride with the father!");
                    }
                } else {
                    System.out.println("ERROR: Invalid combination of passengers!");
                }
            }
        } else {
            System.out.println("ERROR: Invalid gondola number!");
        }
        if (passengers.length > 0 && passengers[0] instanceof Child) {
            Child child = (Child) passengers[0];
            if (child.getAge() < 12 && child.getFather() == null) {
                System.out.println("ERROR: " + child.name + " under 12 must have a responsible person to ride!");
                gondola.setPassenger(null); // Remove the child from the gondola
            }
        }
    }


    public void status() {
        System.out.println("Gondola Status");
        System.out.println("------- -----------------------");
        for (int i = 0; i < gondolas.size(); i++) {
            System.out.printf("%d %s%n", i + 1, gondolas.get(i));
        }
    }
}
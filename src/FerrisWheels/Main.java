package FerrisWheels;

import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Adult extends Person {
    private int age;

    public Adult(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Child extends Person {
    private int age;
    private Adult father;

    public Child(String name, int age) {
        super(name);
        this.age = age;
    }

    public Child(String name, int age, Adult father) {
        super(name);
        this.age = age;
        this.father = father;
    }

    public int getAge() {
        return age;
    }

    public Adult getFather() {
        return father;
    }
}

class Gondola {
    private Person person;

    public Gondola(Person person) {
        this.person = person;
    }

    public boolean isEmpty() {
        return person == null;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonName() {
        return person != null ? person.getName() : "(empty)";
    }
}

class FerrisWheel {
    private Map<Integer, Gondola> gondolas;

    public FerrisWheel() {
        gondolas = new HashMap<>();
        for (int i = 1; i <= 18; i++) {
            gondolas.put(i, new Gondola(null));
        }
    }

    public void board(int gondolaNumber, Child child, Adult father) {
        if (child.getAge() < 12 && child.getFather() != father) {
            System.out.println("ERROR: " + child.getName() + " is under 12 and the father is not present");
            return;
        }

        Gondola gondola = gondolas.get(gondolaNumber);
        gondola.setPerson(child);
        gondolas.put(gondolaNumber, gondola);
    }

    public void board(int gondolaNumber, Child child, Child maria) {
        if (child.getAge() < 12 && child.getFather() == null) {
            System.out.println("ERROR: " + child.getName() + " is under 12 and the father is not present");
            return;
        }

        Gondola gondola = gondolas.get(gondolaNumber);
        gondola.setPerson(child);
        gondolas.put(gondolaNumber, gondola);
    }

    public void board(int gondolaNumber, Adult adult) {
        Gondola gondola = gondolas.get(gondolaNumber);
        gondola.setPerson(adult);
        gondolas.put(gondolaNumber, gondola);
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("------- -----------------------");
        for (int i = 1; i <= 18; i++) {
            Gondola gondola = gondolas.get(i);
            System.out.println(i + " " + gondola.getPersonName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FerrisWheel ferrisWheel = new FerrisWheel(); // Creating a new Ferris wheel
        Adult paulo = new Adult("Paulo", 42); // Adult named Paulo
        // Paulo's children
        Child joao = new Child("Joao", 5, paulo); // New child with Paulo as the father
        Child maria = new Child("Maria", 12, paulo); // This is Paulo's daughter
        // Child without defined father
        Child pedro = new Child("Pedro", 13);
        Child henrique = new Child("Henrique", 10);

        ferrisWheel.board(2, joao, maria); // ERROR: Joao is under 12 and the father is not present
        ferrisWheel.board(2, joao, paulo); // OK: Now the father is present
        ferrisWheel.board(3, maria, maria); // OK: Maria is 12 years old and can ride alone
        ferrisWheel.board(13, pedro, maria); // OK: Pedro rides alone
        ferrisWheel.board(16, henrique, maria); // ERROR: Henrique is under 12 and we don't know who the father is (should be Silvio, but he didn't assume responsibility!)
        ferrisWheel.status();
    }
}

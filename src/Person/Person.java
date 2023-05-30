package Person;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private Person spouse;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void spouse(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void printFamilyTree(int generation) {
        printIndentation(generation);
        System.out.println(name);
        if (spouse != null) {
            printIndentation(generation);
            System.out.println("└── Married to " + spouse.name);
        }
        if (!children.isEmpty()) {
            printIndentation(generation);
            System.out.println("└── Children:");
            for (Person child : children) {
                child.printFamilyTree(generation + 1);
            }
        }
    }

    private void printIndentation(int generation) {
        for (int i = 0; i < generation; i++) {
            System.out.print("    ");
        }
    }
}

class TestTree {
    public static void main(String[] args) {
        Person lily = new Person("Lily");
        lily.spouse(new Person("Wilhelm"));
        // Patriarch and matriarch
        Person opa = new Person("Opa");
        opa.addChild(lily);
        opa.spouse(new Person("Oma"));
        // Children of Oma and Opa
        Person reinhold = new Person("Reinhold");
        Person wilma = new Person("Wilma");
        Person sigrid = new Person("Sigrid");
        opa.addChild(reinhold);
        opa.addChild(wilma);
        opa.addChild(sigrid);
        // Children and spouse of Reinhold
        reinhold.spouse(new Person("Sonia"));
        Person christian = new Person("Christian");
        Person gabrielle = new Person("Gabrielle");
        Person sabine = new Person("Sabine");
        reinhold.addChild(christian);
        reinhold.addChild(gabrielle);
        reinhold.addChild(sabine);
        // Children and spouse of Wilma
        wilma.spouse(new Person("Rodolfo"));
        Person ricardo = new Person("Ricardo");
        Person rodrigo = new Person("Rodrigo");
        wilma.addChild(ricardo);
        wilma.addChild(rodrigo);
        // Ricardo and spouse
        ricardo.spouse(new Person("Debora"));
        // Children and spouse of Christian
        christian.spouse(new Person("Monica"));
        Person oscar = new Person("Oscar");
        Person lorena = new Person("Lorena");
        christian.addChild(oscar);
        christian.addChild(lorena);
        // Children and spouse of Sigrid
        sigrid.spouse(new Person("Peter"));
        Person martin = new Person("Martin");
        Person thomas = new Person("Thomas");
        Person claudia = new Person("Claudia");
        sigrid.addChild(martin);
        sigrid.addChild(thomas);
        sigrid.addChild(claudia);
        martin.spouse(new Person("Carla"));
        martin.addChild(new Person("Nicolas"));

        opa.printFamilyTree(0);
    }
}

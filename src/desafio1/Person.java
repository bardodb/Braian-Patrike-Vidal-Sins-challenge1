package desafio1;

import java.util.ArrayList;
import java.util.List;
class   Person {
    private String name;
    private Person spouse = null;
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
            System.out.println("    └── Children:");

            for (Person child : children) {
                child.printFamilyTree(generation + 1);
            }
        } else if (spouse == null) {
            printIndentation(generation);
            System.out.println("└── Single");
        }
    }

    private void printIndentation(int generation) {
        for (int i = 0; i < generation; i++) {
            System.out.print("    ");
        }
    }
}

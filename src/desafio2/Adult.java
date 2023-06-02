package desafio2;

class Adult extends Person {
    public Adult(String name, int age) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
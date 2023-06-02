package Gondola;

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

    public Adult getFather() {
        return father;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        if (father != null) {
            return getName() + " and " + father.getName();
        }
        if (age >=   12 && father == null){
            return "only " + getName();
        }
        else {
            return getName();
        }
    }

}



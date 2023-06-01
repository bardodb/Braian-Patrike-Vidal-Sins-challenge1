package Person;


class TestTree {
    public static void main(String[] args) {

        Person lily = new Person("Lily");
        Person wilhelm = new Person("Wilhelm");
        lily.spouse(wilhelm);

        Person opa = new Person("Opa");
        Person oma = new Person("Oma");
        opa.spouse(oma);
        lily.addChild(opa);


        Person reinhold = new Person("Reinhold");
        Person wilma = new Person("Wilma");
        Person sigrid = new Person("Sigrid");
        opa.addChild(reinhold);
        opa.addChild(wilma);
        opa.addChild(sigrid);

        Person sonia = new Person("Sonia");
        reinhold.spouse(sonia);
        Person christian = new Person("Christian");
        Person gabrielle = new Person("Gabrielle");
        Person sabine = new Person("Sabine");
        reinhold.addChild(christian);
        reinhold.addChild(gabrielle);
        reinhold.addChild(sabine);

        Person rodolfo = new Person("Rodolfo");
        wilma.spouse(rodolfo);
        Person ricardo = new Person("Ricardo");
        Person rodrigo = new Person("Rodrigo");
        wilma.addChild(ricardo);
        wilma.addChild(rodrigo);

        Person debora = new Person("Debora");
        ricardo.spouse(debora);

        Person monica = new Person("Monica");
        christian.spouse(monica);
        Person oscar = new Person("Oscar");
        Person lorena = new Person("Lorena");
        christian.addChild(oscar);
        christian.addChild(lorena);

        Person peter = new Person("Peter");
        peter.spouse(sigrid);
        Person martin = new Person("Martin");
        Person thomas = new Person("Thomas");
        Person claudia = new Person("Claudia");
        sigrid.addChild(martin);
        sigrid.addChild(thomas);
        sigrid.addChild(claudia);

        Person carla = new Person("Carla");
        martin.spouse(carla);
        martin.addChild(new Person("Nicolas"));

        lily.printFamilyTree(0);
    }
}
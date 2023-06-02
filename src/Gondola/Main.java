package Gondola;


public class Main {
    public static void main(String[] args) {
        FerrisWheel ferrisWheel = new FerrisWheel();
        Adult paulo = new Adult("Paulo", 42);
        Child joao = new Child("Joao", 5, paulo);
        Child maria = new Child("Maria", 12);
        Child pedro = new Child("Pedro", 13);
        Child henrique = new Child("Henrique", 10);

        ferrisWheel.board(2,  joao, maria);
        ferrisWheel.board(2, joao);
        ferrisWheel.board(3, maria);
        ferrisWheel.board(13, pedro);
        ferrisWheel.board(16, henrique);

        ferrisWheel.status();
    }
}

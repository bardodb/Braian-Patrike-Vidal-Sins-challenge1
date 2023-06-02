package Gondola;
class Gondola {
    private Person passenger;

    public boolean isEmpty() {
        return passenger == null;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }

    public Person getPassenger() {
        return passenger;
    }

    public String toString() {
        return isEmpty() ? "(empty)" : passenger.toString();
    }
}

import java.util.ArrayList;

public class Winner {
    private Racer racer;
    private int distance;

    public Winner(ArrayList<Racer> racers) {
        Racer winner = racers.getFirst();

        for (Racer racer : racers) {
            if (racer.speed > winner.speed) {
                winner = racer;
            }
        }

        this.racer = winner;
        this.distance = winner.speed * 24;
    }

    public Racer getRacer() {
        return racer;
    }

    public int getDistance() {
        return distance;
    }
}

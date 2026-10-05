import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать на гонку \"«24 часа Ле-Мана»");
        ArrayList<Racer> racersList = new ArrayList<>();

        for (int i = 1; i <= 3; i++){
            System.out.print("Введи гонщика №" + i + " (название и скорость через пробел): ");
            String userInputName = scanner.next();
            int userInputSpeed = scanner.nextInt();
            if (checkSpeed(userInputSpeed)) {
                System.out.println("Скорость должна быть >0 b <= 250");
                userInputSpeed = scanner.nextInt();
            }
            racersList.add(new Racer(userInputName, userInputSpeed));
            System.out.println("Гонщик №" + i + " создан: " + userInputName + ", скорость(км/ч): " + userInputSpeed);
        }

        System.out.print("\nСписок гонщиков: ");
        for (Racer racer : racersList) {
            System.out.print(racer.name + " ");
        }

        System.out.println("\n\nСпустя 24 часа...\n");
        System.out.println("И победителем становится: гонщик " + getWinner(racersList).name + " !!!");
        System.out.println("За 24 часа он преодолел: " + getWinner(racersList).speed*24);

    }

    public static boolean checkSpeed(int speed){
        return speed <= 0 && speed > 250;
    }

    public static Racer getWinner(ArrayList<Racer> racers){
        Racer winner = racers.getFirst(); // сначала запишем победителем первого гонщика
        for (Racer racer : racers) {
            if (racer.speed * 24 > winner.speed * 24) {
                winner = racer;
            }
        }
        return winner;
    }
}
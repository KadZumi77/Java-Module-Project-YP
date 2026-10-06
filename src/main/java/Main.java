import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать на гонку \"«24 часа Ле-Мана»");
        ArrayList<Racer> racersList = new ArrayList<>();

        for (int i = 1; i <= 3; i++){
            System.out.print("Введи имя гонщика №" + i + ": ");
            String userInputName = scanner.nextLine();
            while (checkName(userInputName)){
                System.out.print("Ошибка! Имя не может быть пустым: ");
                userInputName = scanner.nextLine();
            }

            // не могла никак придумать, как добавить проверку на пустую скорость
            // нейронка предложила через цикл while с try-catch,
            // получилось длиновато, поэтому решила всю проверку скорости вынести в отдельный метод checkSpeed
            int userInputSpeed = checkSpeed(scanner, i);

            racersList.add(new Racer(userInputName, userInputSpeed));
            System.out.println("Гонщик №" + i + " создан: " + userInputName + ", скорость(км/ч): " + userInputSpeed);
        }

        System.out.print("\nСписок гонщиков: ");
        for (Racer racer : racersList) {
            System.out.print(racer.name + " ");
        }

        Winner winner = new Winner(racersList);
        System.out.println("\n\nСпустя 24 часа...\n");
        System.out.println("И победителем становится: гонщик " + winner.getRacer().name + " !!!");
        System.out.println("За 24 часа он преодолел: " + winner.getDistance());

    }

    public static boolean checkName(String name){
        return name.isEmpty();
    }

    public static int checkSpeed(Scanner scanner, int number){

        while (true) {
            System.out.print("Введи скорость гонщика №" + number + " (км/ч): ");

            String input = scanner.nextLine(); //пришлось делать строковый ввод, чтобы проверить на пустую строку

            // Проверяем, что строка не пустая
            if (input.isEmpty()) {
                System.out.println("Ошибка! Скорость не может быть пустой.");
                continue;
            }

            try {
                int userInputSpeed = Integer.parseInt(input); // Превращаем строку в число

                if (userInputSpeed > 0 && userInputSpeed <= 250) {
                    return userInputSpeed;
                }

                System.out.println("Скорость должна быть > 0 и <= 250");

            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Скорость должна быть числом:");
            }
        }
    }

//    public static Racer getWinner(ArrayList<Racer> racers){
//        Racer winner = racers.getFirst(); // сначала запишем победителем первого гонщика
//        for (Racer racer : racers) {
//            if (racer.speed * 24 > winner.speed * 24) {
//                winner = racer;
//            }
//        }
//        return winner;
//    }
}
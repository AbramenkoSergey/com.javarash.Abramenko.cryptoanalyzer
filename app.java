import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        int choice;

        System.out.println("Добро пожаловать в программу.\nВыберите желаемое действие:");
        System.out.println("1: Шифровать текст с использованием шифра Цезаря");
        System.out.println("2: Расшифровывать текст с использованием шифра Цезаря.");
        System.out.println("3: Выход");
        System.out.println("Для выбора действия необходимо ввести номер выбранного вами пункта: ");

        Scanner scan = new Scanner(System.in);
        while (true) {
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    //doCrypto
                    break;
                }
                case 2: {
                    //decryption
                    break;
                }
                case 3: {
                    System.out.println("Спасибо за использование программы. До свидания.");
                    System.exit(0);
                }
                default: {
                    System.out.println("Введите коренное  значение.");
                }
            }


        }


    }
}

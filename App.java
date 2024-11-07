import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int choice;

        System.out.println("Добро пожаловать в программу.\nВыберите желаемое действие:");
        System.out.println("1: Шифровать текст с использованием шифра Цезаря");
        System.out.println("2: Расшифровывать текст с использованием шифра Цезаря.");
        System.out.println("3: Расшифровка методом Brute force");
        System.out.println("4: Выход");
        System.out.print("Для выбора действия необходимо ввести номер выбранного вами пункта: ");

        Scanner scan = new Scanner(System.in);
         while (true){
             choice = scan.nextInt();

             switch (choice) {
                 case 1: {
                     DoCrypto.doCryptoCesar();
                     thanks();
                     System.exit(0);
                 }
                 case 2: {
                     Decryption.doDecryptionCesar();
                     thanks();
                     System.exit(0);
                 } case 3:{
                     BruteForce.doBruteForce();
                     thanks();
                     System.exit(0);


                 } case 4: {
                     System.exit(0);
                 }
                 default: {
                     System.out.println("Введите корректное  значение.");
                 }
             }

         }
    }

    private static void thanks() {
        System.out.println("Спасибо за использование программы. До свидания.");

    }
}

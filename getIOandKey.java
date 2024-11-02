import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class getIOandKey {

    public static String setPathIn() {
        int countFails = 3;
        String localPathStringIn = "";

        System.out.println("У вас 3 попытки ввода пути.");
        System.out.print("Введи путь к файлу: ");
        Scanner scan = new Scanner(System.in);

        Path tmp = null;

        if (countFails == 0) {
            System.out.println("Вы исчерпали количество попыток. Спасибо за использование программы.");
            scan.close();
            System.exit(0);
        } else {
            while (countFails > 0) {
                localPathStringIn = scan.nextLine();
                tmp = Path.of(localPathStringIn);
                try {
                    if (!Files.isRegularFile(tmp)) {
                        countFails--;
                        int x = 3 - countFails;
                        System.out.println("У вас осталось :" + x + " попыток.");
                    } else if (Files.size(tmp) == 0) {
                        System.out.println("Файл пуст, повторите ввод.");
                        countFails--;
                        int x = 3 - countFails;
                        System.out.println("У вас осталось :" + x + " попыток.");
                    } else if (Files.isRegularFile(tmp))
                        localPathStringIn = tmp.toString();
                    countFails = 0;
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            }

        }
        scan.close();
        return localPathStringIn;
    }

    public static String setPathOut() {
        String localPathStringOut = "";
        int countFails = 3;

        System.out.println("У вас 3 попытки ввода пути.");
        System.out.print("Введи путь: ");

        Scanner scan = new Scanner(System.in);
        String tmp = scan.nextLine();
        Path tmpPath = null;

        if (countFails == 0) {
            System.out.println("Вы исчерпали количество попыток. Спасибо за использование программы.");
            scan.close();
            System.exit(0);
        } else {
            while (countFails > 0) {
                try {
                    tmpPath = Path.of(tmp);
                } catch (InvalidPathException e) {
                    System.out.println("Вы ввели не путь");

                }

                if (Files.isDirectory(tmpPath)) {
                    localPathStringOut = tmp;
                    countFails = 0;
                } else {
                    countFails--;
                    int x = 3 - countFails;
                    System.out.println("У вас осталось :" + x + " попыток.");
                }
            }
        }
        return localPathStringOut;
    }

    public static int setKey() {
        int localKey = 0;
        System.out.println("Введите ключ: ");
        try (Scanner scanner = new Scanner(System.in);) {
            localKey = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Вы ввели не число.");
        }
        return localKey;
    }

    public static void repeatCh() {
        System.out.println("=".repeat(25));
    }
}

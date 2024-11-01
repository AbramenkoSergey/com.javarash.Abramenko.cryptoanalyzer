import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class doCrypto {
    private static String pathString;
    private static int key;
    private static int countFails = 3;

    private static final List ALPHABET1 = Arrays.asList(
            'а', 'б', 'в','г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'я',
            '.', ',', '«', '»', ':', '!', '?', ' ');


    private static void setPath() {


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
                pathString = scan.nextLine();
                tmp = Path.of(pathString);
                try {
                    if (!Files.isRegularFile(tmp)) {
                        countFails--;
                        int x = 3 - countFails;
                        System.out.println("У вас осталось :" + x + " попыток.");
                    }else if ( Files.size(tmp) == 0){
                        System.out.println("Файл пуст, повторите ввод.");
                        countFails--;
                        int x = 3 - countFails;
                        System.out.println("У вас осталось :" + x + " попыток.");
                    }
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            }

        }
        scan.close();
        countFails = 3;


    }

    private static void setKey () {

        System.out.println("Введите ключ: ");
        try (Scanner scanner = new Scanner(System.in);){
            key = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException | NoSuchElementException e){
            System.out.println("Вы ввели не число.");
        }
    }

    public static void doCryptoCesar () {
        System.out.println("=".repeat(25));
        setPath();
        setKey();
        System.out.println("=".repeat(25));
        try (FileReader fileReader = new FileReader(pathString);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}

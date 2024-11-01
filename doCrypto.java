import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class doCrypto {
    private static String pathStringIn;
    private static String pathStringOut;
    private static int key;
    private static int countFails = 3;
    private static int positionCh;


    private static final List ALPHABET1 = Arrays.asList(
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'я',
            '.', ',', '«', '»', ':', '!', '?', ' ');
    private static final List ALPHABET2 = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ');

    private static void setCountFails(int countFails) {
        doCrypto.countFails = countFails;
    }

    private static void repeatCh() {
        System.out.println("=".repeat(25));
    }

    private static void setPathIn() {


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
                pathStringIn = scan.nextLine();
                tmp = Path.of(pathStringIn);
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
                        pathStringIn = tmp.toString();
                    countFails = 0;
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            }

        }
        scan.close();
        setCountFails(3);


    }

    private static void setPathOut() {
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
                    pathStringOut = tmp;
                    countFails = 0;
                } else {
                    countFails--;
                    int x = 3 - countFails;
                    System.out.println("У вас осталось :" + x + " попыток.");

                }
            }
        }


    }

    private static void setKey() {
        System.out.println("Введите ключ: ");
        try (Scanner scanner = new Scanner(System.in);) {
            key = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Вы ввели не число.");
        }
    }


    public static void doCryptoCesar() {
        repeatCh();
        setPathIn();
        repeatCh();
        setKey();
        repeatCh();
        setPathOut();
        repeatCh();
        try (FileReader fileReader = new FileReader(pathStringIn);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                char ch = (char) bufferedReader.read();
                positionCh = serchCh(ch);
                char answ = getCharAnsw(key, positionCh);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private static int serchCh(char ch) {
        int intCh = 0;

        Character obCh = ch;
        try {
            intCh = ALPHABET1.indexOf(obCh);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return intCh;
    }

    private static char getCharAnsw(int key, int startPosition) {
        int answIndex = (startPosition + key)% ALPHABET2.size();
        if (answIndex < 0){
            answIndex = answIndex * (-1);
        }
        char charAnsw = (char) ALPHABET1.indexOf(answIndex);
        return charAnsw;
    }
}

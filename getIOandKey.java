import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class getIOandKey {

    public static String setPathIn() {
        String localPathStringIn = "";

        System.out.print("Введи путь к сходному файлу: ");
         try  {
             InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             String line = bufferedReader.readLine();
             Path tmpPath = Path.of(line);
             if(Files.isRegularFile(tmpPath)){
                 localPathStringIn = line;

             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

        return localPathStringIn;
    }

    public static String setPathOut() {
        String localPathStringOut = "";

        System.out.print("Введи путь к папке где должен лежать обработанный файл: ");
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            Path tmpPath = Path.of(line);
            if (Files.isDirectory(tmpPath)){
                localPathStringOut = line+"out.txt";
            }if(Files.isRegularFile(tmpPath)){
                localPathStringOut = tmpPath.getParent().toString() + "out.txt";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Название исходного файла - out.txt");

        return localPathStringOut;
    }

    public static int setKey() {
        int localKey = 0;
        System.out.println("Введите ключ: ");
        try  {
            Scanner scanner = new Scanner(System.in);
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

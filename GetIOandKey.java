import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GetIOandKey {

    public static String setPathIn() {
        String localPathStringIn = "";

        System.out.print("Введи путь к исходному файлу: ");
         try  {
             InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             String line = bufferedReader.readLine();
             Path tmpPath = Path.of(line);
             if(Files.isRegularFile(tmpPath)){
                 localPathStringIn = line;

             }
         } catch (InvalidPathException | IOException | SecurityException e) {

             System.out.println("Что-то пошло не так "+ e);
             System.exit(0);

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
            System.out.println("Название исходного файла - out.txt");
        } catch (InvalidPathException | IOException | SecurityException e) {
            System.out.println("Вы ввели не коренный путь и получили -"+e);
            e.printStackTrace();
            System.exit(0);
        }

        return localPathStringOut;
    }

    public static int setKey() {
        int localKey = -1;

        Scanner scanner = new Scanner(System.in);

        while ( localKey <= 0 ||  localKey > DoCrypto.getSizeALPHABET){
                        System.out.println("Введите ключ в диапазоне от  1 " +
                                " до "+ DoCrypto.getSizeALPHABET);
            try  {
                localKey = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Вы ввели не число.");
            }
        }

        return localKey;
    }

    public static void repeatCh() {
        System.out.println("=".repeat(25));
    }


}

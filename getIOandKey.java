import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
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
         } catch (InvalidPathException | IOException | SecurityException e) {

             e.printStackTrace();

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
        int localKey = 0;

        System.out.println("На ввод ключа у вас есть 3 попытки: ");
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Введите ключ в диапазоне от "+ "-"+doCrypto.getSizeALPHABET+
                    " до "+ Math.abs(doCrypto.getSizeALPHABET));
            try  {
                localKey = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Вы ввели не число.");
            }
        }
        while (localKey > Math.abs(doCrypto.getSizeALPHABET));


        return localKey;
    }

    public static void repeatCh() {
        System.out.println("=".repeat(25));
    }
}

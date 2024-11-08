import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class BruteForce {

    private static final List ALPHABET2 = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю' , 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ');

    public static void doBruteForce(){
        GetIOandKey.repeatCh();
        String pathStringIn = GetIOandKey.setPathIn();
        GetIOandKey.repeatCh();
        String pathStringOut = setPathOfDirectory();

        for (int i = 1; i < ALPHABET2.size(); i++) {

            String pathOutForBruteForce = setPathOutForBruteForce(pathStringOut, i);

            try(FileReader fileReader = new FileReader(pathStringIn);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(pathOutForBruteForce)){
                while (bufferedReader.ready()){
                    char chTmp = (char) bufferedReader.read();
                    char ch = Character.toUpperCase(chTmp);
                    int positionCh = serchCh(ch);
                    int answ = getCharAnswForBruteForce( i, positionCh);
                    fileWriter.write(answ);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Что-то пошло не так "+ e);
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
        System.out.println("Название исходного файла - out<диапазон от 1 до"+(ALPHABET2.size()-1)+">.txt");
    }
    private  static String setPathOfDirectory(){
        String localPathOfDirectory = "";
        System.out.print("Введите директорию для сохранения результатов: ");

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            Path tmpPath = Path.of(line);
            if (Files.isDirectory(tmpPath)){
                localPathOfDirectory = line;
            }if(Files.isRegularFile(tmpPath)){
                localPathOfDirectory = tmpPath.getParent().toString();
            }

        } catch (InvalidPathException | IOException | SecurityException e) {
            System.out.println("Вы ввели не коренный путь и получили -"+e);
            e.printStackTrace();
            System.exit(0);
        }

        return localPathOfDirectory;
    }

    private static String setPathOutForBruteForce(String path, int numberFile) {
            String stringPathfoBF = path + "out"+ numberFile+".txt";
        return stringPathfoBF;
    }

    private static int serchCh(char ch) {
        int intCh = 0;

        Character obCh = ch;
        try {
            intCh = ALPHABET2.indexOf(obCh);

        } catch (NullPointerException e) {
            System.out.println("Что-то пошло не так "+ e);
        }
        return intCh;
    }

    private static char getCharAnswForBruteForce(int key, int startPosition) {
        int answIndex = 0;

        if ( key == 0) {
            return Character.toLowerCase((char) ALPHABET2.get( startPosition));
        } else if (key > 0) {
            answIndex = (startPosition - key)% ALPHABET2.size() ;

        } else  {
            answIndex =  (startPosition - key)% ALPHABET2.size() ;
        }if (answIndex < 0){
            answIndex = ALPHABET2.size() - Math.abs(answIndex);
        }

        char charAnswTmp = (char) ALPHABET2.get(answIndex);
        return Character.toLowerCase(charAnswTmp);
    }

}

import java.io.*;
import java.util.Arrays;
import java.util.List;


public  class decryption {

    private static final List ALPHABET2 = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ');

    public static void doDecryptionCesar() {
        getIOandKey.repeatCh();
        String pathStringIn = getIOandKey.setPathIn();
        getIOandKey.repeatCh();
        int key = getIOandKey.setKey();
        getIOandKey.repeatCh();
        String pathStringOut = getIOandKey.setPathOut();
        getIOandKey.repeatCh();
        try (FileReader fileReader = new FileReader(pathStringIn);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(pathStringOut)) {
            while (bufferedReader.ready()) {
                char chTmp = (char) bufferedReader.read();
                char ch = Character.toUpperCase(chTmp);
                int positionCh = serchCh(ch);
                int answ = getCharAnsw( key, positionCh);
                fileWriter.write(answ);
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так "+ e);;

        }

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

    private static char getCharAnsw(int key, int startPosition) {
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

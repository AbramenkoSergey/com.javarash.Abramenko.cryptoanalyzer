import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;


public class doCrypto {

//    private static final List ALPHABET1 = Arrays.asList(
//            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
//            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
//            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
//            'ы', 'ь', 'э', 'я',
//            '.', ',', '«', '»', ':', '!', '?', ' ');
    private static final List ALPHABET2 = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ');






    public static void doCryptoCesar() {
        getIOandKey.repeatCh();
        String pathStringIn = getIOandKey.setPathIn();
        getIOandKey.repeatCh();
        int key = getIOandKey.setKey();
        getIOandKey.repeatCh();
        String pathStringOut = getIOandKey.setPathOut();
        getIOandKey.repeatCh();
        try (FileReader fileReader = new FileReader(pathStringIn);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileOutputStream fileOutputStream = new FileOutputStream(pathStringOut)) {
            while (bufferedReader.ready()) {
                char chTmp = (char) bufferedReader.read();
                char ch = Character.toUpperCase(chTmp);
                 int positionCh = serchCh(ch);
                int answ = getCharAnsw(key, positionCh);
                fileOutputStream.write(answ);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private static int serchCh(char ch) {
        int intCh = 0;

        Character obCh = ch;
        try {
            intCh = ALPHABET2.indexOf(obCh);

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
        char charAnswTmp = (char) ALPHABET2.indexOf(answIndex);
        return Character.toLowerCase(charAnswTmp);
    }
}
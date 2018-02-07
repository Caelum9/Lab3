import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

    public class WebScanner {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


    public static int countWords(final String url) {
        String toCount = urlToString(url);
        int counter = 0;
        for(int i = 0; i < toCount.length(); i++){
            if (toCount.charAt(i)==' ') {
                counter++;
            }

        }
        return counter;
    }

    public static int countOneWords(final String url) {
        String toCount = urlToString(url);
        System.out.print("please enter the word to check, case sensitive");
        Scanner scan = new Scanner(System.in);
        String wordToSearch = scan.nextLine();
        //int counter = 0;
        String[] a = toCount.split(wordToSearch);
        return a.length - 1;

    }


    public static void main(String[] args) {
        //System.out.println(countWords("http://erdani.com/tdpl/hamlet.txt"));
        System.out.print("enter an url");
        Scanner urlinput = new Scanner(System.in);
        String url = urlinput.nextLine();
        //int words = countWords(url);
        //System.out.println(words);
        System.out.println(countOneWords(url));



    }
}

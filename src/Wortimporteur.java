import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Wortimporteur {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:\\Users\\avann\\IdeaProjects\\Wortschatz\\src\\Neue Wörter.txt"));
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\avann\\IdeaProjects\\Wortschatz\\src\\sortierte Wörter"));
        String currentLine;
        while (scan.hasNext()) {
            currentLine = scan.nextLine();
            if (!currentLine.isBlank()) {
//                System.out.print(currentLine);
                if (currentLine.substring(0, 4).equals("der ")
                        || currentLine.substring(0, 4).equals("die ")
                        || currentLine.substring(0, 4).equals("das ")) {
                    Nomen newNoun = new Nomen(currentLine.substring(0, 3)
                            , currentLine.substring(4, currentLine.indexOf(" ", 4)) //noun
                            , currentLine.substring(currentLine.indexOf("[") + 1, currentLine.indexOf("]")) //plural
                            , currentLine.substring(currentLine.indexOf("]") + 2)); //
                    System.out.println(newNoun.toString());
                } else if (currentLine.contains("|")) { //verb
                    Verb newVerb = new Verb(currentLine.substring(0, currentLine.indexOf("[") - 1)
                            , currentLine.substring(currentLine.indexOf("[") + 1, currentLine.indexOf("|") - 1)
                            , currentLine.substring(currentLine.indexOf("|") + 2, currentLine.indexOf("]"))
                            , currentLine.substring(currentLine.indexOf("]") + 2));
                    System.out.println(newVerb.toString());
                } else { //not noun or verb
                    Other newOther = new Other(currentLine.substring(0, currentLine.indexOf(" "))
                            , currentLine.substring(currentLine.indexOf(" ")+1));
                    System.out.println(newOther.toString());
                }
            }
        }
    }
}

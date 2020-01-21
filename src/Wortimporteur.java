import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Wortimporteur {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("C:\\Users\\avann\\IdeaProjects\\Wortschatz\\src\\Neue Wörter.txt")), inputScan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\avann\\IdeaProjects\\Wortschatz\\src\\sortierte Wörter"));
        String fileLineInput;
        while (fileScan.hasNext()) {
            fileLineInput = fileScan.nextLine();
            if (!fileLineInput.isBlank()) {
                BaseWord newWord;
                if (fileLineInput.substring(0, 4).equals("der ")
                        || fileLineInput.substring(0, 4).equals("die ")
                        || fileLineInput.substring(0, 4).equals("das ")) {
                    newWord = new Nomen(fileLineInput); //definition
                } else if (fileLineInput.contains("|")) { //verb
                    newWord = new Verb(fileLineInput);
                } else { //not noun or verb
                    newWord = new BaseWord(fileLineInput);
                }
                System.out.println("Is this correct: \n\n" + newWord.toString() + "\n\n(only accepts \"n\" for no if wrong, otherwise type anything)");
                String inputString = inputScan.nextLine();
                if (inputString.toLowerCase().equals("n")) {
                    System.out.println("Would you like to fix this or skip this(f/s)");
                    inputString = inputScan.nextLine();
                    if(inputString.toLowerCase().equals("f")){
                        //TODO manual input
                    }
                } else {
                    System.out.println("accepted.");
                }
            }
        }
    }
}

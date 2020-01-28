import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class Wortimporteur {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("C:\\Users\\avann\\IdeaProjects\\Wortschatz\\src\\Neue Wörter.txt")), inputScan = new Scanner(System.in); //TODO make the file finding dynamic
        String fileLineInput;
        LinkedList<BaseWord> ll = new LinkedList<>();
        while (fileScan.hasNext()) {
            fileLineInput = fileScan.nextLine();
            if (!fileLineInput.isBlank()) {
                ll.add(getBaseWordFromFileLineInput(fileLineInput));
            }
        }
        practiceLoop(ll);
    }

    public static void practiceLoop(LinkedList<BaseWord> ll) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        Boolean flagNoun = true, flagNounPlural = false, flagArticles = false, flagVerb = true, flagVerbPastA = false, flagVerbPastB = false;
        boolean limitPracticeInputBad = true;
        while (limitPracticeInputBad) {
            System.out.println("Do you want to set flags?");
            userInput = scan.nextLine();
            switch (userInput.toLowerCase()) {
                case "y":
                    limitPracticeInputBad = false;
                    System.out.println("wow I don't want to code this, I'll come back to this later"); //TODO set flags with user input, maybe with String.contains();
                    userInput = scan.nextLine();
                    break;
                case "n":
                    limitPracticeInputBad = false;
                    break;
                default:
                    System.out.println("Please type \"y\" or \"n\"");
            }
        }
        Random rand = new Random();
        System.out.println(ll.size());
        while (true) {
            System.out.println(ll.get(rand.nextInt(ll.size())).toString());
            scan.next();
        }
    }

    private static BaseWord getBaseWordFromFileLineInput(String fileLineInput) {
        Scanner inputScan = new Scanner(System.in);
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
        return newWord;
    }

    public static BaseWord confirmWord(BaseWord newWord) {
        String inputString;
        boolean badInput = true;
        Scanner scan = new Scanner(System.in);
        do {
            assert newWord != null;
            System.out.println(newWord.toString()
                    + "\nPlease type \"y\" to accept, \"s\" to skip, or \"f\" to fix");
            inputString = scan.nextLine();
            switch (inputString.toLowerCase()) {
                case "y":
                    badInput = false;
                    System.out.println("Accepted.");
                    break;
                case "f":
                    boolean badInput2 = true;
                    do {
                        System.out.println("Is the word a noun(\"n\"), verb (\"v\"), or other (\"o\")?");
                        inputString = scan.nextLine();
                        switch (inputString.toLowerCase()) {
                            case "n":
                                badInput2 = false;
                                newWord = new Nomen();
                                break;
                            case "v":
                                badInput2 = false;
                                newWord = new Verb();
                                break;
                            case "o":
                                badInput2 = false;
                                newWord = new BaseWord();
                                break;
                            default:
                                System.out.println("Please type only \"n\", \"v\", or \"o\"");
                        }
                    } while (badInput2);
                    break;
                case "s":
                    badInput = false;
                    newWord = null;
                    System.out.println("cancelled out yo");
                    break;
                default:
                    System.out.println("Please type only \"y\", \"s\", or \"f\"");
            }
        } while (badInput);
        return newWord;
    }
}

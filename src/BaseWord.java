import java.util.Scanner;

public class BaseWord {

    WordType wordType;
    String baseWord, meaning;

    BaseWord(String baseWord, String meaning) {
        wordType = WordType.OTHER;
        this.baseWord = baseWord;
        this.meaning = meaning;
    }

    BaseWord(String fileLineInput) {
        this(fileLineInput.substring(0, fileLineInput.indexOf(" "))
                , fileLineInput.substring(fileLineInput.indexOf(" ") + 1));
    }

    BaseWord(){
        manuallySetVars();
    }

    public void manuallySetVars(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the word / phrase in German?");
        baseWord = scan.nextLine();
        System.out.println("What is the meaning in English?");
        meaning = scan.nextLine();
    }

    @Override
    public String toString() {
        return "Base Word: " + baseWord + "\nMeaning: " + meaning;
    }
}

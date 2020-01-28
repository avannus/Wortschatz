import java.util.Scanner;

public class Verb extends BaseWord {

    String pastA, pastB;
    WordType wordType;

    Verb(String baseWord, String pastA, String pastB, String meaning) {
        super(baseWord, meaning);
        wordType = WordType.VERB;
        this.pastA = pastA;
        this.pastB = pastB;
    }

    Verb(String fileLineInput) {
        this(fileLineInput.substring(0, fileLineInput.indexOf("[") - 1)
                , fileLineInput.substring(fileLineInput.indexOf("[") + 1, fileLineInput.indexOf("|") - 1)
                , fileLineInput.substring(fileLineInput.indexOf("|") + 2, fileLineInput.indexOf("]"))
                , fileLineInput.substring(fileLineInput.indexOf("]") + 2));
    }

    Verb(){
        manuallySetVars();
    }

    @Override
    public void manuallySetVars(){
        super.manuallySetVars();
        Scanner scan = new Scanner(System.in);
        System.out.println("What is pastA?"); //TODO define pastA and pastB
        pastA = scan.nextLine();
        System.out.println("What is pastB?");
        pastB = scan.nextLine();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\npastA: " + pastA
                + "\npastB: " + pastB;
    }

}

import java.util.Scanner;

public class Nomen extends BaseWord {

    WordType wordType;
    String article, plural;

    Nomen(String article, String baseWord, String plural, String meaning) {
        super(baseWord, meaning);
        wordType = WordType.NOUN;
        this.article = article;
        this.plural = plural;
    }

    Nomen(String fileLineInput) {
        this(fileLineInput.substring(0, 3)
                , fileLineInput.substring(4, fileLineInput.indexOf(" ", 4)) //noun
                , fileLineInput.substring(fileLineInput.indexOf("[") + 1, fileLineInput.indexOf("]")) //plural
                , fileLineInput.substring(fileLineInput.indexOf("]") + 2)); //definition
    }

    Nomen(){
        manuallySetVars();
    }

    public void checkNoun() { //TODO make a check thing for the user to override
        System.out.println(toString());
    }

    @Override
    public void manuallySetVars(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is article for this noun (der die oder das)?");
        article = scan.nextLine();
        super.manuallySetVars();
        System.out.println("What is the plural of this noun?");
        plural = scan.nextLine();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nArticle: " + article
                + "\nPlural: " + plural;
    }
}

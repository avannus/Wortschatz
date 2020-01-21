public class Nomen extends BaseWord {

    String article, plural;

    Nomen(String article, String baseWord, String plural, String meaning) {
        super(baseWord, meaning);
        this.article = article;
        this.baseWord = baseWord;
        this.plural = plural;
    }

    Nomen(String fileLineInput) {
        this(fileLineInput.substring(0, 3)
                , fileLineInput.substring(4, fileLineInput.indexOf(" ", 4)) //noun
                , fileLineInput.substring(fileLineInput.indexOf("[") + 1, fileLineInput.indexOf("]")) //plural
                , fileLineInput.substring(fileLineInput.indexOf("]") + 2)); //definition
    }

    public void checkNoun() { //TODO make a check thing for the user to override
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nArticle: " + article
                + "\nPlural: " + plural;
    }
}

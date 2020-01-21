public class Nomen {

    private String article, baseWord, plural, meaning;

    Nomen(String article, String baseWord, String plural, String meaning) {
        this.article = article;
        this.baseWord = baseWord;
        this.plural = plural;
        this.meaning = meaning;
    }

    public void checkNoun() { //TODO make a check thing for the user to override
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "NOUN. Article: " + article
                + ", Word: " + baseWord
                + ", Plural: " + plural
                + ", Meaning: " + meaning;
    }
}

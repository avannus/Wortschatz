public class Other {

    private String baseWord, meaning;

    Other(String baseWord, String meaning) {
        this.baseWord = baseWord;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "OTHER. Word: " + baseWord + ", Meaning: " + meaning;
    }
}
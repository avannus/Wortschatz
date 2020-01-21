public class BaseWord {

    String baseWord, meaning;

    BaseWord(String baseWord, String meaning) {
        this.baseWord = baseWord;
        this.meaning = meaning;
    }

    BaseWord(String fileLineInput) {
        this(fileLineInput.substring(0, fileLineInput.indexOf(" "))
                , fileLineInput.substring(fileLineInput.indexOf(" ") + 1));
    }

    @Override
    public String toString() {
        return "Base Word: " + baseWord + "\nMeaning: " + meaning;
    }

}

public class Verb {

    private String baseWord, pastA, pastB, meaning;

    Verb(String baseWord, String pastA, String pastB, String meaning) {
        this.baseWord = baseWord;
        this.pastA = pastA;
        this.pastB = pastB;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "VERB. Word: " + baseWord
                + ", pastA: " + pastA
                + ", pastB: " + pastB
                + ", Meaning: " + meaning;
    }

}

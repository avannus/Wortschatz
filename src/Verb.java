public class Verb extends BaseWord {

    String pastA, pastB;

    Verb(String baseWord, String pastA, String pastB, String meaning) {
        super(baseWord, meaning);
        this.pastA = pastA;
        this.pastB = pastB;
    }

    Verb(String fileLineInput) {
        this(fileLineInput.substring(0, fileLineInput.indexOf("[") - 1)
                , fileLineInput.substring(fileLineInput.indexOf("[") + 1, fileLineInput.indexOf("|") - 1)
                , fileLineInput.substring(fileLineInput.indexOf("|") + 2, fileLineInput.indexOf("]"))
                , fileLineInput.substring(fileLineInput.indexOf("]") + 2));
    }

    @Override
    public String toString() {
        return super.toString()
                + "\npastA: " + pastA
                + "\npastB: " + pastB;
    }

}

package studentroster;

public enum Standing{

    MIN_Freshmen(0, 'A', "Freshmen"),
    MIN_Sophomore(30, 'B', "Sophomore"),
    MIN_Junior(60,'C', "Junior" ),
    MIN_Senior(90, 'D', "Senior");

    public final int minCredits;
    public final char association;
    public final String year;

    private Standing(int minCredits, char association, String year) {
        this.minCredits = minCredits;
        this.association = association;
        this.year = year;
    }




}











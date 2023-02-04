package studentroster;

public enum Major {
    CS("01:198", "SAS"),
    MATH("01:640", "SAS"),
    EE("14:332", "SOE"),
    ITI("04:547", "SC&I"),
    BAIT("33:346", "RBS");

    private final String courseId;
    private final String school;

    Major(String courseId, String school){
        this.courseId = courseId;
        this.school = school;
    }

    String getSchool()
    {
        return school;
    }

    //ASK HER IF ENUM CLASSES HAVE THEIR OWN TO STRING: we're calling the toString in our Roster class




}

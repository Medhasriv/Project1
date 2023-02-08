package studentroster;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    public Student(Profile p, Major m, int credits)
    {
        this.profile = p;
        this.major = m;
        this.creditCompleted = credits;
    }

    public Student(Profile p)
    {
        this.profile = p;
        this.major = null;
        this.creditCompleted = 0;
    }

    public String getSchool()
    {
        return major.getSchool();
    }

    public Major getMajor()
    {
        return major;
    }

    public void setMajor(Major m){
        this.major = m;
    }

    public Profile getProfile(){
        return profile;
    }


    public int returnCredits(){
        return creditCompleted;
    }

    public char getStanding()
    {


        if(creditCompleted >= Standing.MIN_Freshmen.minCredits && creditCompleted <= Standing.MIN_Sophomore.minCredits )  //junior
        {
            return Standing.MIN_Freshmen.association;
        }
        if(creditCompleted >= Standing.MIN_Sophomore.minCredits && creditCompleted <= Standing.MIN_Junior.minCredits )  //junior
        {
            return Standing.MIN_Sophomore.association;  //senior = d
        }
        if(creditCompleted >= Standing.MIN_Junior.minCredits && creditCompleted <= Standing.MIN_Senior.minCredits )  //junior
        {
            return Standing.MIN_Junior.association; //senior = d
        }
        else
        {
             return Standing.MIN_Senior.association; //senior = d
        }

    }

    public String getYear()
    {
        if(creditCompleted >= Standing.MIN_Freshmen.minCredits && creditCompleted <= Standing.MIN_Sophomore.minCredits )  //junior
        {
            return Standing.MIN_Freshmen.year;
        }
        if(creditCompleted >= Standing.MIN_Sophomore.minCredits && creditCompleted <= Standing.MIN_Junior.minCredits )  //junior
        {
            return Standing.MIN_Sophomore.year;  //senior = d
        }
        if(creditCompleted >= Standing.MIN_Junior.minCredits && creditCompleted <= Standing.MIN_Senior.minCredits )  //junior
        {
            return Standing.MIN_Junior.year; //senior = d
        }
        else
        {
            return Standing.MIN_Senior.year; //senior = d
        }
    }



    @Override
    public String toString()
    {

        return profile.toString() +  " (" + this.major.getCourseId() + " " + this.major + " " + this.major.getSchool() + ") credits completed: " + creditCompleted; //add major to this
    }

    @Override
    public boolean equals(Object other) //Student other
    {

        if(other instanceof Student)
        {
            Student student = (Student) other;

            return this.profile.equals(student.profile)
                    && this.major.equals(student.major)
                    && this.creditCompleted == student.creditCompleted;
        }
        return false;



    }

    @Override
    public int compareTo(Student other)
    {
        if((this.profile.compareTo(other.profile))> 0)
        {
            return -1;
        }
        if((this.profile.compareTo(other.profile))< 0)
        {
            return 1;
        }

        return 0;

    }
}

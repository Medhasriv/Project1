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




    public int returnCredits()
    {
        return creditCompleted;
    }

    public String returnStanding()
    {
        final int MAX_FRESHMEN = 30;
        final int MAX_SOPHMORE = 60;
        final int MAX_JUNIOR = 90;

        if(creditCompleted >= MAX_JUNIOR)
        {
            return "senior";
        }
        else if(creditCompleted > MAX_SOPHMORE)
        {
            return "junior";
        }
        else if(creditCompleted > MAX_FRESHMEN)
        {
            return "sophmore";
        }
        else
        {
            return "freshmen";
        }
    }


    @Override
    public String toString()
    {
        return profile.toString() +  this.major; //add major to this
    }

    @Override
    public boolean equals(Student other)
    {
        boolean returnStatement = false;


        return this.profile.equals(other.profile)
                && this.major.equals(other.major)
                && this.creditCompleted == other.creditCompleted;

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

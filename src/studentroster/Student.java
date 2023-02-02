package studentroster;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    public boolean equals(Student other)
    {
        return this.profile.equals(other.profile)
                && this.major.equals(other.major)
                && this.creditCompleted == other.creditCompleted;

    }
    @Override
    public String toString()
    {
        return profile.toString() +  " "; //add major to this
    }
    @Override

    public int compareTo(Student other)
    {

        if(this.creditCompleted < (other.creditCompleted))
        {
            return -1;
        }
        if(this.creditCompleted > (other.creditCompleted))
        {
            return 1;
        }

        return 0;

    }
}

package studentroster;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    public boolean equals(Student other)
    {
        return this.fname.equals(other.fname)
                && this.lname.equals(other.lname)
                && this.dob.equals(other.dob);

    }

    public String toString()
    {
        return profile.toString();
    }

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

package studentroster;

public class Profile implements Comparable<Profile>{
    private String lname;
    private String fname;
    private Date dob;

    public Profile(String last, String first, Date d)
    {
        lname = last;
        fname = first;
    }

    public boolean equals(Profile p)
    {

    }
    @Override
    public String toString()
    {

        return lname + " " +  fname + " " + dob.toString();
    }


    @Override
    public int compareTo(Profile o) {
        return 0;
    }
}


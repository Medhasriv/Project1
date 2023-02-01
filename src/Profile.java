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

    public String toString()
    {

        return lname + " " +  fname + " " + dob;
    }

    public boolean compareTo()
    {

    }





}

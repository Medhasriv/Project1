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
        return this.fname.equals(p.fname)
                && this.lname.equals(p.lname)
                && this.dob.equals(p.dob);
    }
    @Override
    public String toString()
    {

        return lname + " " +  fname + " " + dob.toString();
    }


    @Override
    public int compareTo(Profile o) {
        if((this.lname.compareTo(other.lname))> 0) //pos means greater than 0; here we're comparing string compareTo
        {
            return -1;
        }
        else if((this.lname.compareTo(other.lname))< 0) //pos means greater than 0; here we're comparing string compareTo
        {
            return 1;
        }
        else if ((this.fname.compareTo(other.fanme))> 0)
        {
            return -1;
        }
        else if((this.fname.compareTo(other.fname))< 0)
        {
            return 1;
        }
        else if ((this.dob.compareTo(other.dob))< 0)
        {
            return -1;
        }
        else if ((this.dob.compareTo(other.dob))> 0)
        {
            return 1;
        }
        else
            return 0;

    }
}


/*

- what are we comparing for in profile?
-for date: do we need getter method? up to you!

 */
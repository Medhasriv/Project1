package studentroster;

public class Profile implements Comparable<Profile>{
    private String lname;
    private String fname;
    private Date dob;

    public Profile(String last, String first, Date d)
    {
        this.lname = last;
        this.fname = first;
        this.dob = d;
    }

    public int getAge()
    {
        int m = dob.getMonth();
        int y = dob.getYear();
        int d = dob.getDay();

        Date today = new Date();
        int monthToday = today.getMonth();
        int yearToday = today.getYear();
        int dayToday = today.getDay();


        int age = yearToday - y;

        if(m > monthToday)
        {
            age--;
        }
        else if(m == monthToday)
        {
            if(d > dayToday)
            {
                age--;
            }
        }
        return age;

    }

    @Override
    public boolean equals(Object p)
    {
        if(p instanceof Profile)
        {
            Profile profile = (Profile) p;
            return this.fname.equals(profile.fname)
                    && this.lname.equals(profile.lname)
                    && this.dob.equals(profile.dob);
        }
        return false;

    }
    @Override
    public String toString()
    {

        return fname + " " +  lname + " " + dob.toString();
    }


    @Override
    public int compareTo(Profile other) {
        if((this.lname.compareTo(other.lname))> 0) //pos means greater than 0; here we're comparing string compareTo
        {
            return -1;
        }
        else if((this.lname.compareTo(other.lname))< 0) //pos means greater than 0; here we're comparing string compareTo
        {
            return 1;
        }
        else if ((this.fname.compareTo(other.fname))> 0)
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



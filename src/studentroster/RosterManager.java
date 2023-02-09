package studentroster;
import java.util.Scanner;
import java.util.StringTokenizer;
public class RosterManager {
    Scanner input  = new Scanner(System.in);
    Roster newRoster = new Roster();

    public void run()
    {
        System.out.print("Roster Manager running...\n");
        String inputString;
        boolean checkQuit = false;


        while((input.hasNext()) && !checkQuit) {
            inputString = input.nextLine();
            if(inputString.equals("Q")) {
                System.out.print("Roster Manager terminated");
                checkQuit = true;
                break;
            } else {
                assignValues(inputString);
            }
        }
        input.close();
    }
    public void assignValues(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, " ");

        //this list will be used
        String[] majorList = {"CS", "EE","ITI", "BAIT","MATH"};
        String action = st.nextToken();


        if(action.equals("A")) {
            //string tokenizer to divide up the string

            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String major = st.nextToken().toUpperCase();
            int credits = Integer.parseInt((st.nextToken()));

            //current date + checking if valid
            Date d = new Date(dob);
            boolean isValid = d.isValid();

            //making a student profile and age is valid
            Profile thisStudent = new Profile(lastName, firstName, d);
            int age = thisStudent.getAge();

            //checking if major exists
            boolean containsMajor = false;
            for(int i=0; i<majorList.length; i++){
                if(majorList[i].equals(major)){
                    containsMajor = true;
                }
            }

            //checking for valid DOB + age, adding an ENUM if this exists
            if(age > 16){
                    if (isValid) {
                        if (containsMajor) {
                            Major studentMajorEnum = Major.valueOf(major);
                            //making sure credits are positive
                            if (credits >= 0) {
                                //checking if student is in the roster, then adding student meeting all requirements
                                Student newStudent = new Student(thisStudent, studentMajorEnum, credits);
                                if (!newRoster.contains(newStudent)) {
                                    newRoster.add(newStudent);
                                    System.out.println(thisStudent.toString() + " added to the roster.");
                                }else{
                                    System.out.println(thisStudent.toString()+" is already in the roster.");
                                }
                            }else{
                                System.out.println("Credits completed invalid: cannot be negative!");
                            }
                        }else{
                            System.out.println("Major code invalid:" + major.toString());
                        }
                }else{
                        System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                    }
            }else{
                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
            }

        } else if(action.equals("R")) {
            //string tokenizer takes in first name, last name, date of birth
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();

            //making the Date, Profile, and Student
            Date RMDate = new Date(dob);
            Profile RMProfile = new Profile(lastName, firstName, RMDate);
            Student RMStudent = newRoster.ProfileToStudent(RMProfile);
            boolean isRemoved = newRoster.remove(RMStudent);
            if(isRemoved) {
                System.out.println(RMProfile.toString() + " removed from the roster.");
            }else{
                System.out.println(RMProfile.toString() + " is not in the roster.");
            }
        } else if(action.equals("P")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty");
            }
            else
            {
                newRoster.print();
            }
        } else if(action.equals("PS")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                newRoster.printByStanding();
            }
        } else if(action.equals("PC")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                newRoster.printBySchoolMajor();
            }
        } else if(action.equals("L")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                String schoolName = st.nextToken().toUpperCase();
                newRoster.printBySchool(schoolName);
            }

        } else if(action.equals("C")) {
            //takes in info about student
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String newMajor = st.nextToken();

            //making the Date & Profile
            Date CDate = new Date(dob);
            Profile CProfile = new Profile(lastName, firstName, CDate);
            Major MajorEnum = Major.valueOf(newMajor);

            //Changing the major of the student
            boolean isChanged = newRoster.ChangeMajor(CProfile, MajorEnum);
            if(isChanged){
                System.out.println(CProfile.toString() +" major changed to " + newMajor.toString());
            }else{
                System.out.println("Student not found");
            }
        } else if(action.equals("Q")) {
            System.out.println("Roster Manager terminated.");
            return;
        }else {
            System.out.println(action.toString() + " is an invalid command!");
        }

    }
}

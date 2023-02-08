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


        while((input.hasNext())) { //IMPORTANTE! fix how to quit
            System.out.println();
            inputString = input.nextLine();
            if(inputString.equals("Q")) {
                System.out.print("Roster Manager terminated");
                input.close();
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
            if(age > 16 && isValid && containsMajor){
                Major studentMajorEnum = Major.valueOf(major);
                //making sure credits are positive
                if(credits>=0){
                    //checking if student is in the roster, then adding student meeting all requirements
                    Student newStudent = new Student(thisStudent, studentMajorEnum, credits);
                    if(!newRoster.contains(newStudent)){
                        newRoster.add(newStudent);
                    }
                }
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
            newRoster.remove(RMStudent);
        } else if(action.equals("P")) {
            newRoster.print();
        } else if(action.equals("PS")) {
            newRoster.printByStanding();
        } else if(action.equals("PC")) {
            newRoster.printBySchoolMajor();
        } else if(action.equals("L")) {
            String schoolName = st.nextToken().toUpperCase();
            newRoster.printBySchool(schoolName);
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
            newRoster.ChangeMajor(CProfile, MajorEnum);
        } else if(action.equals("Q")) {
            System.out.println("Roster Manager terminated.");
            return;
        }

    }
}

package studentroster;
import java.util.Scanner;
import java.util.StringTokenizer;
public class RosterManager {
    Scanner input  = new Scanner(System.in);
    System.out.print("Roster Manager running...");

    public void run()
    {
        String inputString;
        while(input.hasNext()) {
            inputString = input.nextLine();
            if(inputString.equals("Q")) {
                System.out.print("Roster Manager terminated");
                input.close();
            }
            else {
                assignValues(inputString);
            }
        }
    }
    public int assignValues(String inputString)
    {

        StringTokenizer st = new StringTokenizer(inputString, " ");


        if(st.nextToken().equals("A")) {
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String major = st.nextToken();
            int credits = Integer.parseInt((st.nextToken()));

            Date d = new Date(dob);
            Profile thisStudent = new Profile(lastName, firstName, dob);

            boolean isValid = d.isValid();
            boolean isOldEnough = false;

            int age = thisStudent.getAge();

            if(age > 16)
            {
                isOldEnough = true;
            }





        }
        if(st.nextToken().equals("R")) {

        }
        if(st.nextToken().equals("P")) {

        }
        if(st.nextToken().equals("PS")) {

        }
        if(st.nextToken().equals("L")) {

        }
        if(st.nextToken().equals("C")) {

        }
        if(st.nextToken().equals("Q")) {

        }
    }
}

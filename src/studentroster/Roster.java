package studentroster;

import studentroster.Student;

public class Roster {
    private Student[] roster;
    private int size;
    private int find(Student student) {
        //ASK DOES THIS NEED TO BE "CONST INT" OR "FINAL INT" OR JUST "INT"
        int NOT_FOUND = -1;
        for(int i=0; i<size-1; i++){
            if(roster[i].equals(student)){
                return i;
            }
        }
        return NOT_FOUND;
    } //search the given student in roster



    private void grow() {

    } //increase the array capacity by 4

    public int getSize()
    {
        return size;
    }


    public boolean add(Student student){
        for(int i=0; i<size; i++){
            if(roster[i].equals(null)){
                roster[i]= student;
                size++;
                return true;
            }
        }
        return false;
    } //add student to end of array
    public boolean remove(Student student){
        for(int i=0; i<size-1; i++){
            if(roster[i].equals(student)){
                roster[i] = null;
                for(int j = i; j<size-1; j++){
                    roster[j] = roster[j+1];
                }
                roster[size-1] = null;
                size--;
                return true;
            }
        }
        return false;
    }//maintain the order after remove
    public boolean contains(Student student){
        for(int i=0; i<size-1; i++){
            if(roster[i].equals(student)){
                return true;
            }
        }
        return false;
    } //if the student is in roster



    public void print () {
        //selection sort on print...not sure if this works
        for(int i=0; i<roster.length-1; i++){
            int min = i;
            for(int j=1+i; j<roster.length; j++){
                if(roster[j].compareTo(roster[min])==-1){
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<roster.length; k++){
            System.out.println(roster[k]);
        }
    } //print roster sorted by profiles
    public void printBySchoolMajor() {

        //figure out priority so is profile, major, or credit completed most important
        //the answer:student, then major, then credits


        for(int i=0; i<roster.length-1; i++){
            int min = i;
            for(int j=1+i; j<roster.length; j++){

                if(roster[j].getMajor().toString().compareTo(roster[min].getMajor().toString()) ==-1){
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<roster.length; k++){
            System.out.println(roster[k]);
        }


    } //print roster sorted by school major

    public void printBySchool(String school)
    {

        for(int i=0; i < roster.length; i++)
        {
            if(roster[i].getSchool().equals(school))
            {
                System.out.println((roster[i]));
            }
        }

    }


    public void printByStanding() {
        for(int i=0; i<roster.length-1; i++){
            int min = i;
            for(int j=1+i; j<roster.length; j++){

                if(roster[j].returnStanding().compareTo(roster[min].returnStanding())==-1){

                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<roster.length; k++){
            System.out.println(roster[k]);
        }

    } //print roster sorted by standing

    public void ChangeMajor(Student s, Major newMajor){
        int StudentIndex = find(s);
        roster[StudentIndex].setMajor(newMajor);
    }
}

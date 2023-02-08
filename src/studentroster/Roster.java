package studentroster;

import studentroster.Student;

public class Roster {
    private Student[] roster;
    private int size;

    public Roster()
    {
        this.roster = roster;
        this.size = size;
    }

    public Roster(Student[] r, int s)
    {
        this.roster = r;
        this.size = s;
    }
    private int find(Student student) {
        //ASK DOES THIS NEED TO BE "CONST INT" OR "FINAL INT" OR JUST "INT"
        int NOT_FOUND = -1;
        for(int i=0; i<size; i++){
            if(roster[i].equals(student)){
                return i;
            }
        }
        return NOT_FOUND;
    } //search the given student in roster



    private void grow() {
        Student[] newArray = new Student[size + 4];

        if(roster!= null)
        {
            for(int i =0; i<=size; i++)
            {
                newArray[i] = roster[i];
            }
        }


        roster = newArray;
    } //increase the array capacity by 4

    public int getSize()
    {
        return size;
    }


    public boolean add(Student student){
       if(roster == null){
           grow();
       }
        if (roster.length -1 ==size){
            grow();
        }
        roster[size] = student;
        size++;

        return true;
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
            if(find(student)!=-1){
                return true;
            }
        }
        return false;
    } //if the student is in roster

    public Student ProfileToStudent(Profile p){
        for(int i=0; i<size; i++){
            if(roster[i].getProfile().toString().equals(p.toString())) {
                return roster[i];
            }
        }
        return null;
    }

    public void print () {
        //selection sort on print...not sure if this works
        for(int i=0; i<size; i++){
            int min = i;
            for(int j=1+i; j<size; j++){
                if((roster[j].compareTo(roster[min]))== -1){
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<size; k++){
            System.out.println(roster[k]);
        }

    } //print roster sorted by profiles
    public void printBySchoolMajor() {

        //figure out priority so is profile, major,xs or credit completed most important
        //the answer:student, then major, then credits

        for(int i=0; i<size; i++){
            int min = i;
            for(int j=1+i; j<size; j++){
                String schoolMajorJ = roster[j].getSchool() +  roster[j].getMajor().toString();
                String schoolMajorMin = roster[min].getSchool() + roster[min].getMajor().toString();

                if(schoolMajorJ.compareTo(schoolMajorMin) <0)
                {
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<size; ++k){
            System.out.println(roster[k]);
        }


    } //print roster sorted by school major

    public void printBySchool(String school)  //ex L SAS
    {

        for(int i=0; i < size; i++)
        {
            if(roster[i].getSchool().equals(school))
            {
                System.out.println((roster[i]));
            }
        }

    }


    public void printByStanding() {
        for(int i=0; i<size; i++){
            int min = i;
            for(int j=1+i; j<size; j++){

                if(roster[j].returnCredits() <= (roster[min].returnCredits())){

                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for(int k=0; k<size; k++){


            System.out.println(roster[k] + roster[k].returnCredits() + "(" + roster[k].getStanding() + ")" );
        }

    } //print roster sorted by standing

    public void ChangeMajor(Profile p, Major newMajor){
        //find in roster based on profile
        for(int i=0; i<size; i++){
            if(roster[i].getProfile().toString().equals(p.toString())){
                roster[i].setMajor(newMajor);
                return;
            }
        }
        System.out.println("Student not found");
    }
}


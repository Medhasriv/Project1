package studentroster;

import studentroster.Student;

public class Roster {
    private Student[] roster;
    private int size;
    private int find(Student student) {
        for(int i=0; i<size-1; i++){
            if(roster[i]==student){
                return i;
            }
        }
        return 0;
    } //search the given student in roster
    private void grow() {} //increase the array capacity by 4
    public boolean add(Student student){
        for(int i=0; i<size; i++){
            if(roster[i]==null){
                roster[i]= student;
                size++;
                return true;
            }
        }
        return false;
    } //add student to end of array
    public boolean remove(Student student){
        for(int i=0; i<size-1; i++){
            if(roster[i]==student){
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
            if(roster[i]==student){
                return true;
            }
        }
        return false;
    } //if the student is in roster
    public void print () {

    } //print roster sorted by profiles
    public void printBySchoolMajor() {} //print roster sorted by school major
    public void printByStanding() {} //print roster sorted by standing
}

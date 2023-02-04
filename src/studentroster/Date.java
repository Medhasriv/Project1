package studentroster;
import java.util.Calendar;

public class Date implements Comparable<Date> {
        private int year;
        private int month;
        private int day;



        public Date() {
                Calendar today = Calendar.getInstance();
                int year = today.get(Calendar.YEAR);
                int month = today.get(Calendar.MONTH) +1;
                int day = today.get(Calendar.DATE);

        } //create an object with today’s date (see Calendar class)
        public Date(int y, int m, int d) {
                year = y;
                month = m;
                day = d;
        } //take “mm/dd/yyyy” and create a Date object

        public int getYear(){
                return year;
        }

        public int getMonth(){
                return month;
        }

        public int getDay(){
              return day;
        }
        public Date(String date) {
                String[] arrOfStr = date.split("/", 3);

                String m = (arrOfStr[0]);
                String d= (arrOfStr[1]);
                String y = (arrOfStr[2]);

                 month = Integer.parseInt(m);
                 day = Integer.parseInt(d);
                 year = Integer.parseInt(y);
        }



        public boolean isValidMonth() {
                if(month >= 1 && month <=12) {
                        return true;
                }
                return false;
        }


        public boolean isValidDay() {
                if ( (month == Calendar.JANUARY || month == Calendar.MARCH || month == Calendar.MAY || month == Calendar.JUlY|| month == Calendar.AUGUST || month == Calendar.AUGUST || month == Calendar.DECEMBER) && ((day<=31) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == Calendar.APRIL|| month == Calendar.JUNE || month == Calendar.SEPTEMBER || month == Calendar.NOVEMBER) && ((day<=30) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == Calendar.FEBRUARY) && ( isLeapYear()) && ((day<=29) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == Calendar.FEBRUARY) && ( !isLeapYear()) && ((day<=28) && (day>=1)) )
                {
                        return true;
                }
                else
                {
                        return false;
                }


        }

        public boolean isLeapYear() {

                final int QUADRENNIAL = 4;
                final int CENTENNIAL = 100;
                final int QUATERCENTENNIAL = 400;
                boolean isLeapYear;

                if(year/QUADRENNIAL == 1) {
                        isLeapYear = false;
                }
                if(year/CENTENNIAL == 1) {
                        isLeapYear = true;
                }

                if(year/QUATERCENTENNIAL == 1) {
                        isLeapYear = false;
                }

        }

        public boolean isValid() {
                if(this.isValidDay() && this.isValidMonth() ) {
                        return true;
                }
                return false;
        } //check if a date is a valid calendar date


        @Override
        public String toString() {
                return month + "/" + day + "/" + year;
        }

        @Override
        public boolean equals(Date other) {

                return (
                        this.day == other.day &&
                                this.month == other.month &&
                                this.year == other.year
                );
        }
        //ASK HER - do I need to remove override command here? Why am I having problems with equal override method




        @Override
        public int compareTo(Date other) {
                if(this.year> other.year)
                {
                        return 1;
                }
                else if(this.year<other.year)
                {
                        return -1;
                }
                else if(this.month> other.month)
                {
                        return 1;
                }
                else if(this.month < other.month)
                {
                        return -1;
                }
                else if (this.day>other.month)
                {
                        return 1;
                } else if (this.day<other.month) {
                        return 1;
                }
                return 0;
        }
}


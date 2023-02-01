package studentroster;

public class Date implements Comparable<Date> {
        private int year;
        private int month;
        private int day;

        public static final int QUADRENNIAL = 4;
        public static final int CENTENNIAL = 100;
        public static final int QUATERCENTENNIAL = 400;

        public Date() {

        } //create an object with today’s date (see Calendar class)
        public Date(int y, int m, int d) {
                year = y;
                month = m;
                day = d;
        } //take “mm/dd/yyyy” and create a Date object


        public Date(String date) {
                Date object = new Date();

        }


        public boolean isValidMonth() {
                if(month >= 1 && month <=12) {
                        return true;
                }
                return false;
        }

        public boolean isValidDay() {
                if ( (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && ((day<=31) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == 4 || month == 6 || month == 9 || month == 11) && ((day<=30) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == 2) && ( isLeapYear = true) && ((day<=29) && (day>=1)) )
                {
                        return true;
                }
                else if ( (month == 2) && ( isLeapYear = false) && ((day<=28) && (day>=1)) )
                {
                        return true;
                }
                else
                {
                        return false;
                }


        }

        public boolean isLeapYear() {
                boolean isLeapYear;

                if(year/4 == 1) {
                        isLeapYear = false;
                }
                if(year/100 == 1) {
                        isLeapYear = true;
                }

                if(year/400 == 1) {
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
                return month + "/" + date + "/" + year;
        }

        @Override
        public boolean equals(Date other) {
               return ((this.day == other.day) && (this.date == other.date)
                       && (this.year == other.year));

        }



        @Override
        public int compareTo(Date o) {
                return 0;
        }
}
}

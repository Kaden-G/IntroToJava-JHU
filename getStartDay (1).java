   /** getStartDay
    * The method getStartDay() implements Zeller's Algorithm for determining the
    * day of the week the first day of a month is. The method adjusts Zeller's
    * numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform
    * to day of week number that corresponds to ISO conventions (i.e.,
    * 1=Monday, ..., 7=Sunday)
    *
    * Pre-Conditions: The month value, m, is 1-12 The day value, d, is 1-31, or
    * 1-28, 1-29 for February The year value, y, is the full year (e.g., 2012)
    *
    * Post-Conditions: A value of 1-7 is returned, representing the first day of
    * the month 1 = Monday, ..., 7 = Sunday
    *
    * Reference: https://codereview.stackexchange.com/questions/67722/its-friday-zellers-congruence-revisited
    *
    * @param month
    * @param year
    * @return dayNum (1 = Mon, ... , 7 = Sun )
    *
    * precondition: month, year, and day are integer types
    *
    * @author: rolfl, modified by Josh Lafond
    */
   public int getStartDay(int month, int year) {
      // Adjust month number & year to fit Zeller's numbering system
      if (month < 3) {
         month += 12;
         year -= 1;
      }

      int centuryYear = year % 100;    // Calculate year within century
      int centuryTerm = year / 100;    // Calculate century term
      int firstDayInMonth = 0;         // Day number of first day in month 'm'

      firstDayInMonth = (1 + // to shift index 0 to the 1-7 return range
         (13 * (month + 1) / 5)
         + centuryYear +
         (centuryYear / 4) +
         (centuryTerm / 4) +
         (5 * centuryTerm)) % 7;

      // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
      int dayNum = ((firstDayInMonth + 5) % 7) + 1;

      return dayNum;
   } // end getStartDay()
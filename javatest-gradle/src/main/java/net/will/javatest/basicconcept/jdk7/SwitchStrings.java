package net.will.javatest.basicconcept.jdk7;

public class SwitchStrings {
    public String getShortNameOfWeekDay(String dayOfWeek) {
        String shortName = "";
        switch (dayOfWeek) {
            case "Monday":
                shortName = "Mon";
                break;
            case "Tuesday":
                shortName = "Tue";
                break;
            case "Wednesday":
                shortName = "Wed";
                break;
            case "Thursday":
                shortName = "Thu";
                break;
            case "Friday":
                shortName = "Fri";
                break;
            case "Saturday":
                shortName = "Sat";
                break;
            case "Sunday":
                shortName = "Sun";
                break;
            default:
                shortName = "";
                break;
        }
        return shortName;
   }
}

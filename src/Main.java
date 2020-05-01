import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int day;

        int month;

        int year;

        int input;

        int answer;

        Scanner keyboard = new Scanner(System.in);

        do {

            System.out.println("Monday's child is fair of face,");
            System.out.println("Tuesday's child is full of grace,");
            System.out.println("Wednesday's child is full of woe,");
            System.out.println("Thursday's child has far to go.");
            System.out.println("Friday's child is loving and giving,");
            System.out.println("Saturday's child works hard for a living,");
            System.out.println("But the child born on the Sabbath Day,");
            System.out.println("Is fair and wise and good in every way.");
            System.out.println(" ");
            System.out.print("What year were you born?: ");
            year = keyboard.nextInt();
            System.out.println(" ");
            System.out.print("What month were you born?: ");
            month = keyboard.nextInt();
            System.out.println(" ");
            System.out.print("What is the day that you were born?: ");
            day = keyboard.nextInt();
            System.out.println(" ");

            input = amountOfDaysInMonth(month, year);
            System.out.println("There are " + input + " days in the month");
            System.out.println(" ");

            int answer2 = ZellerCongurence(month, year, day);
            System.out.println(answer2);

            String answer3 = MonthPoem(answer2);
            System.out.println(answer3);

            System.out.println(" ");
            System.out.println("Do you want to go again? \"1\" for yes, \"2\" for no!");
            System.out.print(">");

            answer = keyboard.nextInt();

        }

        while (answer == 1);

    }

    public static int amountOfDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3:
            case 5: case 8:
            case 9: case 10:
            case 12:
                return 31;


            case 4: case 6:
            case 7: case 11:
                return 30;

            default:
                if ((year % 100 == 0 && year % 400 == 0) || (!(year % 100 == 0) && year % 4 ==0)) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }

    public static int ZellerCongurence(int month, int year, int day) {

        if (month == 1 || month == 2) {
            month = (month + 12);
            year--;
        }

        int yearZeroBased;
        yearZeroBased = (year / 100);

        int zellerCongurenceFormula;
        zellerCongurenceFormula = 13 * (month + 1);

        int yearOfCentury;
        yearOfCentury = (year % 100);

        int dayOfWeek;
        dayOfWeek = ((day + ((zellerCongurenceFormula) / 5)
                + yearOfCentury + (yearOfCentury / 4)
                + ((yearZeroBased) / 4) +
                (5 * (yearZeroBased))) % 7);

        return dayOfWeek;
    }

    public static String MonthPoem(int day) {
        switch (day) {
            case 2:
                return "You were born on a Monday "
                 + "According to the poem you are fair of face";
            case 3:
                return "You were born on a Tuesday "
                + "According to the poem you are full of grace";
            case 4:
                return "You were born on a Wednesday "
                + "According to the poem you are full of woe";
            case 5:
                return "You were born on a Thursday "
                + "According to the poem you have far of go";
            case 6:
                return "You were born on a Friday "
                + "According to the poem you are loving and giving";
            case 0:
                return "You were born on a Saturday "
                + "According to the poem you work hard for a living";
            default:
                return "You were born on a Sunday "
                + "According to the poem you are fair and wise in every way";
             }
        }
    }
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int day;

        int month;

        int year;

        int i = 0;

        int a = 1;

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

            System.out.println("What year were you born?");
            year = keyboard.nextInt();
            System.out.println("What month were you born?");
            month = keyboard.nextInt();
            System.out.println("What is the day that you were born?");
            day = keyboard.nextInt();

            int answer = amountOfDaysInMonth(month, year);
            System.out.println("There are " + answer + " days in the month");


            int answer2 = ZellerCongurence(month, year, day);
            System.out.println(answer2);

            String answer3 = MonthPoem(answer2);
            System.out.println(answer3);

            a++;

            System.out.println(" ");
            System.out.println("Do you want to go again? \"yes\" or \"no\".");

            String input = keyboard.nextLine();

            if(input.equalsIgnoreCase("yes")) {

                i++;

            }

            else if(input.equalsIgnoreCase("no")) {

                a++;
                System.out.println("Thank You For Playing!");

            }

            else {

                System.out.println(" ");

                System.out.println("You did not follow directions!");

                System.out.println(" ");

                System.out.println("Thank You For Playing!");

            }

        } while (i >= a);

    }

    public static int amountOfDaysInMonth(int month, int year) {
        switch (month) {
            //January
            case 1:
                return 31;
            //February
            case 2:
                if ((year % 100 == 0 && year % 400 == 0) || (!(year % 100 == 0) && year % 4 == 0)) {
                    return 29;
                }   else { return 28; }
                //March
            case 3:
                return 31;
            //April
            case 4:
                return 30;
            //May
            case 5:
                return 31;
            //June
            case 6:
                return 30;
            //July
            case 7:
                return 31;
            //August
            case 8:
                return 31;
            //September
            case 9:
                return 30;
            //October
            case 10:
                return 31;
            //November
            case 11:
                return 30;
            //December
            case 12:
                return 31;
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
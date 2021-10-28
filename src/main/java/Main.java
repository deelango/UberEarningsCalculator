import com.java.features.*;
import java.util.Scanner;
import java.time.*;

public class Main {
  static TotalKmsDriven totalKms = new TotalKmsDriven();
  static TotalHoursWorked totalHoursWorked = new TotalHoursWorked();
  static Gas moneySpentOnGas = new Gas();
  static TotalEarned totalMoneyEarned = new TotalEarned();
  DayOfWeek dayOfWeeks;

  public Main() {}

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the day of the week (ex. Monday): ");
    String dayOfWeek = scan.nextLine();
    //int day = DayOfWeek.getValue(dayOfWeek);
    System.out.println("Integer value: " + DayOfWeek.of(day));
    //DayOfWeek dayOfWeeks = DayOfWeek.from(dayOfWeek);

    //System.out.println("Record for " + DayOfWeek.from());

    // Total Hours Driven
    System.out.println("Please enter the total amount of hours driven:");
    double inputTotalHoursWorked = scan.nextDouble();
    while (!parseInput(inputTotalHoursWorked)) {
      System.out.println("Please enter a valid entry!");
      inputTotalHoursWorked = scan.nextDouble();
    }
    System.out.println(totalHoursWorked.getTotalHoursWorked(inputTotalHoursWorked));

    // Total Kms Driven
    System.out.println("Please enter the total amount of kms driven:");
    double inputTotalKms = scan.nextDouble();
    while (!parseInput(inputTotalKms)) {
      System.out.println("Please enter a valid entry!");
      inputTotalKms = scan.nextDouble();
    }
    System.out.println(totalKms.getTotalKms(inputTotalKms));

    // Total Money spent on Gas
    System.out.println("Please enter the total amount of money you have spent on Gas:");
    double inputMoneySpentOnGas = scan.nextDouble();
    while (!parseInput(inputMoneySpentOnGas)) {
      System.out.println("Please enter a valid entry!");
      inputMoneySpentOnGas = scan.nextDouble();
    }
    System.out.println(moneySpentOnGas.getGasMoney(inputMoneySpentOnGas));

    // Total Money Earned
    System.out.println("Please enter the total amount of money you have earned:");
    double inputTotalMoneyEarned = scan.nextDouble();
    while (!parseInput(inputTotalMoneyEarned)) {
      System.out.println("Please enter a valid entry!");
      inputTotalMoneyEarned = scan.nextDouble();
    }
    System.out.println(totalMoneyEarned.getTotalMoneyEarned(inputTotalMoneyEarned));
  }

  public double getHourlyRate(double hourlyRate) {
    return (totalMoneyEarned.getTotalMoneyEarned(20)) / (totalHoursWorked.getTotalHoursWorked(20));
  }

  public static boolean parseInput(double value) {
    if (!(value < 0) && (value >= 0 && value <= 500)) {
      return true;
    } else {
      return false;
    }
  }

  public static int getDayOfWeekInteger(DayOfWeek dayOfWeek) {
    return dayOfWeek.getValue();
  }

}

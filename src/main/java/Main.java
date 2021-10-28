import com.java.features.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoField;

public class Main {
  static TotalKmsDriven totalKms = new TotalKmsDriven();
  static TotalHoursWorked totalHoursWorked = new TotalHoursWorked();
  static Gas moneySpentOnGas = new Gas();
  static TotalEarned totalMoneyEarned = new TotalEarned();

  public Main() {}

  public static void main(String[] args) throws ParseException {
    Scanner scan = new Scanner(System.in);

    // Configuring the date of entry
    System.out.println("Is the entry for today? [y/n]");
    String whichDate = scan.nextLine();
    while (!((whichDate.equals("y"))||(whichDate.equals("Y"))||(whichDate.equals("n"))||(whichDate.equals("N")))) {
      System.out.println("Please enter a valid entry!");
      whichDate = scan.nextLine();
    }
    // Date output in format "YYYY MM DD"
    if ((whichDate.equals("y"))||(whichDate.equals("Y"))) {
      LocalDate date = LocalDate.now();
      DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
      String text = date.format(dateFormatter);
      System.out.println(text);
    } else {
      // Date output in format "YYYY MM DD"
      System.out.println("Enter the day in number:");
      int day= scan.nextInt();
      System.out.println("Enter the Month in number");
      int month= scan.nextInt( );
      System.out.println("Enter the Year in number format");
      int year= scan.nextInt( );
      String date = String.format("%d %d %d",year, month, day);
      System.out.println(date);
    }

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

}

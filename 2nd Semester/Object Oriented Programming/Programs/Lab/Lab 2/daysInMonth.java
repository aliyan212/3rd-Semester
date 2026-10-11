package Lab;

import java.util.Scanner;

public class daysInMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter month number (1-12): ");
		int month = sc.nextInt();

		int days;
		switch (month) {
			case 1:
				days = 31;
				break;
			case 2:
				days = 28;
				break;
			case 3:
				days = 31;
				break;
			case 4:
				days = 30;
				break;
			case 5:
				days = 31;
				break;
			case 6:
				days = 30;
				break;
			case 7:
				days = 31;
				break;
			case 8:
				days = 31;
				break;
			case 9:
				days = 30;
				break;
			case 10:
				days = 31;
				break;
			case 11:
				days = 30;
				break;
			case 12:
				days = 31;
				break;
			default:
				System.out.println("Invalid month. Please enter a number from 1 to 12.");
				return;
		}

		System.out.println("Number of days: " + days);
	}
}

package hibernateapplication;

import java.util.Scanner;

public class AllCrudOperationDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to add student");
		System.out.println("Enter 2 to fetch student");
		System.out.println("Enter 3 to update student");
		System.out.println("Enter 4 to delete student");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			AllCrudOperation.insert();
			break;
		case 2:
			AllCrudOperation.display();
			break;
		case 3:
			AllCrudOperation.update();
			break;
		case 4:
			AllCrudOperation.delete();
			break;
		default:
			System.out.println("invalid id");
			main(args);
		}

	}
}

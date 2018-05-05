import java.util.Scanner;

public class MenuController {
	private Scanner input;
	Gym gym;

	public MenuController()//takes in gym detales
	{
		input = new Scanner(System.in);
		
		System.out.println("Please enter the Gym...");
		System.out.print(" \t Name:");
		String gymName = input.nextLine();
		System.out.print("\t Manager Name: ");
		String managerName = input.nextLine();
		System.out.print("\t Phone number: ");
		String phoneNumber = input.nextLine();
		gym = new Gym(gymName,managerName,phoneNumber);
	}


	public static void main(String args[])
	{
		MenuController app = new MenuController();
		app.run();
	}

	private int mainMenu()//makes the main menu
	{
		System.out.println("Gym Menu");
		System.out.println("  -------------------------");
		System.out.println("  1) Add a member");
		System.out.println("  2) List all memberss");
		System.out.println("  3) Remove a member (by index)");
		System.out.println("  4) Number of members in the gym");
		System.out.println("  -------------------------");
		System.out.println("  5) List gym details");
		System.out.println("  6) List members with ideal starting weight");
		System.out.println("  7) List members with a specific BMI category");
		System.out.println("  8) List all members stats imperically and metrically");
		System.out.println("  -------------------------");
		System.out.println("  9) Save to XML");
		System.out.println("  10) Load from XML");
		System.out.println("  0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();//takes input
		return option;
	}

	private void run() //acts acording to input
	{
		int option = mainMenu();
		while (option != 0)
		{
			switch (option)
			{
			case 1:
				addMember();
				break;
			case 2:
				System.out.println(gym.listMembers());
				break;
			case 3:
				System.out.println(gym.listMembers());
				System.out.print("\n\n Index of member to delete ==> ");
				int index = input.nextInt();
				gym.remove(index);
				break;
			case 4:
				System.out.println("Number of members: "+gym.numberOfMembers());
				break;
			case 5: 
				System.out.println(gym.toString());
				break;
			case 6: 
				System.out.println(gym.listMembersWithIdealWeight());
				break;
			case 7:
				System.out.print("pleas enter desiered BMi ==> ");
				String cat = input.nextLine();
				cat = input.nextLine();
				System.out.println(gym.listBySpecificBMICategory(cat));
				break;
			case 8:
				System.out.print(gym.listMemberDetailsImperialAndMetric());
				break;
			case 9:
				try{
					gym.save();
				}
				catch(Exception e){
					System.out.println("Error writing to file: " + e);
				}
				break;
			case 10:
				try{
					gym.load();
				}
				catch(Exception e){
					System.out.println("Error reading from file: " + e);
				}
				break;
			default:
				System.out.println("Invalid option selected.");
				break;
			}

			//display the main menu again
			System.out.println("");
			option = mainMenu();
		}
		System.out.println("Exiting... bye");
	}

	private void addMember() //adds member
	{
		System.out.println("Please enter the following member details");
		System.out.print("\t Id (between 100001 and 999999): ");
		int Id = input.nextInt();
		
		System.out.print("\t Name (max 30 chars): ");
		String Name = input.nextLine();
		Name = input.nextLine();
		 
		System.out.print("\t Address: ");
		String Address = input.nextLine();
		
		System.out.print("\t Height (between 1 and 3 meters): ");
		double Height = input.nextDouble();
		
		System.out.print("\t Starting weight (between 35kg and 250kg): ");
		double StartingWeight = input.nextDouble();
		
		System.out.print("\t Gender (M/F): ");
		String Gender = input.nextLine();
		Gender = input.nextLine();

		gym.add(new Member(Id,Name,Address,Height,StartingWeight,Gender));
	}
	
}

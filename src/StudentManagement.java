import java.util.ArrayList; //Provides Resizable-array Implement List Interface 
import java.util.Scanner; //Scanner Class for input

public class StudentManagement { 

	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<Double> grade = new ArrayList<Double>();  // For decimal number
	ArrayList<Integer> balance = new ArrayList<Integer>(); // For whole number
	
	public void addAccount() //Public Method to add account
	{
		String userName="";
		String idNum="";
		Double userGrade=0.0;
		int userBalance=0;
		Scanner input= new Scanner(System.in);
		System.out.println("To Add An Account Please Enter Your Name.");
		if (input.hasNextLine())
		{
		 userName=input.nextLine();
		}
		
		System.out.println("Enter Your ID Number:");
		if (input.hasNextInt())
		{
			idNum= input.nextLine();
		}
		System.out.println("Enter Your GPA:");
		Scanner input1= new Scanner(System.in);
		  userGrade= input1.nextDouble();
	
		
		System.out.println("Enter Your Balance Due:");
		Scanner input2= new Scanner(System.in);
			userBalance = input2.nextInt();
	
		
		
		//Adding All the information to the ArrayList.
		name.add(userName);
		id.add(idNum);
		grade.add(userGrade);
		balance.add(userBalance);
		
		
	}
	
	public int viewAccount(String Id) //Public Method to view account
	{
		int number=0;
		for (int i=0;i<id.size();i++)
		{
	         if (id.contains(Id))
	         {
	               number= i;
	         }
	         else 
	         {
	        	 System.out.println("There No Such ID In Our List. Try Again!");
	        	 return  -1;
	         }
		}
		return number;
	}
	
	
		
	//MAIN Method ---Welcome Screen---
	public static void main(String[] args) 
	{
		StudentManagement myMain= new StudentManagement(); //Calls out StudentManagement Class
		String myID;
		
		int userChoice=0;
		System.out.println("---Student Management System---");
		System.out.println("Hello Student, What Would You Like To Do?");
		System.out.println("1. Add Account.");
		System.out.println("2. View Account.");
		System.out.println("3. Delete Account.");
		System.out.println("4. View Balance Due.");
		System.out.println("5. Exit.");
		Scanner input1=new Scanner(System.in);
		//user input
		userChoice=input1.nextInt();
		
		do{
			
		//Using Switch-Case To Trigger User Choice
		switch(userChoice) 
		{
		case 1:
			myMain.addAccount();
			break;
		case 2:
			System.out.println("Enter Your ID Number");
			
			Scanner input2=new Scanner(System.in);
			myID=input2.nextLine();
			int a1= myMain.viewAccount(myID);
			if(a1!=-1) 
			{
				System.out.println("---Student Information Summary---");
				System.out.println("NAME: "+ myMain.name.get(a1));
				System.out.println("ID: "+ myMain.id.get(a1));
				System.out.println("GRADE: "+ myMain.grade.get(a1));
				System.out.println("BALANCE: "+ myMain.balance.get(a1));
			}
			break;
		case 3: 
			System.out.println("Enter the ID You Yould like to delete:");
			Scanner input3=new Scanner(System.in);
			myID=input3.nextLine();
			int a2= myMain.viewAccount(myID);
			if(a2!=-1) 
			{
				myMain.balance.remove(a2);
				myMain.grade.remove(a2);
				myMain.name.remove(a2);
				myMain.id.remove(a2);
				System.out.println("Succesfully Deleted.");
			}
			break;
		case 4: 
			System.out.println("Enter The ID You Would Like The Balance For:");
			Scanner input4=new Scanner(System.in);
			myID=input4.nextLine();
			int a3= myMain.viewAccount(myID);
			if(a3!=-1) 
			{
				System.out.println("Your Balance Due Is: "+ myMain.balance.get(a3));
			}
			break;
		default: 
			System.out.println("Please Enter A Valid Number.");
			break;
		
		}
		System.out.println("Hello User, What Would You Like To Do?");
		System.out.println("1. Add Account.");
		System.out.println("2. View Account.");
		System.out.println("3. Delete Account.");
		System.out.println("4. View Balance Due.");
		System.out.println("5. Exit");
		Scanner newScan= new Scanner(System.in);
		if (newScan.hasNextInt())
		{
		   userChoice = newScan.nextInt();
		}
		//userChoice=newScan.nextInt();
		
		}while(userChoice!=5); 
		System.out.println("---EXITED---");

	}

}

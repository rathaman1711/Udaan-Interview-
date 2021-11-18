import java.util.*;

public class FitnessSlotBookingSystem {
	
		//Creating features for yoga class
	
		static int ystart=600; 						// Start Time in minutes
		static int ycapacity=10;    				//Capacity of yoga class
		static Set<String> yset = new HashSet<>();  // People in yoga class 
		static Queue<String> ywait = new LinkedList<>(); //Waiting list for yoga
		
		//Creating features for gym class
		
		static int gstart=700; 						// Start Time in minutes
		static int gcapacity=10;    				//Capacity of gym class
		static Set<String> gset = new HashSet<>();  // People in gym class 
		static Queue<String> gwait = new LinkedList<>(); //Waiting list for gym
		
		//Creating features for dance class
		
		static int dstart=800; 					// Start Time in minutes
		static int dcapacity=1;    				//Capacity of dance class
		static Set<String> dset = new HashSet<>(); 	// People in dance class 
		static Queue<String> dwait = new LinkedList<>(); //Waiting list for dance
		
	public static void main(String[] args) {
		
		
		int c=1;
		Scanner scan = new Scanner(System.in);
		while(c==1)
		{
			System.out.println("\n\n1.Book a class");
			System.out.println("2.Cancel a class");
			System.out.println("3.Check Update");
			System.out.println("4.Exit from System");
			System.out.print("Enter your choice: ");
			int choice=scan.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("y for yoga, g for gym and d for dance class: ");
					System.out.print("Enter character for the class: ");
					char cname=scan.next().charAt(0);
					System.out.print("Enter your name: ");
					String username=scan.next();
					username+=scan.nextLine();
					bookSlot(cname,username);
					c=1;
				break;
				case 2:
					System.out.println("y for yoga, g for gym and d for dance class: ");
					System.out.print("Enter character for the class: ");
					char cn=scan.next().charAt(0);
					System.out.print("Enter your name: ");
					String user=scan.next();
					user+=scan.nextLine();
					System.out.print("Enter current time in minutes: ");
					int min=scan.nextInt();
					cancelSlot(cn,user,min);
					c=1;
				break;
				case 3:
					System.out.println("y for yoga, g for gym and d for dance class: ");
					System.out.print("Enter character for the class: ");
					cn=scan.next().charAt(0);
					System.out.print("Enter your name: ");
					user=scan.next();
					user+=scan.nextLine();
					checkUpdate(cn,user);
					c=1;
				break;
				case 4:
					System.out.println("\nThanks.You are out of the system...");
					c=0;
				break;
				default:
					System.out.println("\nWrong option chosen");
					c=1;
				break;
			}
		}
	}
	
	public static void bookSlot(char cname,String user)        //API for slot booking
	{
		user=user.toLowerCase();
		switch(cname)
		{
			case 'y':
				if(yset.size()>=ycapacity)
					{
						System.out.println("\nClasses are filled. Waiting List Entry.Check Update Constantly");
						ywait.add(user);
					}
				else
				{
					System.out.println("\nSuccessfully booked for yoga class");
					yset.add(user);
				}	
			break;
			case 'g':
				if(gset.size()>=gcapacity)
				{
					System.out.println("\nClasses are filled. Waiting List Entry.Check Update Constantly");
					gwait.add(user);
				}
				else
				{
					System.out.println("\nSuccessfully booked for gym class");
					gset.add(user);
				}
			break;
			case 'd':
				if(dset.size()>=dcapacity)
				{
					System.out.println("\nClasses are filled. Waiting List Entry.Check Update Constantly");
					dwait.add(user);
				}
				else
				{
					System.out.println("\nSuccessfully booked for dance class");
					dset.add(user);
				}
			break;
			default:
				System.out.println("\nWrong class Character");
			break;
		}
	}
	
	public static void cancelSlot(char cname,String user,int time)   //API for cancellation
	{
		user=user.toLowerCase();
		switch(cname)
		{
			case 'y':
				if(ystart<time|| ystart-time>30) {System.out.println("\nCannot cancel now");return;}
				if(!yset.contains(user)) {System.out.println("\nNot authorized to cancel");return;}
				
				yset.remove(new String(user));
				if(!ywait.isEmpty())
				{
					String s=ywait.poll();
					yset.add(s);
				}
				System.out.println("\nCancelled Sucessfully");
			break;
			case 'g':
				if(gstart<time|| gstart-time>30) {System.out.println("\nCannot cancel now");return;}
				if(!gset.contains(user)) {System.out.println("\nNot authorized to cancel");return;}
				
				gset.remove(new String(user));
				if(!gwait.isEmpty())
				{
					String s=gwait.poll();
					gset.add(s);
				}
				System.out.println("\nCancelled Sucessfully");
			break;
			case 'd':
				if(dstart<time|| dstart-time>30) {System.out.println("\nCannot cancel now");return;}
				if(!dset.contains(user)) {System.out.println("\nNot authorized to cancel");return;}
				
				dset.remove(new String(user));
				if(!dwait.isEmpty())
				{
					String s=dwait.poll();
					dset.add(s);
				}
				System.out.println("\nCancelled Sucessfully");
			break;
			default:
				System.out.println("\nWrong class Character");
			break;
		}
	}
	public static void checkUpdate(char c,String user)
	{
		user=user.toLowerCase();
		switch(c)
		{
			case 'y':
				if(yset.contains(user)) {System.out.println("Entered class Successfully");return;}
				if(ywait.contains(user)) {System.out.println("Waiting list");return;}
				else
					System.out.println("Not registered");return;
			case 'g':
				if(gset.contains(user)) {System.out.println("Entered class Successfully");return;}
				if(gwait.contains(user)) {System.out.println("Waiting list");return;}
				else
					System.out.println("Not registered");return;
			case 'd':
				if(dset.contains(user)) {System.out.println("Entered class Successfully");return;}
				if(dwait.contains(user)) {System.out.println("Waiting list");return;}
				else
					System.out.println("Not registered");return;
			default:
				System.out.println("\nWrong class Character");
			break;
		}
	}
}

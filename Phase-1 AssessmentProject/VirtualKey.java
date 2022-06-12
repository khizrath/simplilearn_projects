package com.shazia.LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



public class VirtualKey {
	
	/*problem statement: creating a protocol of file handling to perform 
	 *various methods like add, delete, search, sort and end application through 
	 *user interaction in console/command line output
	 *
	 *Basically writing a java code, where operations are planned to be 
	 *completed in 3 sprints 
	 *
	 * 1.Retrieve & set files in ascending order(sorting)
	 * 2.Performing business level operations
	 * 		A)add--creating a file
	 * 		B)delete--delete an existing file
	 * 		C)search--search an existing file
	 * 		D)Go Back--just breaking the loop
	 * 3.Close the application
	*/
	
	//Creating business level operations
	
	
	
	public static void add() {//method to add or create a file 
		
	//showing two ways to throw an exception either from operational method or in the main method
			try {

				 System.out.println("Enter your file name (ex:abc.txt) to add in existing directory");
				 Scanner sc = new Scanner(System.in);
				 String takeFileName = sc.nextLine();
				 
				 File addFile = new File("F:\\simplilearn\\Shazia_files\\"+takeFileName);
				 
				 if(addFile.createNewFile()) 
					 System.out.println("New File "+takeFileName +" is created");
				 else
					 System.out.println("File already exists");
			}
			
			catch(IOException e){
				System.out.println("-------------EXCEPTION OCCURRED-------------");
				System.out.println(e);
				
			}
		
		
	}
	//deletion method starts here
	 public static void delete()
	 {
		 System.out.println("Enter file name (ex:- abc.txt) to delete");
		 Scanner sc = new Scanner(System.in);
		 String takeFileName = sc.nextLine();
	      
		 File deleteFile = new File("F:\\simplilearn\\Shazia_files\\"+takeFileName);	
		 
		 if(deleteFile.delete())
			 System.out.println("Given file "+takeFileName+" is deleted successfully");
		 else
			 System.out.println("File is not deleted/ file not found(FNF)");
	 }
	 
	 //searching method starts here
	 public static void search()
	 {
		System.out.println("Enter your file name to search");
		Scanner sc = new Scanner(System.in);
		String takeFileName = null;
		takeFileName = sc.nextLine();
		 
		File searchFileName = new File("F:\\simplilearn\\Shazia_files\\"+takeFileName);
		
		if( searchFileName.exists())
		{
			System.out.println("File "+takeFileName+" is available"); 
		}
		 else 
			 System.out.println("File is not available/File not found(FNF)");
	 }
	 
	 //METHOD FOR SORTING OF FILES IN ASCENDING ORDER
	 public static void ascendingOrder()
	 {
		 
		System.out.println("ENTER PATH TO SHOW YOUR FILES IN ASCENDING ORDER (EX: path\\FileName.txt):\n");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.nextLine();
		File dir = new File(filePath);
		 
		 if (dir.isDirectory())
		 {
			 File[] files = dir.listFiles();
			 System.out.println("THIS PATH CONTAINS FOLLOWING FILES:\n");
			 
			 for(File file:files)//showing ascending order
			 {
				 System.out.println(file.getName());
			 }
			 
			 show(files);//calling ascending order method
			  
			 System.out.println("\nPRINTING THE FILE NAMES IN ASCENDING ORDER :\n");
			 
			 for(File file:files)//showing ascending order
			 {
				 System.out.println(file.getName());
			 }
			 System.out.println("----------------------------------------------------------------------------------------");
		 }
		 else
		 {
			 System.out.println("directory not found");
		 }
		
		 
	 }
		 
		 private static void show(File[] files)//sorting by name only
		 {
			 Arrays.sort(files, new Comparator<Object>()
			 {
		 	public int compare(Object f1, Object f2)
		 	{
		 		return ((File)f1).getName().compareTo(((File)f2).getName());
		 	}
		 
			 }); 
	 
		 }
	 
	 
	 public static void main(String[] args) throws IOException {
		 
		 System.out.println("WELCOME TO LOCKEDME.COM VIRTUAL KEY REPOSITORY\n");
		 String devName ="DEVELOPER NAME : S KHIZRATH SHAZIA";
		 String cadre= "DESIGNATION : JAVA DEVELOPER";
		 String date = "last updated on : 10th june 2022";
		 System.out.println(devName+"\n"+cadre+"\n"+date+"\n");
		 
		 
			
			while(true)/*creating an infinite loop which stops only when the user opts to close the application option*/
			{
				System.out.println("\nSELECT THE OPERATION TO PERFORM");
				System.out.println("Enter 1:  Get file names in ascending order");
				System.out.println("Enter 2:  For Business Level Operation");
				System.out.println("Enter 3:  Close the Application");

				System.out.println("Enter your choice :- \n");
				
				Scanner choice = new Scanner(System.in);
				
				int option= choice.nextInt();

				if(option==1)
				{
					ascendingOrder();
				}

				else if(option ==2)
				{
					System.out.println("\nSELECT ANY ONE BUSINESS LEVEL OPERATION TO PERFORM");
					System.out.println("Enter 1: Add file");
					System.out.println("Enter 2: Delete file");
					System.out.println("Enter 3: Search file");
					System.out.println("Enter 4: Go Back to previous page\n");
					
					System.out.println("Enter your choice :- \n");
					
					int input = choice.nextInt();
					
					switch(input)
					{
					
					case 1: {	add();  break;  }
						
				    case 2: { delete(); break;  }
					
					case 3: { search(); break;  }
					
					case 4: { System.out.println("Going back to previous page"); break;  }
						   
			     }
			 }
				
				else if(option == 3 )	
				{ 	 System.out.println(" Exited the Application \n Thank you for using LOCKEDME.COM \n ");	
				      System.exit(option); 
				}
				
				else
				{
					System.out.println("Kindly enter valid input");
				}
			}
	}

}

import java.util.*;
public class RomanNumeral {

	public static void MultiTables(){
		
		for(int x = 0;x<=12;x++) {
			for(int y = 0;y<=12;y++) {
				System.out.printf("%-5d", x*y);
			}
			System.out.println();
		}	
		
	}
	public static void CustomMultiTable(int in) {
		
		for(int x = 0;x<=in;x++) {
			for(int y = 0;y<=in;y++) {
				System.out.printf("%-5d", x*y);
			}
			System.out.println();
		}
	}
	
	
	
	public static String IntToNumeral(int I){
		String s = "";
		int num = I;
		do {//do while loop used to slowly decrease number and convert it into Roman numeral
		if(num>=1000) {
			s += 'M';
			num -= 1000;
			
		}
		else if(num>900) {
			s += "CM";
			num -= 900;
			
		}
		else if( num>=500) {
			s += 'D';
			num -= 500;
			
		}
		else if(num>=400) {
			s += "CD";
			num -= 400;
			
		}
		else if(num>=100) {
			s += 'C';
			num -= 100;
			
		}
		else if(num>=90) {
			s += "XC";
			num -= 90;
			
		}
		else if(num>=50) {
			s += 'L';
			num = num-50;
			
		}
		else if(num>=40) {
			s += "XL";
			num -= 40;
			
		}
		else if(num>=10) {
			s += 'X';
			num -= 10;
			
		}
		else if(num>=9) {
			s += "IX";
			num -= 9;
			
		}
		else if(num>=5) {
			s += 'V';
			num=num-5;
			
			
		}
		else if(num<5) {
			switch(num) {//switch is used as a quick way to evaluate the last part of the numeral
			case 4: 
			s += "IV";
			num = 0;
			break;
			case 3:
			s += "III";
			num = 0;
			break;
			case 2:
			s += "II";
			num = 0;
			break;
			case 1: 
			s += 'I';
			num = 0;
			break;
			
			}
			
		}
		
		
		}while(num > 0);

		return s;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Which program would you like to run? roman numerals or multiplication tables?");
		System.out.println("enter 1 for roman numerals or 2 for the tables:");
		Scanner ans = new Scanner(System.in);
		int response;
		if(ans.hasNextInt()) {
			response = ans.nextInt();
			if(response == 1) {
				int wrongInputCounter = 0;
				String letterInput = "x";
				System.out.println("Please enter a year and it will be converted into roman numerals:");
				//use loop so that the user can enter a number as many times as he wants
				while(!letterInput.equals("N") && !letterInput.equals("n")) {
					if(letterInput.equals("Y") || letterInput.equals("y")) {
						System.out.println("Please enter a year and it will be converted into roman numerals:");
					}
					Scanner scan = new Scanner(System.in);
					int year;
					if(scan.hasNextInt()) {// check to make sure that the user entered a nuber and not something else
						
						year = scan.nextInt();// make sure that the number is a valid one first
						if(year > 3999) {
							System.out.println("This number is too large to be converted into a roman numeral");
							System.out.println("becasue of invalid input the progam will not terminate.");
							break;
						}
						System.out.println(IntToNumeral(year));
						wrongInputCounter = 0;
						System.out.println("Would you like to convert another year into roman numerals? Y or N");
						letterInput = scan.next();
						if(!letterInput.equals("Y") && !letterInput.equals("y") && !letterInput.equals("n") && !letterInput.equals("N")) {
							System.out.println("Invalid command. Ending program.");
							break;
						}
						else if(letterInput.equals("N") || letterInput.equals("n")) {
							System.out.println("Thanks for playing. Have a great day!");
						}
					}
					else {// if the user does not enter a number after a certain amount of tries then the program ends
						
						if(wrongInputCounter == 3) {
							System.out.println("if you cannot enter the right number then you have no right to use this program!");
							break;
						}
						else {
							System.out.println("I am asking for a year and nothing else. Give it another try please.");
							wrongInputCounter++;
							continue;
						}
						}
				
				}
			}
			else if(response == 2) {
				System.out.println("would you like the normal 12x12 or a cusomte table?");
				System.out.println("Enter 1 for the 12x12 or 2 for a custome table:");
				int tableAns;
				if(ans.hasNextInt()) {
					tableAns = ans.nextInt();
					if(tableAns == 1) {
						MultiTables();
					}
					else if(tableAns == 2) {
						System.out.println("then please enter a number and the table will be that number by that number");
						CustomMultiTable(ans.nextInt());
					}
				}
				
			}
			else {
				System.out.println("program will terminate because of bad input");
			}
		}
	
		
	}

}

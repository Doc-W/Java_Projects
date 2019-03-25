/**
 * A class that simulates a combination lock
 * @author Drew Merrill
 * CS 2420 spring 2019
 * 
 */

import java.util.*;
public class ComboLock {

	private int num1;
	private int num2;
	private int num3;

	private boolean status = false;

	public ComboLock() {
		num1 = 3;
		num2 = 6;
		num3 = 8;

	}



	public boolean LockStatus() {
		if(status == false) {
			System.out.println("The lock is closed");
			return false;
		}
		else {
			System.out.println("The lock is open");
			return true;
		}
	}

	public void OpenLock(int x, int y, int z) {
		if(status == true) {
			System.out.println("Lock is already open, why are you trying to open it again");
		}
		else {
			if(num1 == x && num2 == y && num3 == z) {
				status = true;
				System.out.println("The lock is now open");
			}
			else {
				System.out.println("The combo is wrong and the lock has remained closed");
			}
		}
	}

	public void ChangeCombo(int x, int y, int z) {

		if(status == true) {
			
			num1 = x;
			num2 = y;
			num3 = z;
			System.out.println("The lock combination has been changed and the lock has been closed");
			status = false;
		}
		else {
			System.out.println("you have not opened lock and thus cannot change the combination");
		}
	}

	public void CloseLock() {
		if(status == false) {
			System.out.println("The lock is already closed");
		}
		else{
			status = false;
			System.out.println("The lock is now closed");
		}
	}









	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int selection;
		int loopNum = 0;
		int failNum = 0;
		ComboLock lock = new ComboLock();
		System.out.println("Welcome to the Combo lock. please enter the number for what action you want to do:");
		while(loopNum == 0) {

			try {
				System.out.println("1: check lock status");
				System.out.println("2: open lock");
				System.out.println("3: change lock combo");
				System.out.println("4: close lock");
				System.out.println("5: leave the lock room");
				selection = scan.nextInt();
				if(selection == 1) {
					lock.LockStatus();
				}

				else if (selection == 2) {
					System.out.println("Please enter the three numbers needed to open the lock:");
					lock.OpenLock(scan.nextInt(), scan.nextInt(), scan.nextInt());	
				}

				else if (selection == 3) {
					if(lock.LockStatus() == false) {
						System.out.println("only those that have opened the lock already can change the lock.");
					}
					else {
						System.out.println("Please enter the numbers that you want to change the lock combo to:");
						lock.ChangeCombo(scan.nextInt(), scan.nextInt(), scan.nextInt());
					}
				}

				else if (selection == 4) {
					lock.CloseLock();
				}

				else if (selection == 5) {
					if(lock.LockStatus() == true) {
						System.out.println("Please close the lock before leaving");
					}
					else {
						break;
					}
				}
				else if(selection > 5) {
					failNum++;
					if(failNum == 3) {
						System.out.println("If you want to play around you can leave");
						break;
					}
					else {
						System.out.println("the number has to be 1-5, nothing higher or lower. try again.");
					}
				}

			}
			catch(Exception e){
				System.out.println("If you will not enter a number then you cannot be here.");
				break;
			}





		}








	}


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author nbn23
 */
import java.util.Scanner;

public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    



	static Scanner input = new Scanner(System.in);
	static int balance = 0, product, coins, bills, total = 0, change = 0,
			options;
        public static void payment(int opt, int coin, int bill) {

		System.out.println("\nPlease select the payment method.");
		do {
			// enter money options
			System.out.println("0. Stop Enter Money");
			System.out.println("1. Enter coins");
			System.out.println("2. Enter bills");
			options = opt;
			
			if (options == 0) {
				break;
			}
			else if (options == 1) {
				System.out.println("Enter coins");
				System.out.print(coin);
				do {
					coins = coin;
					// enter coins
					switch (coins) 
                                        {
					case 0:
						break;
					case 1: // penny
						total += 1;
						break;
					case 5: // nickle
						total += 5;
						break;
					case 10: // dime
						total += 10;
						break;
					case 25: // quarter
						total += 25;
						break;
					default:
						System.out.println("Invalid Coins, Please enter the new coins");
					}
				} while (coins != 0);
			} else if (options == 2) {
				// 1 dollar bills, and 5 dollar bills
				System.out.println("Enter bills");
				System.out.print(bill);
				do {
					bills = bill;
					switch (bills) {
					case 0:
						break;
					case 1: // 1 dollar
						total += 100;
						break;
					case 5: // 5 dollar
						total += 500;
						break;
					default:
						System.out.println("Invalid Bills, Please enter the new bills");
					}
				} while (bills != 0);
			} else {
				System.out.println("Invalid Options");
			}
		} while (options != 0);
	}
	
	public static void payment() {
		
		System.out.println("\nPlease select the payment method.");
		do {
	
			System.out.println("0. Stop Enter Money");
			System.out.println("1. Enter coins");
			System.out.println("2. Enter bills");
			options = input.nextInt();

			if (options == 0) {
				break;
			}

			else if (options == 1) { 
				System.out.println("Enter coins");
				do {
					coins = input.nextInt();
					// enter coins
					
                                       
                                        switch (coins) {
					case 0:
						break;
					case 1: // penny
						total += 1;
						break;
					case 5: // nickle
						total += 5;
						break;
					case 10: // dime
						total += 10;
						break;
					case 25: // quarter
						total += 25;
						break;
					default:
						System.out.println("Invalid Coins, Please enter the new coins");
					}
                                       
				} while (coins != 0);
			} else if (options == 2) {
				System.out.println("Enter bills");

				do {
					bills = input.nextInt();
		
					switch (bills) {
					case 0:
						break;
					case 1: // 1 dollar
						total += 100;
						break;
					case 5: // 5 dollar
						total += 500;
						break;
					default:
						System.out.println("Invalid Bills, Please enter the new bills");
					}
                                        
                               
				} while (bills != 0);
			} else {
				System.out.println("Invalid Options");
			}
		} while (options != 0);
	}

	public static void purchase() {
	
		System.out.println("Please select your product.");
                System.out.println("0. Get money back");
		System.out.println("1. Kitkat\t$.36");
		System.out.println("2. Mars\t\t$.45");
		System.out.println("3. Reese\t$.55");
		System.out.println("4. Twix\t\t$1.25");
		System.out.println("5. Snicker\t$1.50");

		product = input.nextInt();

		switch (product) {
		case 0:
			balance += 0;
			break;
		case 1:
			balance += 36;
			break;
		case 2:
			balance += 45;
			break;
		case 3:
			balance += 55;
			break;
		case 4:
			balance += 125;
			break;
		case 5:
			balance += 150;
			break;
		default:
			System.out.println("Invalid Products");
		}
	}
	public static String calCoins(int changes) {
		String changeString = "";
		int quarters, remQuarters=0;
		int dimes, remDimes=0;
		int nickles, remNickles=0;
		int pennies=0;
		
		quarters = change/25;
		remQuarters =change%25;
		changeString += quarters + " quarters\n";

		if(remQuarters!=0) {
			dimes = remQuarters/10;
			remDimes = remQuarters%10;
			changeString += dimes + " dimes\n";
		} 
		
		if (remDimes!=0) {
			nickles = remDimes/5;
			remNickles = remDimes % 5;
			changeString += nickles + " nickles\n";
		}
		
		if (remNickles!=0) {
			pennies = remNickles;
			changeString += pennies + " pennies\n";
		}
		return changeString;
	}
	
	public static String change() {

				String changeDisplay="";
				if (total > balance) {
					change = total - balance;
					//calculate for coins
					changeDisplay = calCoins(change);
				}
				else {
					changeDisplay ="Enter more money";
				}
				
				return changeDisplay;
	}
	
	public static void display() {

		System.out.println("BALANCE : " + balance);
		System.out.println("TOTAL MONEY : " + total);
		System.out.println("CHANGE :\n " + change());
	}
	
	public static void main(String[] args) {
		System.out.println("HELLO Customer!");
		// The vending machine offers 5 products
		System.out.println("0. Get money back");
		System.out.println("1. Kitkat\t$.36");
		System.out.println("2. Mars\t\t$.45");
		System.out.println("3. Reese\t$.55");
		System.out.println("4. Twix\t\t$1.25");
		System.out.println("5. Snicker\t$1.50");

		payment();
		purchase();
		change();
		display();
	}

}
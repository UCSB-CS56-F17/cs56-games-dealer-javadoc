package edu.ucsb.cs56.projects.games.dealer;

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{
	System.out.println("Which games you want to play?");
	System.out.println("1) Dealer");
	System.out.println("2) BlackJack");
	Scanner stdin = new Scanner(System.in);
	int userInput = stdin.nextInt();

		switch(userInput){
		case 1:
			Dealer.main(args);
			break;
		case 2:
			BlackJackMain.main(args);
			break;
		default:
			break;
		}
		stdin.close();
		

    }
}

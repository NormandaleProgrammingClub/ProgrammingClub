//Ben Olson
//PC
//1-27-17

package blackjack;

//import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

class blackjackgame 
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		int playerNum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to BlackJack! How many Players?");
		playerNum = s.nextInt();
		String cmd = " "; // <-- Kenny did dis

		while (playerNum <= 0 || playerNum > 5) 
		{
			System.out.println("Unusable amount of players! Please input another amount between 0-5!");
			playerNum = s.nextInt();
			// quick check for within range
		}
		System.out.print("Please Wait...");
		System.out.print(".");

		System.out.print(".");
		System.out.print(".");

		deck.shuffleDeck();

		// Creating a list of player hands
		ArrayList<Player> players = new ArrayList<Player>((playerNum));
		for (int i = 0; i <=(playerNum); i++)
		{
			players.add(new Player());
		}

		System.out.println("");
		System.out.println("\nThe deck has been shuffled, the players have been readied. Lets Play!");
		System.out.println("Rules are simple, Play to 21. Go over and you bust, go under and you might lose!");
		System.out.println("Good Luck and Have Fun!");

		//for loop to run through players and deal cards
		
		for(int i = players.size()-1; i>=0; i--)
		{
			deck.dealCard(players.get(i));
			deck.dealCard(players.get(i));
		}
		
		System.out.println();
		System.out.println("Here are the hands currently:");
		for(int i=players.size()-1;i>=0;i--)
		{
			if(i==0)
			{
				System.out.println("Dealer:");
				players.get(0).printHand();
			}
			else
			{
				System.out.println("Player "+ i + "'s Hand:");
				players.get(i).printHand();
			}
		}
		
		for(int i=players.size()-1;i>0;i--)
		{
			//for loop cycles through players top down
			//because dealer is position zero

			cmd = " ";
			//System.out.println();
			//System.out.println("Player "+ i +" Please select either Hit or Stand by typing H or S.");
			//System.out.println("Player "+i+"'s Hand valuse is: " + players.get(i).getHandValue());
			//cmd = s.next();
			while((!cmd.equals("stand")) && (!cmd.equals("bust")))
			{
				System.out.println();
				System.out.println("Player "+ i +" Please select either Hit or Stand by typing H or S.");
				cmd = s.next();
				switch(cmd)
				{
					// Feel free to do it wrong ben...
					case "s": 
						cmd = "stand"; 
						break;
						
					case "h": // hit
						deck.dealCard(players.get(i));
						if(players.get(i).getHandValue()>21)
						{
							System.out.println("You Bust!");
							cmd="bust";
							players.get(i).set_isOut(true);
						}; 
						break;
						
					case "S": 
						cmd = "stand"; 
						break;
						
					case "H": 
						deck.dealCard(players.get(i));
						if(players.get(i).getHandValue()>21)
						{
							System.out.println("You Bust!");
							cmd="bust";
							players.get(i).set_isOut(true);
						}; 
						break;
					default:
						System.out.println("Invaild input...");
						break;
				}
				
				System.out.println("Player "+i+"'s Hand valuse is: " + players.get(i).getHandValue());
					
			}
			//String var needs to be set back to a default after player while loop
			System.out.println("Player "+i+"'s Hand is:");
			players.get(i).printHand();
			cmd = " ";
		}
		// Check players for winner...
		for(int i=players.size()-1;i>0;i--)
		{
			ArrayList<int> winners;
			if(!players.get(i).get_isOut())
			{
				if(players.get(i).getHandValue() > players.get(0).getHandValue())
					winners.add(i);
				else if(players.get(i).getHandValue() == players.get(0).getHandValue())
					// if player ties with dealer bet is returned...
				
			}
		}
		
		s.close();
	}

}

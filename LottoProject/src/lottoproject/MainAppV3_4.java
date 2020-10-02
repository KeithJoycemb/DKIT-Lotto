package lottoproject;
import java.util.*;

/**
 *
 * @author keith
 */
  
public class MainAppV3_4 
{
    static Scanner keyboard = new Scanner(System.in);
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
       /**
      * hard coded tickets for populating the ticket list array 
      * hard coded tickets also used for testing purposes
      * Ticket 2 and 3 having winning lotto numbers for testing purposes if drawNumbers method not used 
      * Ticket 4 has match3 method hard coded for testing purposes if drawNumbers method not used
      */
       Ticket t1= new Ticket("Barry","Dundalk","0838888115", new ArrayList<>(Arrays.asList(1,14,21,29))); 
       Ticket t2= new Ticket("Adam","12 hill ave dundalk","0879021323", new ArrayList<>(Arrays.asList(3,11,14,20)));
       Ticket t3 = new Ticket("Carly","14 groove Dublin","0863216585", new ArrayList<>(Arrays.asList(3,12,14,20)));
       Ticket t4 = new Ticket("Stephen","7 rock road Scotland","+4429115555", new ArrayList<>(Arrays.asList(3,11,14,27)));

        /**
       * ArrayList to add player tickets 
       */
       ArrayList<Ticket>ticketList = new ArrayList<>();
       ticketList.add(t1);
       ticketList.add(t2);
       ticketList.add(t3);
       ticketList.add(t4);
         
       ArrayList<Ticket>playerTicket = new ArrayList();
       double range =0;
       int err = 1;
         
       /**
      * Print statement to ask user what the maximum number for the game will be 
      * Loop to check if the user has entered a letter or number lower than 30
      * Exception to catch any errors from putting in a letter ie: InputMismatchException
      * Takes the number the user enters and makes it the range for the game
      * Use maximum number of 30 for testing purposes 
      */
       System.out.println("Please enter the maximum number you would like to use for this game ( 30 , 100 , 200 , etc), the lowest maximum number you can use is 30 ");
       while(err == 1)
       {
            err = 0;   
            try{range = keyboard.nextDouble();}
        
            catch (Exception e)
            
        {
            System.out.println( keyboard.next() + " is not a number please try again  ");
            err=1;
        }
            if(range < 30 && err == 0)
        {
            System.out.println("The value you entered is to low, the lowest maximum number you can use is 30 ");
            err = 1;
        }
     }

        /**
       * Hard coded default winning numbers if drawNumbers method is not used for testing purposes (3,12,14,20)
       * Jackpot prize coded here it is 500
       * Match3 prize coded here it is 50
       */
        Game g1 = new Game(ticketList, new ArrayList<>(Arrays.asList(3,12,14,20)),500,50);
 
        //int howManyTickets;
        int option;
 
        printMenu();
        System.out.print("Please enter option:");
        option = keyboard.nextInt();
        while (option != 0)
        {
            if (option == 1)
            {
                playerTicket = g1.getLottoTickets(); 
                playerTicket.add(Game.addTicket(range));
                g1.setLottoTickets(playerTicket);
                
                //not working 
                /*System.out.println("How many Tickets would you like to add: ");
                howManyTickets = keyboard.nextint();
                //For loop to count how many tickets are to be added
                for(int i = 0; i < howManyTickets;i++)
                    {
                         playerTicket.add(Game.addTicket());
                    }
                */ 
            }
            else if (option == 2)
            {
                System.out.println("DISPLAYING ALL TICKETS");
                g1.displayAllTickets();

            }
            else if (option == 3)
            {
                 System.out.println("Please enter the name you would like to search: ");  
                 g1.displayTicket(keyboard.next());
            }
            else if (option == 4)
            {
                System.out.println("Please enter the address you would like to search: ");  
                g1.displayLocalPlayers(keyboard.next());
            }
            else if ( option == 5)
            {
                g1.setWinningNumbers(g1.drawNumbers(range));
                System.out.println("The lotto numbers for this week are: "+ g1.getWinningNumbers() + "\n" );
            }
            else if( option == 6)
            {
               System.out.println("DISPLAYING TICKET MATCHES AND WINNERS");
               System.out.println("The lotto numbers for this week are: "+ g1.getWinningNumbers() + "\n" );
               g1.displayMatch(g1.getLottoTickets(),g1.getWinningNumbers());
            }
            else if( option == 7)
            {
                System.out.println("Enter the number you would like to check ");
                g1.countWhoChoseNumber(keyboard.nextInt());
            }
            else if( option == 8)
            {
                System.out.println("MAKING TEXT FILE");
                g1.printToTxt();
            }
            else
            {
                System.out.println("please enter valid option [0,6]");
            }
            printMenu();
            System.out.print("Please enter option:");
            option = keyboard.nextInt();
        }
        System.out.println("\nThanks for playing ");
    }  
    
        /**
       * Prints menu of options for lotto 
       */ 
         public static void printMenu()
         {
            System.out.println("\n DKIT Lottery.");
            System.out.println("0. Exit ");
            System.out.println("1. Add new Ticket ");
            System.out.println("2. Display all Tickets ");
            System.out.println("3. Search for player name ");
            System.out.println("4. Search by local players ");
            System.out.println("5. Draw Lottery numbers ");
            System.out.println("6. Show winners and matches ");
            System.out.println("7. Show who picked a  number ");
            System.out.println("8. Print to text file ");
       }
}


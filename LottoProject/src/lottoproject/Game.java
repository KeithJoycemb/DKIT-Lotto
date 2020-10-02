package lottoproject;
import static com.sun.xml.internal.ws.model.RuntimeModeler.capitalize;
import java.util.*;
import java.io.*;
/**
 *
 * @author keith
 */
    public class Game 
    {
        private ArrayList<Ticket>lottoTickets = new ArrayList<>();
        private ArrayList<Integer>winningNumbers = new ArrayList<>();
        private int jackPot,match3;
        

        /**
         * this is the constructor for the game class
         * @param lottoTickets is the lottery tickets for the player
         * @param winningNumbers is the winning numbers that are drawn
         * @param jackPot is the jackpot prize for the lottery 
         * @param match3 is the match3 prize for the lottery
         */
        public Game(ArrayList<Ticket>lottoTickets,ArrayList<Integer>winningNumbers, int jackPot, int match3) 
        {
            this.lottoTickets = lottoTickets;
            this.winningNumbers = winningNumbers;
            this.jackPot = jackPot;
            this.match3 = match3;
        }

        @Override
        public String toString() 
        {
            return "Game{" + "lottoTickets=" + lottoTickets + ", winningNumbers=" + winningNumbers + ", jackPot=" + jackPot + ", match3=" + match3 + '}';
        }

        /**
         *this will get the players lottery tickets 
         * @return this will return the players return lottery tickets
         */
        public ArrayList<Ticket> getLottoTickets() 
        {
            return lottoTickets;
        }

        /**
         *this will set the players lottery tickets 
         * @param lottoTickets will give the player lottery tickets 
         */
        public void setLottoTickets(ArrayList<Ticket> lottoTickets) 
        {
            this.lottoTickets = lottoTickets;
        }

        /**
         *This will get the winning lottery tickets that have be drawn 
         * @return will return the winning lottery tickets 
         */
        public ArrayList<Integer> getWinningNumbers() 
        {
            return winningNumbers;
        }

        /**
         *this will set the winning lottery numbers 
         * @param winningNumbers will give the lottery winning numbers that are drawn
         */
        public void setWinningNumbers(ArrayList<Integer> winningNumbers) 
        {
            this.winningNumbers = winningNumbers;
        }

        /**
         *This will get the jackpot prize
         * @return this will return the jackpot prize 
         */
        public int getJackPot() 
        {
            return jackPot;
        }

        /**
         *This will set the jackpot prize for the lottery
         * @param jackPot will give the lottery a jackpot prize 
         */
        public void setJackPot(int jackPot) 
        {
            this.jackPot = jackPot;
        }

        /**
         *This will return the match3 prize for matching 3 numbers
         * @return this will return the match3 prize 
         */
        public int getMatch3() 
        {
            return match3;
        }

        /**
         *This will set the match3 prize for the lottery
         * @param match3 will give the lottery a match3 prize for matching 3 numbers 
         */
        public void setMatch3(int match3) 
        {
            this.match3 = match3;
        }

        /**
         *uses comparator interface to order objects
         * uses lambda to cycle through array list of all tickets 
         * sorts tickets by name(alphabetical) 
         * iterates through temp list 
         * prints names
         */
        public void displayAllTickets()
        {
            ArrayList<Ticket> tempList = getLottoTickets();

            Comparator<Ticket> compareByName = (Ticket t1, Ticket t2) ->
            t1.getPlayerName().compareTo( t2.getPlayerName());

            Collections.sort(tempList, compareByName);

            for (Ticket t : tempList)         
            {
                System.out.println(t.toString());
            }
        }

        /**
         *This will display tickets belonging to a certain player name
         * Loop will cycle through player tickets to find name that is given
         * If player name is found it will be counted and displayed
         * If no player has the name that the user is searching for print statement will print player does not exist
         * @param name is the players name that will be searched
         */
        public void displayTicket(String name)
        {
            ArrayList<Ticket> tempList = getLottoTickets();
            int count = 0;
            for (Ticket t : tempList)  
            {
                    if(t.getPlayerName().toLowerCase().equals(name))
                         {
                             System.out.println(t.toString());
                             count++;
                         }
            } 

            if(count == 0)
              {
                  System.out.println("This player does not exist");
              }

        }

        /**
         * This will randomly draw the lottery number
         * Loop to only allow the user to enter 4 numbers 
         * The drawn numbers are then sorted from lowest to highest 
         * @param range is the number the player sets at the start of a game(30,100,200 etc) 
         * @return this will return the drawn numbers 
         */
        public ArrayList<Integer> drawNumbers(double range)
        {
            ArrayList<Integer> drawNums = new ArrayList<>();

            while(drawNums.size()!=4)
            {
                int random = (int)(range * Math.random());
                if(random >= 1 && !drawNums.contains(random))
                {
                    drawNums.add(random);
                }
            }
            Collections.sort(drawNums);
            return drawNums;
        }

        /**
         *This will return any players that have won the jackpot prize and match3 will also show the tickets that did not win 
         * compares players ticket numbers with the winning lotto numbers and stores the winning player numbers
         * @param ticketList is the tickets for the players that are playing the lottery 
         * @param winningNumbers is the winning numbers that have been drawn
         */
        public void displayMatch(ArrayList<Ticket>ticketList, ArrayList<Integer>winningNumbers)
        {
            ArrayList<Ticket> tempList = getLottoTickets();
            ArrayList<Integer> ticketNumbers = new ArrayList<>();
            ArrayList<Integer> winList = getWinningNumbers();
            int count = 0;

            for (Ticket t : tempList)
            {
                count++;
                ticketNumbers = t.getLottoNums();
                
                ticketNumbers.retainAll(winList);
                if(ticketNumbers.size() == 4)
                {
                    System.out.println("Ticket: " + count + " Winnner of Jackpot " +"€"+ getJackPot() + "\n" + t.toString());
                }

                else if(ticketNumbers.size() == 3)
                {
                    System.out.println("Ticket: " + count + " Winner of Match 3 " +"€"+ getMatch3() + "\n" + t.toString());
                }
                else System.out.println("Ticket: " + count + " is not a winner ");

            }
        }
    
        /**
         *This will allow the user to search the players tickets in order to find a player using there address(ie, Dundalk, Drogheda, Dublin)
         * counts and prints any user that has the specified address 
         * @param address is the players address that is on there lottery ticket 
         */
        public void displayLocalPlayers(String address)
        {
            ArrayList<Ticket> tempList = getLottoTickets();
            int count = 0;
            for (Ticket t : tempList)  
            {
                    if(t.getPlayerAddress().toLowerCase().contains(address.toLowerCase()))
                         {
                             System.out.println(t.toString());
                             count++;
                         }
            } 

            if(count == 0)
              {
                  System.out.println("no player with this address exists");
              }
        }

        /**
         *This will allow the user to see how many times a certain number was picked in the player lottery tickets
         * If the searched number finds the number in any of the players lottery tickets they are then counted and printed
         * @param num is the number of times the searched player number shows up
         */
        public void countWhoChoseNumber(int num)
        {
            ArrayList<Ticket> tempList = getLottoTickets();
            int count = 0;
            for (Ticket t : tempList)  
            {
                    if(t.getLottoNums().contains(num));
                         {
                             count++;
                         }
            } 

            if(count > 0)
              {
                  System.out.println("there are " + count + " instances of the number " + num);
              }
               else
              {  
                  System.out.println("no player has the number " + num);
              }

        }

        /**
       * Asks the user to input there name, address, phone number, and there lotto numbers
       * While Loop to check if the player has entered a unique number
       * If the user has entered a number they have already used they will be asked to enter a new number 
       * @param playerNums Creates the players lotto number inputted from the keyboard 
       * @return Returns a ticket that the user generates through the keyboard ( player name, player phone number, and the players lotto numbers)
       */
        public static Ticket addTicket(double playerNums)
        {
             Scanner keyboard = new Scanner(System.in);
             Ticket tempT = new Ticket();

             System.out.println("Please enter your name: ");
             tempT.setPlayerName(capitalize(keyboard.nextLine()));
             System.out.println("Please enter your address: ");
             tempT.setPlayerAddress(keyboard.nextLine());
      
             System.out.println("Please enter your phone number: ");
             tempT.setPlayerPhNum(keyboard.next());

             ArrayList<Integer> numList = new ArrayList<>();
             int num =1;

             System.out.println("Enter 4 Numbers between 1-" + playerNums); 
               while(numList.size() != 4)
               {
                    num = keyboard.nextInt();
                    if(num >=1 && num <=playerNums)
                        {
                            if( !numList.contains(num))
                            {              
                                  System.out.println("Enter number " );
                                  numList.add(num); 
                            }else{
                                  System.out.println("you have already entered this number please try again"); 
                            }
                        }
                }
                    //ArrayList<Integer> winningNums = new ArrayList<>(Arrays.asList(12,20,3,14));
                   Collections.sort(numList);
                   tempT.setLottoNums(numList);
                   return tempT;       
        }
    
         /**
        *creates new text file called "TICKETS"
        * iterates through array list 
        * stores array list data in text file
        */
         public void printToTxt()
         {
            File file = new File("Tickets.txt");
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file)))
            {
                ArrayList<Ticket> tempList = getLottoTickets();
                 for (Ticket t : tempList)
                      {
                             String fileContent = t.toString() + "\n";
                             bufferedWriter.write(fileContent);
                      }   
             } catch (IOException e) {}
         }
         
    }

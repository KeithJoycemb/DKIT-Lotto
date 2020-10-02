package lottoproject;
import java.util.*;

/**
 *
 * @author keith
 */
public class Ticket 
{
    private String playerName,playerAddress, playerPhNum;
    private ArrayList<Integer> lottoNums = new ArrayList<>();
    
    /**
     *this is the constructor for the ticket class 
     * @param playerName is the players name 
     * @param playerAddress is the players address
     * @param playerPhNum is the players phone number
     * @param lottoNums is an array list of the players lotto numbers 
     */
        public Ticket(String playerName, String playerAddress, String playerPhNum, ArrayList<Integer> lottoNums) 
        {
            this.playerName = playerName;
            this.playerAddress = playerAddress;
            this.playerPhNum = playerPhNum;
            this.lottoNums = lottoNums; 
        }

        @Override
        public String toString() 
        {
            return "Ticket{" + "playerName=" + playerName + ", playerAddress=" + playerAddress + ", playerPhNum=" + playerPhNum + ", lottoNums=" + lottoNums + '}';
        }

        /**
        * this is an empty class to allow Ticket tempT = new Ticket(); to work in public static Ticket addTicket(double playerNums) method in the game.java file
        */
         public Ticket()
         {
         }

    /**
     *This is to get the players home address
     * @return it returns the players home address
     */
        public String getPlayerAddress() 
        {
            return playerAddress;
        }

    /**
     *this will change the players home address
     * @param playerAddress gives an address for the players
     */
        public void setPlayerAddress(String playerAddress) 
        {
            this.playerAddress = playerAddress;
        }

    /**
     *This is to get the players name 
     * @return this will return the players name 
     */
        public String getPlayerName() 
        {
            return playerName;
        }

    /**
     *This will change the players name 
     * @param playerName will give the players a name 
     */
        public void setPlayerName(String playerName) 
        {
            this.playerName = playerName;
        }

    /**
     *This will get the players phone number 
     * @return this will return the players phone number 
     */
        public String getPlayerPhNum() 
        {
            return playerPhNum;
        }

    /**
     *This will change the players phone number
     * @param playerPhNum will give the players a phone number
     */
        public void setPlayerPhNum(String playerPhNum) 
        {
            this.playerPhNum = playerPhNum;
        }

    /**
     *This will get the lottery numbers for the player
     * @return this will return the players lottery numbers 
     */
        public ArrayList<Integer> getLottoNums() 
        {
            return lottoNums;
        }

    /**
     *This will set the players lottery numbers
     * @param lottoNums will give the players lottery numbers
     */
        public void setLottoNums(ArrayList<Integer> lottoNums) 
        {
            this.lottoNums = lottoNums;
        }

    /**
     *This will check the lottery numbers that are drawn with the players lottery numbers to see if any player lottery numbers match the drawn lottery numbers
     * Will then be counted if there are any matches 
     * @param winningNums this is the lottery number that have been drawn
     * @param ticketNums this is the players lottery number
     * @return this will return the number of matches 
     */
        public static int howManyMatches(ArrayList<Integer> winningNums, ArrayList<Integer>ticketNums)
        {
            int count = 0;

            for(int match : ticketNums)
            {
                if(winningNums.contains(match))
                {
                    count++;
                }
            }
            return count;
        }  
}

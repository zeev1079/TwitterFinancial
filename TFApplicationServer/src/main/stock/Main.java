

package softwareEnginering;

import java.io.IOException;
import java.math.BigDecimal;
import twitter4j.Query;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import java.util.Scanner;
import twitter4j.TwitterException;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {

         TwitterRetry TR=new TwitterRetry();
        Scanner in = new Scanner(System.in);        
        System.out.println("please enter a ticker name of a public trading company");
        String ticker = in.nextLine();        
        if(ticker.isEmpty()){System.out.println("the ticker is empty");return;}
        if(ticker.length() > 5){System.out.println("the ticker is too long");return;}
        ticker="$"+ticker.toUpperCase();
        StockInfo stock= new StockInfo(ticker.substring(1));
        stock.Print();
        int semantics = MentionPumpSymbols.SearchSemanticsStocks(ticker,TR);
        if(semantics != Integer.MAX_VALUE)
        {
            if(semantics<=0)System.out.println("it's negetive"+semantics);else
            if(semantics > 0)System.out.println("it's postive "+semantics);
        }else
            System.out.println("an error accured during the project");
        //user semantics method to find if the word given is negative or postive

    }


}



package softwareEnginering;

/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
//imports
import twitter4j.Status;
import twitter4j.TwitterException;
import java.io.IOException;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
//import twitter4j.StreamController.User;
//the meat of this project, here we search and get all the data from twitter, with ticker names
public class MentionPumpSymbols
{
    public static int SearchSemanticsStocks(String ticker, TwitterRetry TR) throws TwitterException, IOException
    {
        try{
         FloridaDate date=new FloridaDate();
        Query query = new Query(ticker);
        query.setCount(100);
        query.setSince("2015-"+date.month+"-"+(date.day));
        TR.checkRateLimitStatus();
        QueryResult result;
        long sum=0;
        int[] NP=new int[1];
        NP[0]=0;
        result=TR.twitter.search(query);
     while(query != null&&sum < 1000)
     {
        List<Status> tweets = result.getTweets();
        String text;
        for(Status tweet: tweets)
        { text=tweet.getText();
            if(text.indexOf(ticker)!=-1||text.indexOf(ticker.toLowerCase())!=-1)
            {
                sum++;
                semanticsFinder(text,NP);
            }
        }
        TR.checkRateLimitStatus();
        query=result.nextQuery();
        if(query!=null){ TR.checkRateLimitStatus();
        result=TR.twitter.search(query);}
      }
      return NP[0];
        }
        catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to createfrinds: " + te.getMessage());
            if (te.getStatusCode()==503) {
            try {
                Thread.sleep(120*1000);// wait 2 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
            else
            System.exit(-1);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        return Integer.MAX_VALUE;
    }






    //this is the heart in regards to finidng semantics and negative
    //input: tweet text and a pointer to an interger that indicate if it's postive or negative
    //output: none
    private static void semanticsFinder(String text,int[] arr)
    {        
        String postive="postive##raises##elevate##boost##increas##hight##rais##lifting##profit##higher##better## new ##accept##acquired##bought##buy rating##accomplish##agrees##agreed##approves##approved##advantage##benefit##beneficial##effective##create##famous##friendly##growing##deal##optimistic##productive##safe ##secure##undervalued##won ##victory##wealthy##advance##achieve##hits##improv##enhance##additional##surplus##happy##payoff## aid ##building##success##contract##revolutionary##sign##encourag##Perfect##beats##agreement##appointing##leader##names##BIG ##awarded##annual bonus##appoints##hired##expands##“buy” Rating## rise##outstanding##rated buy##strong##hiring##impressive##recommend## efficient## effective##popped##spiking## beat##games up##acquisition## spike ## tapp ##exploring##to explore##possible sale## huge ##good result##soaring##reject##grows##grew##talks to buy##outperform## joins ##to resolve## tanks##commences##launch## opens##excited##the better##adopting##small fine##good job##play of the day## nice ##widespread application##work together##partnership##to acquire##feel good##optimism##great quarter##-beating##were good##higher off##reimbursement##refund##BIG gains##best place## impFroves ##exceeds##extended## enables##overweight##good news for##to resume##well timed##met primary## acquires##extension## purchas";//to Sell
        String negatives="misses##weak##plunging##disappoint##losses##negative##concern##concerned##incomplete##unfortunately## fall##awful##collapse##corrupt##damage##damaging##dishonest##faulty##guilty##harmful##horrible## quit ##reject##terrible##overvalue##uncertain##fired##lowest##lowered##less##lower##threat##downgrade##underweight##decreas## drop## slump## sink##mistake##sell rating##net loss##falls##decline##reduction##reduce##defeat##settle down##disprove##disagree##closes##shut down##discontinue##tumbles##downfall##pounded##crushed##ominous signs##bad signs##revenue down##fails##drops##refuse##failed##deficient##missing##insufficient##fined##bankruptcy##defeat##poor##disappointing##pummeled##slammed##crummy##murder##trouble## shit ## bullshit ## dips ##resign##step down##contested##inept##inappropriate##inefficient##ineffective##foolish##shitty##miss earnings##failing## joke##does not like##do not like##theft##compromised##security concerns##hacked##accused##glitch##negatively## fell ##hilarious## scam## jail ##desperate## fraud ##risks##infringement suits##criticisms##heated debate##tumbling##no Impact##insufficient##squash## slowdown##don't do##unsustainable##don't see##unsecured##not familiar##shareholders tired##worsed day## unable##violation##unprofitable##postponed##downward trend##not enough##CEO sells##CFO sells## sells ##steps down##loss widens##CEO departs## cancel## slow##refusal##did not meet##rating lower## miss##plunge##hammered## crash##stock is down##not in shareholders##separation##lowers rating##plummeting##failure## loss";//offering of common stock##
        String[] NL=negatives.split("##");
        String[] PL=postive.split("##");
        if(text.isEmpty()) return;
        text=text.toLowerCase();
             int NI=-1;
             int PI=-1;
             int max=Math.max(NL.length,PL.length);
               NI=-1;PI=-1;
                for(int i=0;i<max&&(NI==-1||PI==-1);i++)
                {
                  if(NI==-1&&i<NL.length)
                  {
                  NI=text.indexOf(NL[i]);
                  if((NL[i].compareTo("less")==0||NL[i].compareTo("lower")==0)&&text.indexOf("expected")==-1)NI=-1;
                  if((NL[i].compareTo(" new ")==0)&&(text.indexOf("new alert")!=-1||text.indexOf("rated new")!=-1||text.indexOf("new news")!=-1))NI=-1;
                  if((NL[i].compareTo(" sells ")==0)&&text.indexOf("shares")==-1)NI=-1;
                  if((NL[i].compareTo("reject")==0)&&text.indexOf("offer")!=-1)NI=-1;//hits & misses
                  if((NL[i].compareTo("misses")==0)&&text.indexOf("hits & misses")!=-1)NI=-1;//hits & misses
                  if((NL[i].compareTo("beneficial")==0)&&text.indexOf("ownership")!=-1)NI=-1;//hits & misses
                   if((NL[i].compareTo(" quit ")==0)&&text.indexOf("not quit")!=-1)NI=-1;//hits & misses
                  if((NL[i].compareTo(" aid ")==0)&&text.indexOf("aid corp")!=-1)NI=-1;//hits & misses
                  if(NI!=-1)
                  {
                      //System.out.println(NL[i]);
                    arr[0]--;//--
                  }
                  }
                  if(PI==-1&&i<PL.length)
                  {
                  PI=text.indexOf(PL[i]);
                  if((PL[i].compareTo("more")==0||PL[i].compareTo("higher")==0)&&text.indexOf("expected")==-1)PI=-1;
                  if((NL[i].compareTo(" new ")==0)&&(text.indexOf("new alert")!=-1||text.indexOf("rated new")!=-1||text.indexOf("new news")!=-1))NI=-1;
                  if((NL[i].compareTo(" sells ")==0)&&text.indexOf("shares")==-1)NI=-1;
                  if((NL[i].compareTo("reject")==0)&&text.indexOf("offer")==-1)NI=-1;
                   if((NL[i].compareTo("hits")==0)&&text.indexOf("hits & misses")!=-1)NI=-1;//hits & misses
                  if((NL[i].compareTo("beneficial")==0)&&text.indexOf("ownership")!=-1)NI=-1;//hits & misses
                   if((NL[i].compareTo(" quit ")==0)&&text.indexOf("not quit")!=-1)NI=-1;//hits & misses
                   if((NL[i].compareTo(" aid ")==0)&&text.indexOf("aid corp")!=-1)NI=-1;//hits & misses
                  if(PI!=-1)
                  {
                     // System.out.println(PL[i]);
                      arr[0]++;
                  }
                 }
                }
              if(NI!=-1&&PI!=-1){arr[0]--;}
    }
}



package softwareEnginering;

/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
//imports
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.Map;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

//this inteface will deal with all the twitter exceptions, more exculisevly rate limit of the API
//the interface also chage token keys to pass the twitter rate limit
public class TwitterRetry { // hack to extend Twitter4J and retry if rate limit exceed

	
	public static TwitterRetry _instance = null;
        public LinkedList<String> Nodes;
         public LinkedList<String> Node;
        public  ConfigurationBuilder cb;
       public Configuration configuration;
       public TwitterFactory factory;
       public Twitter twitter;

	public TwitterRetry()
        {
           LinkedList<String> Nodes2=new LinkedList<String>("lklT09PH0LYTg33rdPZAxo3LL","sqa3v6CIVDHTXIr4qj00Jb5VHLaq2fMG9bfu2hsVsK3gIp0nS7","2635254941-oqPBrGjkusLwsQzNPALhEM7vLvRFIP0Jx52HiqC","1BTe9sawKA5s9HcCwHOZqcO26636mvIqaZLbcvfe7O0Gl", null);
            this.Nodes=new LinkedList<String>("LQ82PRbsJf9gDaMo03DIKhsPY","zpgPx5IoroQNbgkNhZOWTSgrZVRRYJ38vZtUVVVfMd6dU8Ivtj","2472860166-lOzHdcGm9g3IjgUkw9NyBb5NG9Hh3voKM3PaSje","p36PvmKh99U4OB6ZvLSznUlsrwdjtDQBT1aFDPKdo285U", Nodes2);
           Nodes2.setNext(Nodes);
           this.Node=this.Nodes;
         cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
        .setOAuthConsumerKey("LQ82PRbsJf9gDaMo03DIKhsPY")
        .setOAuthConsumerSecret("zpgPx5IoroQNbgkNhZOWTSgrZVRRYJ38vZtUVVVfMd6dU8Ivtj")
        .setOAuthAccessToken("2472860166-lOzHdcGm9g3IjgUkw9NyBb5NG9Hh3voKM3PaSje")
        .setOAuthAccessTokenSecret("p36PvmKh99U4OB6ZvLSznUlsrwdjtDQBT1aFDPKdo285U");
         configuration = cb.build();
         factory = new TwitterFactory(configuration);
          twitter = factory.getInstance();
	}
        /*
lklT09PH0LYTg33rdPZAxo3LL
sqa3v6CIVDHTXIr4qj00Jb5VHLaq2fMG9bfu2hsVsK3gIp0nS7
2635254941-oqPBrGjkusLwsQzNPALhEM7vLvRFIP0Jx52HiqC
1BTe9sawKA5s9HcCwHOZqcO26636mvIqaZLbcvfe7O0Gl
 */
        
        public  void setNewAut()
        {
         this.Node=this.Node.getNext();
         cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
        .setOAuthConsumerKey((String)this.Node.getData1())
        .setOAuthConsumerSecret((String)this.Node.getData2())
        .setOAuthAccessToken((String)this.Node.getData3())
        .setOAuthAccessTokenSecret((String)this.Node.getData4());
         configuration = cb.build();if(configuration==null){System.out.println("it null"+(String)this.Node.getData1()); this.setNewAut();return;}
         factory = new TwitterFactory(configuration);
          twitter = factory.getInstance();
        //  System.out.println(this.Node.getData1());
            
        }
        public void printNodes() throws TwitterException
        {
            int c=2;
            while(c-->0)
            {
                this.setNewAut();
              System.out.println(twitter.getScreenName());

            }

        }
        //block mtf spamers
        public void blockSpamers(String s) throws TwitterException
        {
            int c=2;
            while(c-->0)
            {
              
                System.out.println(twitter.getScreenName());
               twitter.createBlock(s);
                this.setNewAut();
            }

        }
        //destroy mtf spamers
         public void destroyBlockSpamers(String s) throws TwitterException
        {
            int c=2;
            while(c-->0)
            {
               this.setNewAut();
                System.out.println(twitter.getScreenName());
               twitter.destroyBlock(s);
            }

        }


	public static TwitterRetry getInstance(){
		if (_instance == null) _instance = new TwitterRetry();
		return _instance;
	}

	public  void  checkRateLimitStatus()
        {

		try {
                  
		Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus();
                //RateLimitStatus limit = rateLimitStatus.get("user");

                for (String endpoint : rateLimitStatus.keySet())
                {
                    RateLimitStatus limit = rateLimitStatus.get(endpoint);
                   // System.out.println(" Limit: " + limit.getRemaining());


		//System.out.print("- limit: "+limit.getRemainingHits() +"\n");
		if (limit.getRemainingHits() <= 2) {//it was 2
                    System.out.println(Node.getData1());
			int remainingTime = limit.getSecondsUntilReset();
			System.out.println("Twitter request rate limit reached. Waiting "+remainingTime/(2*60)+" minutes to request again.");
                        this.setNewAut();
			try {
				Thread.sleep(remainingTime*1000/2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        
		   }

                }
		} catch (TwitterException te) {
			System.err.println(te.getMessage());
			if (te.getStatusCode()==503) {
				try {
					Thread.sleep(240*1000);// wait 2 minutes
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());

		}
	}

}


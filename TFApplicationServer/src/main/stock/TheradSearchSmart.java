

package softwareEnginering;

/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//this interface is to fully seach with multi thread, by the help of the interface ThreadSearch
public interface TheradSearchSmart
{
    //  public TheradSearchSmart(String s,String sss, TwitterRetry TR,int count) throws IOException;
public void AddTherad(String s,String sss, TwitterRetry TR,int role) throws IOException;//add thread to run
  public void StartAll();//start all threads
   public void JoinAll() throws InterruptedException;//wait untill all trhead re done

}

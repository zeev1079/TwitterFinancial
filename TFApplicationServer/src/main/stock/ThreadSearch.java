

package softwareEnginering;
//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author zeev feldbeine
 * * Copyright -  Zeev feldbeine
 */
//this inteface for multi thread search, to reduce time
public interface ThreadSearch //extends Thread
{
//public ThreadSearch(String name,TwitterRetry TR,BufferedWriter writer2,int role,int sum);
public void run();

}

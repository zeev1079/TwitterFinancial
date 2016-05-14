/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareEnginering;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Zeev feldbeine
 * CopyRight -  Zeev feldbeine
 */
public class FloridaDate
{
    private GregorianCalendar date;
    public int day, month, year,min,hour;
    public int dayOFweek;
    public int sec;
    public FloridaDate()
    {
        date= new GregorianCalendar();
        day = date.get(Calendar.DAY_OF_MONTH);
      month = date.get(Calendar.MONTH)+1;
       hour=date.get(Calendar.HOUR);
     min=date.get(Calendar.MINUTE);
      year = date.get(Calendar.YEAR);
     dayOFweek=date.get(Calendar.DAY_OF_WEEK);
     sec=date.get(Calendar.SECOND);
    }
    public GregorianCalendar getDate()
    {
        return date;
    }
    public int getRealSeconds()
    {
        return (sec=date.get(Calendar.SECOND));
    }
    public int getRealmin()
    {
        return (min=date.get(Calendar.MINUTE));
    }
}

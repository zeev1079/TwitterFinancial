

package softwareEnginering;

/**
 *
 * @author zeev feldbeine
 * Copyright -  Zeev feldbeine
 */
public class LinkedList<String>
{

   private String data1;
   private String data2;
   private String data3;
   private String data4;
   private LinkedList<String> next;

   public LinkedList(String data1,String data2,String data3,String data4, LinkedList<String> next)
   {
      this.data1 = data1;
      this.data2 = data2;
      this.data3 = data3;
      this.data4 = data4;
      this.next =next;
   }


          public String getData1() {
            return data1;
          }
          public String getData2() {
            return data2;
          }
          public String getData3() {
            return data3;
          }
          public String getData4() {
            return data4;
          }

          public void setData1(String data) {
            this.data1 = data;
          }
          public void setData2(String data) {
            this.data2 = data;
          }
            public void setData3(String data) {
            this.data3 = data;
          }
          public void setData4(String data) {
            this.data4 = data;
          }

          public LinkedList getNext() {
            return next;
          }

          public void setNext(LinkedList<String> next) {
            this.next = next;
          }
}

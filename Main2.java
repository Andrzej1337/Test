/* Online Java Compiler and Editor */
import java.util.HashMap;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.net.*;
import java.io.*;



public class Main2 extends Thread{

     public static void main(String []args)throws IOException{
         Socket socket = null;
         InputStreamReader inputStreamReader = null;
         OutputStreamWriter outputStreamWriter = null;
         BufferedReader bufferedReader = null;
         BufferedWriter bufferedWriter = null;
         Random rd = new Random();

         try {
            socket = new Socket("localhost", 4999);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
	     Random ran = new Random();
            while(true){
           	int random_integer = ran.nextInt(10000-5000) + 5000;
               Thread.sleep(random_integer);
               HashMap<Long, Integer> signal = new HashMap<Long, Integer>();
         	
               long ut1 = Instant.now().getEpochSecond();
               int nxt;  
               
        
              
               boolean nxe = ran.nextBoolean();
        	if(nxe == true)
        	   nxt = 1;
        	else
        	   nxt = 0;
               signal.put(ut1 , nxt );
               
               for (long i : signal.keySet()) {
                  
                  bufferedWriter.write(ut1 + ":" + signal.get(i));
               }
               bufferedWriter.newLine();
               bufferedWriter.flush();
                           
            }
         } catch (Exception e) {
            //TODO: handle exception
         }

   }
}


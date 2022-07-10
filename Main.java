/* Online Java Compiler and Editor */
import java.net.*;
import java.io.*;


public class Main extends Thread{

     public static void main(String []args) throws IOException{

         Socket socket = null;
         InputStreamReader inputStreamReader = null;
         OutputStreamWriter outputStreamWriter = null;
         BufferedReader bufferedReader = null;
         BufferedWriter bufferedWriter = null;

         ServerSocket serverSocket = new ServerSocket(4999);
         socket = serverSocket.accept();

         inputStreamReader = new InputStreamReader(socket.getInputStream());
         outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

         bufferedReader = new BufferedReader(inputStreamReader);
         bufferedWriter = new BufferedWriter(outputStreamWriter);
         boolean flaga;
         String msg2 = bufferedReader.readLine();

            
         String[] str = msg2.split(":");
         if(str[1] == "0"){
            flaga = false;
            System.out.println(str[0] + ": " +str[1]);
         }
         else{
            flaga = true;
            System.out.println(str[0] + ": " +str[1]);
         }
         while(true){

            String msg = bufferedReader.readLine();

            
            String[] str2 = msg.split(":");
            int wart = Integer.valueOf(str2[1]);

            if(wart == 1 && flaga == false){
               System.out.println(str2[0] + ": " +str2[1]);
               flaga = true;
               bufferedWriter.newLine();
               bufferedWriter.flush();  
            }

            else if(wart == 0 && flaga == true){
               System.out.println(str2[0] + ": " +str2[1]);
               flaga = false;
               bufferedWriter.newLine();
               bufferedWriter.flush();
            }
            System.out.println(str2[0] + ": " +str2[1]);
         }
      /*HashMap<Long, Integer> capitalCities = new HashMap<Long, Integer>();
        long ut1 = Instant.now().getEpochSecond();
               
        Random ran = new Random();
  
        
        int nxt = ran.nextInt(1);
  
        capitalCities.put(ut1 , nxt );
         
         for (long i : capitalCities.keySet()) {
            
            System.out.println(ut1 + ":" + capitalCities.get(i));
         }*/

     }
}

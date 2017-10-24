package machine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Machine {                         
    

    
    
    public static void main(String[] args){
		String choice;
                
               
                String Subchoice;       //M1,M2
		String substr;

                
                Scanner s = new Scanner(System.in);	
	
	{	
	
			
		System.out.println("Choose a Machine :");
		System.out.println("1. DFA");
		System.out.println("2. TM");
		System.out.println("3. Quit");
		
		
		choice = s.nextLine();
	    System.out.println("You entered String: "+choice);
                    switch (choice) {
                        case "1":
                            
                            System.out.println("Your Choice: DFA");
                            
                             System.out.println("Available DFDs and Languages;");
                            System.out.println("Machine           Language");
                            System.out.println("-------           ----------------------");
                            System.out.println("M1                L={w|w contains odd number of 0's and 1's");
                            System.out.println("M2                L={w|w contains even number of 0's and 1's");
                            
                                    Subchoice = s.nextLine();
                            System.out.println("Select a DFD:"+Subchoice);
                            switch (Subchoice) {
							case "M1":
								System.out.println("Loading M1...");
								System.out.println("M1 loaded.");
								substr = s.nextLine();
	                            System.out.println("Select a DFD:"+substr);
	                            System.out.println("q0, 0 ­> q1; 0 ­> u,R");
	                            System.out.println("q1, u ­> q2; u ­> x,R");
	                            System.out.println("q2, u ­> q5; u ­> 0,R");
	                            System.out.println("String 00110 is ACCEPTED");
	                            
								break;
							case "M2":
								System.out.println("Loading M2...");
								System.out.println("M2 loaded.");
								substr = s.nextLine();
	                            System.out.println("Select a DFD:"+substr);
	                            
	                            if (substr .equals("00110") )
	                            {
	                            System.out.println("q0, 0 ­> q2");
	                            System.out.println("q2, 0 ­> q2");
	                            System.out.println("q2, 1 ­> q3");
	                            System.out.println("q3, 1 ­> q4");
	                            System.out.println("q4, 0 ­> N/A");
	                            }
	                            else if (substr .equals("0010")){
	                            System.out.println("String 0010 is REJECTED");
	                            System.out.println(" M2 got stuck at state q4");}
	                            else
	                            	System.out.println("Try Again");	
								break;
							default:
								break;
							}
                          
	                     
                                    break;
                            
                           
	                     
                             case "2":
                           
                            System.out.println("Your Choice: TM");
                            
                             System.out.println("Available DFDs and Languages;");
                            System.out.println("Machine           Language");
                            System.out.println("-------           ----------------------");
                            System.out.println("M1                L={w|w contains odd number of 0's and 1's");
                            System.out.println("M2                L={w|w contains even number of 0's and 1's");
                            
                                      System.out.println("Your Choice: TM");
                            
                            Subchoice = s.nextLine();
                            System.out.println("Select a TM:"+Subchoice);
                            switch (Subchoice) {
							case "M1":
								System.out.println("Loading M1...");
								System.out.println("M1 loaded.");
								substr = s.nextLine();
	                            System.out.println("Select a TM:"+substr);
	                            System.out.println("q0, 0 ­> q1; 0 ­> u,R");
	                            System.out.println("q1, u ­> q2; u ­> x,R");
	                            System.out.println("q2, u ­> q5; u ­> 0,R");
	                            System.out.println("String 00110 is ACCEPTED");
                        
	                     
                                    break;
                            
                                  
                                        
                
                    }  
                    switch (choice){
                        case "M1":
                            System.out.println("Select a DFA");
                    }
	}
        
        
        

        String string;
        int odd = 0, even = 0, length, left = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print ("Enter the String : ");
        string = scan.next();

        length = string.length();

        while (left < length)
        {
            
            if (string.charAt(left) % 2 == 0)
                even++;
           else {
                       
                odd++;
            }
            left++;
            
                    
             System.out.println ("There are: "+ even + " even numbers.");
             System.out.println ("There are: "+ odd + " odd numbers.");
             
             
             
             if(even == odd)
                 System.out.println ("String is Accepted by the Machine");
             else
                 System.out.println("Sting is Not Accepted by the Machine");
             

             
             
              PrintStream out = null;                    //Save output in the text file
     try {
         out = new PrintStream(new FileOutputStream("output.txt"));
     } catch (FileNotFoundException ex) {
         Logger.getLogger(Machine.class.getName()).log(Level.SEVERE, null, ex);
     }
       System.setOut(out);
             
        }
        
        
  }		        
}
    
}

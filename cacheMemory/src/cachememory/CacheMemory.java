package cachememory;                              


import java.util.Scanner;

public class CacheMemory {                         
    
    
    
    static int[][] InitializeMemory()              
       {
           int arrayMemory[][] =  {
                                                
        		   
{	0,	1,	2,	3,	4,	5,	6,	7,	8,	9,	10,	11,	12,	13,	14,	15	}, 
{	10,	11,	12,	13,	14,	15,	16,	17,	18,	19,	20,	21,	22,	23,	24,	25	}, 
{	20,	21,	22,	23,	24,	25,	26,	27,	28,	29,	30,	31,	32,	33,	34,	35	}, 
{	30,	31,	32,	33,	34,	35,	36,	37,	38,	39,	40,	41,	42,	43,	44,	45	}, 
{	40,	41,	42,	43,	44,	45,	46,	47,	48,	49,	50,	51,	52,	53,	54,	55	}, 
{	50,	51,	52,	53,	54,	55,	56,	57,	58,	59,	60,	61,	62,	63,	64,	65	}, 
{	60,	61,	62,	63,	64,	65,	66,	67,	68,	69,	70,	71,	72,	73,	74,	75	}, 
{	70,	71,	72,	73,	74,	75,	76,	77,	78,	79,	80,	81,	82,	83,	84,	85	}, 
{	80,	81,	82,	83,	84,	85,	86,	87,	88,	89,	90,	91,	92,	93,	94,	95	}, 
{	90,	91,	92,	93,	94,	95,	96,	97,	98,	99,	100,	101,	102,	103,	104,	105	}, 
{	100,	101,	102,	103,	104,	105,	106,	107,	108,	109,	110,	111,	112,	113,	114,	115	}, 
{	110,	111,	112,	113,	114,	115,	116,	117,	118,	119,	120,	121,	122,	123,	124,	125	}, 
{	120,	121,	122,	123,	124,	125,	126,	127,	128,	129,	130,	131,	132,	133,	134,	135	}, 
{	130,	131,	132,	133,	134,	135,	136,	137,	138,	139,	140,	141,	142,	143,	144,	145	}, 
{	140,	141,	142,	143,	144,	145,	146,	147,	148,	149,	150,	151,	152,	153,	154,	155	}, 
{	150,	151,	152,	153,	154,	155,	156,	157,	158,	159,	160,	161,	162,	163,	164,	165	}
                                                 
                                               };

           return arrayMemory;
           
       }
	   
	   static int[][] InitializeCache()              
       {

           int arraycache[][] =  {
                                 {	0,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	0,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	1,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	1,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0       },
                                 {	2,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	2,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	3,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                                 {	3,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	}
                                 
                                  };             

           return arraycache;                       //The following array is Two Way Set Associative

       }
	
	 
	 static int readmiss = 0;
	 static int readhits = 0;
	 static int writemiss = 0;
	 static int writehits = 0;
	 static int[][] arraymemory;
	 static int[][] arraycache;
     

	
	
	static void ReadFromMemoryToCache(int blockNo, int offSet, int voidbit)
    {
		readmiss++;
		Scanner s = new Scanner(System.in);	
		
		String block;
		String offSetNo;
		String voidBit;
		
		System.out.println("Enter Block Number:(From  0 to 15)");
		block = s.nextLine();	
		blockNo = Integer.parseInt(block);
		
		System.out.println("Enter offSet Number(From 0 to 3)" );
		offSetNo = s.nextLine();
		offSet = Integer.parseInt(offSetNo);
		
		System.out.println("Enter Number(Either 0 or 1) to read the Higher or Lower block of the memory. ");
		voidBit = s.nextLine();
		voidbit = Integer.parseInt(voidBit);
		
		 
		 
		 
		System.out.println("get_cpu_action(); action = READ, block :"+block+", offset :"+offSetNo);
		System.out.println("cache read miss block ["+block+"] offset["+offSetNo+"] ["+voidBit+"]");
	
        int offSettemp=0;
        for(int i=0;i<16;i++)
        {
            if (voidbit == 0)
            {
                offSettemp = offSet * 2 + 1;
                arraycache[offSettemp][i + 3] = arraymemory[blockNo][i];
            }
            else
            {
                offSettemp = offSet * 2 + 0;
                arraycache[offSettemp][i + 3] = arraymemory[blockNo][i];
            }
           
        }
        arraycache[offSettemp][2] = blockNo;
         
    }
	
	
	static void WriteToMemory(int blockNo, int offSet, int value)
    {
        writemiss++;
        
        Scanner in = new Scanner(System.in);	
		
		String block;
		String offSetNo;
		String enteredvalue;
		
		System.out.println("Enter Block Number:(Value  0 to 15)");
		block = in.nextLine();	
		blockNo = Integer.parseInt(block);
		
		System.out.println("Enter offSet Number:(Value  0 to 15)");
		offSetNo = in.nextLine();
		offSet = Integer.parseInt(offSetNo);
		
		System.out.println("Enter any value which you want to write to the Memory.");
		enteredvalue = in.nextLine();
		value = Integer.parseInt(enteredvalue);
		
        arraymemory[blockNo][offSet] = value;
         
    }
	
	
	
	static void PrintMemory(int arrMemory[][])
    {
		System.out.println("Printing Memory");
        for (int i = 0; i < 16; i++ )
        {
            for (int j = 0; j < 16; j++)
            {
            	System.out.print(arraymemory[i][j] + "  ");
            }
            System.out.println("");
            
        }
    }
	
	static void PrintCachePerformance()
	{
		
		
	
		System.out.println("Write Misses out put: "+writemiss);
		System.out.println("Write Hits out put : "+writehits);
		System.out.println("Cache performance output ");
		
				
	}
	
	static void PrintCache()
	{
		
		
		System.out.println("Read Misses output : "+readmiss);
		System.out.println("Read Hits output: "+readhits);
				
	}
	
	static void Quit()
	{
		System.out.println("Quit");
	}
	
	 static void PrintCache(int arrC[][])
     {
		 System.out.println("Print Cache");
		 
         for (int i = 0; i < 8; i++)
         {
             for (int j = 0; j < 19; j++)
             {
                 String prefix = "";

                 if (j == 0)
                 {
                     prefix = "Set = ";
                 }
                 else if (j == 1)
                 {
                     prefix = "V = ";
                 }
                 else if (j == 2)
                 {
                     prefix = "Tag = ";
                 }
                 System.out.print(prefix + arraycache[i][j] + "  ");
             }
             System.out.println("");
         }
     }
         
         	public static void main(String[] args){
		String choice;
		
		arraymemory = InitializeMemory();
		arraycache = InitializeCache();
		
		PrintCachePerformance();
		PrintMemory(arraymemory);
	    PrintCache(arraycache);
	    
	    PrintCache();
		PrintMemory(arraymemory);
	    PrintCache(arraycache);
	   
		Scanner s = new Scanner(System.in);	
	while(true)
	{	
	
			
		System.out.println("Enter Choice:");
		System.out.println("[0] to Read from Memory");
		System.out.println("[1] to Write to Memory");
		System.out.println("[2] to Quit");
		
		
		choice = s.nextLine();
	    System.out.println("You entered string "+choice);
	    if(choice.equals("0"))
	    {
	    	System.out.println("Reading from Memory");
	    	ReadFromMemoryToCache(0,0,0);
	    	PrintCachePerformance();
	    	PrintCache();
			PrintMemory(arraymemory);
		    PrintCache(arraycache);
	    }
	    else if(choice.equals("1")) {
	    	System.out.println("Writing To Memory");
	    	WriteToMemory(0,0,0);
	    	PrintCachePerformance();
	    	PrintCache();
			PrintMemory(arraymemory);
		    PrintCache(arraycache);
		}
	    else if (choice.equals("2")) {
	    	System.out.println("Quit");
			Quit();
		}
	    else {
	    	System.out.println(" ");
		}  
	}
			        
}
	

}


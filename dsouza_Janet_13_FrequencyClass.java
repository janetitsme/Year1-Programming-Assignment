	/* This is the central processing class for the application.
	 Note that it does not have a "main" method, and so cannot
	 be run directly from Eclipse, but must be called from  another method.*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

	public class dsouza_Janet_13_FrequencyClass 
	{
		
		   static String str;
		   static int len;
		   static List<String> al=new ArrayList<String>();
		   static Scanner sc=new Scanner(System.in);
		   static int varCnt;
		   
	       
		   public void inputText(int flag) throws IOException
		   {
			   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			  try
			   {
				   char ans;
				   str=recurseReadUserInput(br,flag);
		       
					   	if ( (!str.equals("")) && (str!=null))
			           {
				    	   len = str.length();
				    	   String s1 = str.replaceAll("   ", "");
				    	   String ss = s1.replaceAll("[^a-zA-Z]", "");                //Remove all characters other than alphabets
				    	   ss=ss.toLowerCase();
				    	   varCnt = ss.length();
				    	   al.add(ss);
					       charFrequency(al,varCnt,flag);
			           }
					 		   	
			   do
			   {
				   System.out.println("Would you like to continue : 1. YES 2. NO");
				   try{
					   ans=sc.next().charAt(0);		//Get user input from keyboard
				  
						   switch(ans)
						   {
						   case 'Y':
						   case 'y':
							   displaymenu();			
							   break;
						   case 'N':
						   case 'n':
							   break;	
							
						   default:
							System.out.println("Sorry no such choice");
							break;
						   }
				   }
				   catch(NumberFormatException e){System.out.println("Error Catched");break;}
				   catch(InputMismatchException e){System.out.println("Error Catched Characters not allowed");break;}					   
			   }while((ans=='Y') || (ans=='y'));
						
			   }    
			   
			   catch(InputMismatchException e)
			   {
				   System.out.println("Entered Value is not a number. You got only 2 options either 1 or 2");
			   }
			   
			   
			   
		   }
		   
		   //recursive method to repeatedly accept string until quit is entered
		   private String recurseReadUserInput(BufferedReader br, int flag)
			{
				try 
				{
					System.out.print("Enter a String  or quit to exit  : ");
					String strInput = br.readLine();
					if (strInput.equalsIgnoreCase("quit") == false)
					{
					   	if ( (!strInput.equals(" ")) && (strInput!=null))
				           {
									   	   String stringSize="";
										   String s1 = strInput.replaceAll("  ", "");
								    	   String ss = s1.replaceAll("[^a-zA-Z]", "");
								    	   stringSize=ss;
								    	   stringSize=stringSize.toLowerCase();
								    	   len=stringSize.length();
								    	   al.add(stringSize);				    	  
				           }
					   	recurseReadUserInput(br,flag);					
					}
					else if (strInput.equalsIgnoreCase("quit"))
					{
						try
						{
						  /* String stringSize="";
						   String s1 = strInput.replaceAll("  ", "");
				    	   String ss = s1.replaceAll("[^a-zA-Z]", "");
				    	   stringSize=ss;
				    	   stringSize=stringSize.toLowerCase();
				    	   varCnt = stringSize.length();
				    	   charFrequency(al,varCnt,flag);*/
						}catch(Exception ex)
						{}
							
						throw new Exception();
						
					}
					else
					{
						throw new InputMismatchException();
					}
					
					return strInput;

				}
				catch (InputMismatchException ime)
				{
					System.out.println("You need a String to Process...");
					return null; 
				}
				catch (Exception e)
				{
					System.out.println();
					return null;
				}
			}
		   
		   //Menu option to distinguish text for analysis and text as filename
		   public void displaymenu() throws IOException
		   {
			   int choice=0;
			   do{
			   System.out.println("*********** M E N U **********");
			   System.out.println("1. Text for Analysis");
			   System.out.println("2. Text as Filename");
			   System.out.println("3. Information in Graphical Form");
			   System.out.println("4. Graph for Special Characters");
			   System.out.println("5. Frequency of Lengths of Words");
			   System.out.println("6. Quit");
			   
			   System.out.println("\nChoose the Menu Option :");
				   try{
					   choice=sc.nextInt();		//Get user input from keyboard
				  
						   switch(choice)
						   {
						   case 1:
							   System.out.println("Text for Analysis");
							   inputText(1);			// User input from keyboard
							   break;
						   case 2:
							   System.out.println("Text as Filename for Analysis"); 
							   fileCharFrequency();   //method to read from file
							   break;
						   case 3:
							   System.out.println("Displaying text in graphical Format");
							   inputText(3);					//method to display graph
							   break;
						   case 4:
							   System.out.println("Special characters in graphical form"); 
							   getGraphForSpecialChar(4);
							   break;
						   case 5:
							   System.out.println("Frequency of Lengths of Words");
							   countWordFrequency(5);					//method to count frequency of words
							   break;
						   case 6:
							   System.out.println("Program Ended...");
							   break;
						   default :
							   System.out.println("Please enter option");
								
						   }
				      }
				   catch(NumberFormatException e){System.out.println("Error Catched");break;}
				   catch(InputMismatchException e){System.out.println("Error Catched Characters not allowed");break;}
				   catch(FileNotFoundException s){System.out.println("Sorry File does not exist. create the file and try again");break;}
			   }while((choice<1) || (choice>6));  //Display the menu until the the option chosen other than 1 to 5
			   	
			}	   	   
	     
		
		   // Find character frequency shows only those letters which appeared in the sentence
		     public void charFrequency(List<String> values,int totalChar,int caseValue) throws IOException
		     {
		     	int flag=-1;
		     	int count=0;
					
		     	// this loop goes through all the Strings in the ArrayList
		     	for (int i = 0; i < values.size(); i++) 
		     	{
		     		String theString = values.get(i);
		     		//System.out.println("\nEntered String in charFrequency function : "+values.get(i));
		     		
		     		for (int j = 0; j < theString.length(); j++)
		     		{
		             	//int count=0;
		     			char charUnderInvestigation = theString.charAt(j);
		     			for (int k = 0; k < theString.length(); k++)
		     			{
		     				if (theString.charAt(k) == charUnderInvestigation)
		     				{
		     					count ++;
		     				}
		     			}
		     			
		     			// Check if the letter has appeared before then do not repeat the alphabet only increment the count
		     			flag = -1;
		     			int k = 0;
		     			while (k < j && flag < 0) {
		     			if(theString.charAt(k) == charUnderInvestigation){
		     				flag = 1;
		     			}
		     			k++;
		     			}
		     		
		     			// Print the letter's frequency
		     			if(flag==-1){
			     				if(caseValue == 1)
			     				{
			     					System.out.print("--- "+charUnderInvestigation +" = " );
			     					System.out.format("%.2f", ((float)count/totalChar));
			     				}
			     				else if(caseValue == 3)
			     				{
			     					System.out.print("  "+charUnderInvestigation +" = " +count+"    ");
				     				for(int star=1;star<=count;star++)
				     				{
				     					System.out.print("*");
				     				}
				     				System.out.println("");
			     				}
			     				else if(caseValue == 0)
			     				{	   
			     					System.out.print("   "+charUnderInvestigation +" = " );
			     					System.out.format("%.2f", ((float)count/totalChar));
			     				    System.out.println("");
			     				}
				     			else if(caseValue == 4)
			     				{
			     					System.out.print("  "+charUnderInvestigation +" = " +count+"    ");
				     				for(int star=1;star<=count;star++)
				     				{
				     					System.out.print("*");
				     				}
				     				System.out.println("");
			     				}
		     		}	
		     			count=0;
	     				flag=-1;	
		     			}
		     		
		     		}

		     }
		     
		     
	 //Method to read a file from keyboard and count character frequency
	     public void fileCharFrequency() throws IOException{
	    	 	int strSize=0;
	    	 	String stringSize = "";
	    		ArrayList<String> readFrmFile = new ArrayList();
	    		System.out.println("Enter a file name to analyse character frequency : ");
	    		String fPath = sc.next();
	    		
	    		System.out.println("-------"+ fPath);
	    
	    		// New BufferedReader.
	    		BufferedReader reader = new BufferedReader(new FileReader(fPath));

	    		// Add all lines from file to ArrayList.
	    		while (true) {
	    		    String line = reader.readLine();
	    		    if (line == null) {
	    		    	break;
	    		    }
	    		     System.out.println("File contains : " + line);
	    		     String s2 = line.replaceAll(" ", "");
	     		    stringSize += s2.replaceAll("[^a-zA-Z]", "");
	    		    stringSize=stringSize.toLowerCase();
	    		    
	    		}
	    		readFrmFile.add(stringSize);  
			    strSize = stringSize.length();    
	    		System.out.println("String length : " + stringSize.length());
	    		charFrequency(readFrmFile,strSize,0);
	    		System.out.println("Character Frequency");
	    		// Close it.
	    		reader.close();
	    		
	    		 char ans;
	    		do
	 		   {
	 			   System.out.println("Would you like to continue : 1. YES 2. NO");
	 			   try{
	 				  
	 				  ans=sc.next().charAt(0);		//Get user input from keyboard
					  
					   switch(ans)
					   {
					   case 'Y':
					   case 'y':
						   displaymenu();			
						   break;
					   case 'N':
					   case 'n':
						   
						   break;	
						
					   default:
						System.out.println("Sorry no such choice");
						break;
					   }
	 			   }
	 			  catch(NumberFormatException e){System.out.println("Error Catched");break;}
				   catch(InputMismatchException a){System.out.println("Error Catched Characters or decimals  not allowed");break;}
				   catch(FileNotFoundException s){System.out.println("Sorry File does not exist. create the file and try again");break;}
							   
	 		   }while((ans=='Y') || (ans=='y'));
			}


	
	//Display Graph based on the User Input  (only frequencies represented not as characters)

	public void getGraphForSpecialChar(int flag) throws IOException
	{
		   
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   System.out.print("Enter a String : ");
		   try
		   {
			   str=recurseReadUserInput(br,flag);
	   
			   if ( (!str.equals("")) && (str!=null))
		       {			    	  
			     String s1 = str.replaceAll("  ", "");
			     String ss = s1.replaceAll("^<>|.~#:;!@#$%£^`¬&*',_^()\"/]", "");
			     len = ss.length();
			     System.out.println("String length -- " + len);			    
				 al.add(ss);
				 charFrequency(al,len,flag);
				 al.clear(); 
		       }
					System.out.println("Would you like to continue : 1) YES 2)NO");
					char ans=sc.next().charAt(0);		//Get user input from keyboard
					  
					   switch(ans)
					   {
					   case 'Y':
					   case 'y':
						   displaymenu();			
						   break;
					   case 'N':
					   case 'n':
						   
						   break;	
						
					   default:
						System.out.println("Sorry no such choice");
						break;
					   }		  	
		   }    
		   
		   catch(InputMismatchException e)
		   {
			   System.out.println("Entered Value is not a String");
		   }
	}
	
	public void countWordFrequency(int flag) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Enter a String : ");

		 str=recurseReadUserInput(br,flag);
		 
        ArrayList<Integer> newnumber = new ArrayList<Integer>();
        // Puts it into an array, and splits
        String[] wordlist = str.split(" ");
        System.out.println(wordlist.length);
        System.out.println("Enterd input is : "+str);
        
        for(int wcnt = 0;wcnt<wordlist.length;wcnt++){        	
        	newnumber.add(wordlist[wcnt].length());         
        }
                 
        // Text out (Header)
        System.out.println("Word length:\tNo. of Words: ");

        // declare Arraylist for words
        ArrayList<String> wordEncounter = new ArrayList<String>();
        ArrayList<String> star = new ArrayList<String>();
        ArrayList<Integer> numberEncounter = new ArrayList<Integer>();
        
        
        // Checks number of encounter of words
        for (int i = 0; i < newnumber.size(); i++) 
        {
            int word = newnumber.get(i);

            // Make everything lowercase just for ease...

            if (wordEncounter.contains(Integer.toString(word))) {
                // Checks word encounter - return index of word
                int position = wordEncounter.indexOf(Integer.toString(word));
                Integer number = numberEncounter.get(position);
                int number_int = number.intValue();
                number_int++;
                number = new Integer(number_int);
                star.add("*");
                numberEncounter.set(position, number);

                // Number of encounters - add 1;
            } else {
            	
                wordEncounter.add(Integer.toString(word));
             
                numberEncounter.add(new Integer(1));                
            }

        }

        // Text out (the list of words)
        for (int i = 0; i < wordEncounter.size(); i++) {
            System.out.println( wordEncounter.get(i) + "\t\t"
                    + numberEncounter.get(i));
        }
        
       for(int d=0;d<wordEncounter.size();d++) {
       	System.out.print(wordEncounter.get(d)+ "\t");
    	for(int star1=1;star1<=numberEncounter.get(d);star1++){
				System.out.print("*");
			}
    	System.out.println("");
       }
		System.out.println("Would you like to continue : 1) YES 2)NO");
		char ans =sc.next().charAt(0);		//Get user input from keyboard
			  
		switch(ans)
		{
		   case 'Y':
		   case 'y':
			   displaymenu();			
			   break;
		   case 'N':
		   case 'n':
			   break;
			   default:
				   System.out.println("Sorry no such choice");
				   break;
		}
    }

	
	
	
	
	//Testing Methods
	//Method for reading file and used for testing because testing needs fixed file path
	 public void fileCharFrequency(String fPath) throws IOException{
 	 	int strSize=0;
 	 	String stringSize = "";
 		ArrayList<String> readFrmFile = new ArrayList();
 		 
 		// New BufferedReader.
 		BufferedReader reader = new BufferedReader(new FileReader(fPath));

 		// Add all lines from file to ArrayList.
 		try
 		{
 		while (true) 
 		{
 		    String line = reader.readLine();
 		    if (line == null)
 		    {
 		    	break;
 		    }
 		     System.out.println("File contains : " + line);
 		     String s2 = line.replaceAll(" ", "");
  		    stringSize += s2.replaceAll("[^a-zA-Z]", "");
 		    stringSize=stringSize.toLowerCase();
 		    
 		}
 		readFrmFile.add(stringSize);  
		strSize = stringSize.length();    
 		charFrequency(readFrmFile,strSize,0);
 		// Close it.
 		reader.close();
 		
 		}
			  catch(NumberFormatException e){System.out.println("Error Catched");}
			   catch(InputMismatchException a){System.out.println("Error Catched Characters or decimals  not allowed");}
			   catch(FileNotFoundException s){System.out.println("Sorry File does not exist. create the file and try again");}
 	}
	 
	 //Method used for testing special character graph
	 public void getGraphForSpecialChar(String str1,int flag) throws IOException
		{
				   if ( (!str.equals("")) && (str!=null))
			       {			    	  
				     String s1 = str.replaceAll("  ", "");
				     String ss = s1.replaceAll("^<>|.~#:;!@#$%£^`¬&*',_^()\"/]", "");
				     len = ss.length();
				     System.out.println("String length -- " + len);			    
					 al.add(ss);
					 charFrequency(al,len,flag);
					 al.clear(); 
			       }
						
		}
	 //Word count with same length Testing method
	 public void countWordFrequency(String str,int flag) throws IOException
	 {
	     ArrayList<Integer> newnumber = new ArrayList<Integer>();
         // Puts it into an array, and splits
         String[] wordlist = str.split(" ");
         System.out.println(wordlist.length);
                 
         for(int wcnt = 0;wcnt<wordlist.length;wcnt++){        	
         	newnumber.add(wordlist[wcnt].length());         
         }
                  
         // Text out (Header)
         System.out.println("Word length:\tNo. of Words: ");

         // declare Arraylist for words
         ArrayList<String> wordEncounter = new ArrayList<String>();
         ArrayList<String> star = new ArrayList<String>();
         ArrayList<Integer> numberEncounter = new ArrayList<Integer>();
         
         
         // Checks number of encounter of words
         for (int i = 0; i < newnumber.size(); i++) 
         {
             int word = newnumber.get(i);

             // Make everything lowercase just for ease...

             if (wordEncounter.contains(Integer.toString(word))) {
                 // Checks word encounter - return index of word
                 int position = wordEncounter.indexOf(Integer.toString(word));
                 Integer number = numberEncounter.get(position);
                 int number_int = number.intValue();
                 number_int++;
                 number = new Integer(number_int);
                 star.add("*");
                 numberEncounter.set(position, number);

                 // Number of encounters - add 1;
             } else {
             	
                 wordEncounter.add(Integer.toString(word));
              
                 numberEncounter.add(new Integer(1));                
             }

         }

         // Text out (the list of words)
         for (int i = 0; i < wordEncounter.size(); i++) {
             System.out.println( wordEncounter.get(i) + "\t\t"
                     + numberEncounter.get(i));
         }
         
        for(int d=0;d<wordEncounter.size();d++) {
        	System.out.print(wordEncounter.get(d)+ "\t");
     	for(int star1=1;star1<=numberEncounter.get(d);star1++){
				System.out.print("*");
			}
     	System.out.println("");
        }
        System.out.println("--------------------------END OF TESTING-------------------------------");					   
	}
}

	 
	 
	 
	
	
		
	 
	/*
	
	
	
	//Word Frequency Count using the File contents
	public static  void fileWordFrequency() throws IOException{
	 	int strSize=0;
	 	String stringSize = "";
		ArrayList<String> readFrmFile = new ArrayList();
		System.out.println("Enter a file name to analyse character frequency : ");
		//String fPath = sc.next();
		
		//System.out.println("-------"+ fPath);

		// New BufferedReader.
		//BufferedReader reader = new BufferedReader(new FileReader(fPath));
		
		String fPath="input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(fPath));
		int totwords=0,totchars=0;
		// Add all lines from file to ArrayList.
		while (true) {
		    String line = reader.readLine();
		    if (line == null) {
		    	break;
		    }
		    
		    else
		    {
		    String words[]=line.split(" ");
			totwords+=words.length;
			System.out.println("File contains : " + line);
		     
		    }
		}
		System.out.println("Total Words in the file  : "+totwords); 
		
		int lengths[] = getLengths(fPath);
		
		for (int i = 0; i < lengths.length; i++)
			totchars += lengths[i];
			
			if (totchars > 0) 
			{
			int sorted[] = bubbleSort(lengths);
			}
			System.out.println("Frequency of Words "+calcWordFrequency(bubbleSort(lengths)));
	}
	
	
	///Method to calculate Word Frequency
	private static int calcWordFrequency(int[] inArr)
	{
		int count=0,index;
		for(int i=0;i<inArr.length;)
        {
            count=1;
            for(index=i+1;index<inArr.length;index++)
            {
                if(inArr[i]==inArr[index])
                {
                    count++;
                }
                else{

                    break;
                }


            }
            System.out.println(""+inArr[i] +" letter word (s)----> "+count);
            i+=count;

        }

		return count;
	}
	
	
	
	//Count number of words
	public static int wordsCount(String line) throws IOException
    {
    	int Wcount=0;
				
			String[] parts = line.split(" ");
			for (String w : parts) 
			{
			
				Wcount++;
			}
			return Wcount;
    }		
	
	private static int[] getLengths(String filename) {

		Vector<String> allWords = new Vector<String>();
		try {
			FileReader infile = new FileReader(filename);
			BufferedReader inbuf = new BufferedReader(infile);
			String str;

			while ((str = inbuf.readLine()) != null) {
				String words[] = str.split(" ");
				for (int j = 0; j < words.length; j++)
					allWords.add(words[j]);
			}
			infile.close();
		} catch (Exception ee) {
			System.out
					.println("This is an error - file read execution caught.");
		}

		int lengths[] = new int[allWords.size()];
		for (int i = 0; i < lengths.length; i++) {
			String str = (String) allWords.get(i);
			lengths[i] = str.length();
			System.out.println(str+" - "+lengths[i]); //This prints the words with their length
		}
		
		return lengths;

	}

	private static int[] bubbleSort(int inArr[]) {

		/* This is a bit tedious, but we might want the un-sorted version later
		int outArr[] = new int[inArr.length];
		for (int i = 0; i < inArr.length; i++)
			outArr[i] = inArr[i];

		 And now do the sort 
		boolean swapped;
		int max = outArr.length;
		do {
			swapped = false;
			for (int i = 1; i < max; i++) {
				 if this pair is out of order 
				if (outArr[i - 1] > outArr[i]) {
					 swap them and remember something changed 
					swap(outArr, i - 1, i);
					swapped = true;
				}
			}
			max--;
		} while (swapped);
		return outArr;

	}

	private static void swap(int[] input, int a, int b) 
	{
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}


	

//Method for reading file and used for testing because testing needs  fixed file path
	public static void fileCharFrequency(String fPath) throws IOException{
	 	int strSize=0;
	 	String stringSize = "";
		ArrayList<String> readFrmFile = new ArrayList();
				// New BufferedReader.
		BufferedReader reader = new BufferedReader(new FileReader(fPath));

		// Add all lines from file to ArrayList.
		try
		{
		while (true) {
		    String line = reader.readLine();
		    if (line == null) {
		    	break;
		    }
		     System.out.println("File contains : " + line);
		     String s2 = line.replaceAll(" ", "");
 		    stringSize += s2.replaceAll("[^a-zA-Z]", "");
		    stringSize=stringSize.toLowerCase();
		    
		}
		readFrmFile.add(stringSize);  
	    strSize = stringSize.length();    
		charFrequency(readFrmFile,strSize,0);
		System.out.println("Character Frequency");
		// Close it.
		reader.close();
		
		}
		   catch(NumberFormatException e){System.out.println("Error Catched");}
		   catch(InputMismatchException a){System.out.println("Error Catched Characters or decimals  not allowed");}
		   catch(FileNotFoundException s){System.out.println("Sorry File does not exist. create the file and try again");}
					   
		  
	}
	
	public static void getGraphForSpecialChar(String str1,int flag) throws IOException
	{
		   
		   	   if ( (!str1.equals("")) && (str1!=null))
		       {			    	  
			     String s1 = str1.replaceAll("  ", "");
			     String ss = s1.replaceAll("[^<>|.~#:;!@#$%£`¬^&*',_^()\"/]", "");
			     len = ss.length();
			     System.out.println("String length -- " + len);			    
				 al.add(ss);
				 charFrequency(al,len,flag);
				 al.clear(); 
		       }
					
	}

	
} // End of Class*/
//Fixed input Testing File
	import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


	public class dsouza_Janet_13_FrequencyTesting {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			dsouza_Janet_13_FrequencyClass obj=new dsouza_Janet_13_FrequencyClass();
			List<String> inputArr=new ArrayList<String>();
			inputArr.add("I am a man");
			String classArr[]={"dsouza_Janet_13_FrequencyClass"};
			String resultArr[]={"a=0.43","i-0.14","m-0.29","n-0.14"};
			int value=0;
			//String fPath="/home/users/14059185/Documents/input.txt";
			String fPath="input.txt";

		System.out.println("Expected Output");
		System.out.println("Test No.  Data Input                               Class(es)                               Expected Output  ");
		try
		{
				for(int i=0;i<inputArr.size();i++)
				{
					System.out.println();
					System.out.print("   " + (i+1) + "      ");
					System.out.print(inputArr.get(i) + "                       ");
					System.out.print(classArr[i] + "          ");
					
					for(int j=0; j<resultArr.length;j++) {
					System.out.print(resultArr[j] + "      ");
					}
				}
				
				System.out.println();
				System.out.println("Actual / Obtained Output");
				inputArr.set(0,"Iamaman");
				
				//Collections.replaceAll(inputArr,"[^a-zA-Z]", "");
				
				//Converts the Array List elements to lower case
				for(int i=0,l=inputArr.size();i<l;++i)
				{
				  inputArr.add(inputArr.remove(0).toLowerCase());
				}
				
				//To get the length of strings of individual elements of array list
				String variable = inputArr.get(0);
				
				
				//charFrequency is a static method so no need to create the object of the class to access the charFrequency method.	
				obj.charFrequency(inputArr,variable.length(),0);
				System.out.println();
				//Test Case 2
				
						inputArr.add("input.txt");
						for(int i=1;i<inputArr.size();i++)
						{
							System.out.println();
							System.out.print("   " + (i+1) + "      ");
							System.out.print(inputArr.get(i) + "                       ");
							System.out.print(classArr[0] + "          ");
							
							for(int j=0; j<resultArr.length;j++)
							{
							System.out.print(resultArr[j] + "      ");
							}
						}
						
						System.out.println();
						System.out.println("Actual / Obtained Output");
						
				//filecharFrequency method is called and the input.txt file is passed to the method
				obj.fileCharFrequency(fPath);
				
				//Test Case 3
				inputArr.clear();
				inputArr.add("iamaman");
				String resultArr1[]={"i=1   *","a=3   ***","m=2   **","n=1  *"};
				for(int i=0;i<inputArr.size();i++)
				{
					System.out.println();
					System.out.print("   " + (i+3) + "      ");
					System.out.print(inputArr.get(0) + "                       ");
					System.out.print(classArr[0] + "          ");
					
					for(int j=0; j<resultArr1.length;j++) {
					System.out.print(resultArr1[j] + "      ");
					}
				}
				
				System.out.println();
				System.out.println("Actual / Obtained Output");
				//charFrequency method called to print graph if the chosen option is 3
				obj.charFrequency(inputArr,variable.length(),3);
				
				//Test Case 4
				inputArr.clear();
				inputArr.add("^^^^^&&&£££££££Iam a man");
				String val="^^^^^&&&£££££££iamaman";
				String resultArr2[]={"^=5   *****","$=3   ***","£=7   *******"};
				for(int i=0;i<inputArr.size();i++)
				{
					System.out.println();
					System.out.print("   " + (i+4) + "      ");
					System.out.print(inputArr.get(0) + "                       ");
					System.out.print(classArr[0] + "          ");
					
					for(int j=0; j<resultArr2.length;j++) {
					System.out.print(resultArr2[j] + "      ");
					}
				}
				
				System.out.println();
				System.out.println("Actual / Obtained Output");
				//getGraphForSpecialChar method is called to display the graph
				obj.getGraphForSpecialChar("^^^^^&&&£££££££iamaman",4);

				//Test Case 5
				inputArr.clear();
				inputArr.add("i am a man");
				String resultArr3[]={"1 letter words 2","2 letter words 1","3 letter words 1","**     *     *" };
				for(int i=0;i<inputArr.size();i++)
				{
					System.out.println();
					System.out.print("   " + (i+5) + "      ");
					System.out.print(inputArr.get(0) + "                       ");
					System.out.print(classArr[0] + "          ");
					
					for(int j=0; j<resultArr3.length;j++) {
					System.out.print(resultArr3[j] + "      ");
					}
				}
				
				System.out.println();
				System.out.println("Actual / Obtained Output");
				obj.countWordFrequency("i am a man",5);
		}
		catch(Exception e)
		{	}
	
		}
	}
	
/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this program is to ask a user to enter a string and will sort it alphabetically
 * */
import java.util.Scanner;

public class Sortingprogram {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String sortWords="";
		//declare the necessary variables
		int highestNum,comparisons;
		char temphold;
	
		//print the unsorted array
		
		System.out.println("Please enter a word:");
		sortWords=input.next();
		
		char word[]=sortWords.toCharArray();
		highestNum=word.length -1;
		comparisons=highestNum;
		for(int i=0; i < word.length;i++)
		{
		    System.out.print(word[i] );
		}
		for(int i=0; i < highestNum; i++)
		{
		    for (int j=0; j < comparisons;j++)
		    {
		    	if(word[j]>(word[j+1]))
		    	{
		    		temphold=word[j];
		    		word[j]=word[j+1];
		    		word[j+1]=temphold;
		    	}
		    }//end on inner for loop
		    //Now that we have sorted one set we 
		    //dont need to go through the entire array
		    comparisons--;
		    
		}// end of outer for loop
		//print the sorted array
		System.out.println("\n\nThe word in Alphabetical order is:\n");
		for(int i=0; i < word.length;i++)
		{
		    System.out.print(word[i] );  
		}


	}

}
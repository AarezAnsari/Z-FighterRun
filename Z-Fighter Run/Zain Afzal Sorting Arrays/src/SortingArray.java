import java.util.Scanner;

public class SortingArray {

	public static void main(String[] args) {
		//Create Scanner
		Scanner input = new Scanner(System.in);
		
		//Create 3D Array for student height
		int[][] studentHeight = new int[5][5];
		boolean validInput=false;
		
		double averageHeight=0.0;
		
		//Nested For loop to get the input for the student heights
		for(int row=0;row<5;row++) {
			for(int column=0;column<5;column++) {
				
				//Do While loop to keep running this section until the user enters a valid number
				 do {
					 while(validInput==false) {
							//Try and catch statements to make sure the user enters a integer
							try {
								System.out.println("Please Enter the Students Height: ");
								studentHeight[row][column]=input.nextInt();
								break;
								
							}
							catch(Exception e) {
								System.out.println("\nEnter a number Please!\n");
								input.next();
							}
						}
					 	//Check if the user entered a number greater then 0
				    	if(studentHeight[row][column]<0)
				    		System.out.println("Invalid Number, Enter again: \n");
				    }while(studentHeight[row][column]<0);
				 
				 averageHeight=averageHeight+studentHeight[row][column];
				
			}
		}
		
		//Nested For loops to sort the Two Dimensional Array
		for(int row1=0;row1<5;row1++) {
			for(int column1=0;column1<5;column1++) {
				for(int row=0;row<5;row++) {
					for(int column=0;column<5;column++) {
						if(studentHeight[row1][column1]>studentHeight[row][column]) {
							int tempVariable = studentHeight[row1][column1];
							studentHeight[row1][column1]=studentHeight[row][column];
							studentHeight[row][column]=tempVariable;
							
		}}}}}
		
		averageHeight=averageHeight/25;
		//Convert Double to String
		String averageH = Double.toString(averageHeight);
		
		//Nested For loops to display the sorted array
		System.out.println("Here are all the students heights sorted: ");
		for(int row=0;row<5;row++) {
			//Print Class number
			System.out.println("\n\n\nClass "+(row+1)+"\n");
			for(int column=0;column<5;column++) {
				//Print the Student heights
				System.out.println("Student "+(column+1)+": "+studentHeight[row][column]+"cm");
			}
		}	
			
		//Display Average Height
		System.out.println("\n\n\nAverage Height: "+averageH+"cm");
		
	}

}

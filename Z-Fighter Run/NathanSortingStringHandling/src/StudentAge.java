import java.util.Scanner;

public class StudentAge {

	public static void main(String[] args) {
		//Create Scanner
		Scanner input = new Scanner(System.in);
		
		//create array for student age
		int[][] studentAge = new int[4][4];
		boolean valid=false;
		double averageAge=0;
		
		//Loop to get the input for the student
		for(int row=0;row<4;row++) {
			for(int column=0;column<4;column++) {
				
				//Do While loop to keep running this section until the user enters a valid number
				 do {
					 while(valid==false) {
								System.out.println("please enter the students age: ");
								studentAge[row][column]=input.nextInt();
						}
					 	//Check if the number is greater then 0
				    	if(studentAge[row][column]<0)
				    		System.out.println("invalid, retry: \n");
				    }while(studentAge[row][column]<0);
				 
				 averageAge=averageAge+studentAge[row][column];
				
			}
		}
		
		//sorting
		for(int row1=0;row1<5;row1++) {
			
			for(int column1=0;column1<5;column1++) {
				
				for(int row=0;row<5;row++) {
					
					for(int column=0;column<5;column++) {
						
						if(studentAge[row1][column1]>studentAge[row][column]) {
							
							int tempVariable = studentAge[row1][column1];
							
							studentAge[row1][column1]=studentAge[row][column];
							
							studentAge[row][column]=tempVariable;
							
		
						}
					}
				}
			}
		}
		
		averageAge=averageAge/16;
		
		//Convert double to string
		String average = Double.toString(averageAge);
		
		//printing the sorted array
		System.out.println("Here are all the students heights sorted: ");
		for(int row=0;row<5;row++) {
			//group
			System.out.println("group "+(row+1)+"\n");
			for(int column=0;column<5;column++) {
				//printing ages
				System.out.println("Student "+(column+1)+": "+studentAge[row][column]);
			}
		}	
			
		//display average 
		System.out.println("average age: "+average);
		
	}

}
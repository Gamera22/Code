/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {
	
	
	
	
	
	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	
	
	}
			public static double divide(double num1,double num2) {
					return num1/num2; 
				}	
	
			
			public static int divide(int num1,int num2) {
				return num1/num2;
			}
	
	
			public static boolean isDivisibleBy7(int num) {
				return num%7 == 0;
			}
	
	
			public static String main(String phrase) {
				return "Overloaded main method was passed \""+phrase+"\".";
			}	
			
				
			
			
			public static int findMin(int num1, int num2, int num3) {
				if(num1 < num2 && num1 < num3) {
					return num1;
				
				}else if(num2 < num1 && num2 < num3) {
					return num2;
				
				}else {
					return num3;
				}
			}
			
			public static int findMin(int[] arr) {
				int min = arr[0];
				
				for (int i = 1; i < arr.length; i++) {
					
					if(min>arr[i]) {
						min = arr[i];
					}
				}
				
				return min;
			}
			
			
			public static double average(int[] array) {
				double sum = 0;
				
				for (int index:array){
					sum += index;
				}
				return divide(sum, array.length); 
			}
			
			
			
			
			public static void toLowerCase(String[] str) {
				for (int i = 0; i < str.length; i++) {
					str[i] = str[i].toLowerCase(); 
				
				}
	
			}
			 
			
			public static String[] toLowerCaseCopy(String[]str) {
			
				String[] result = new String[str.length];
			
				for (int i = 0; i < str.length; i++) {
					result[i] = str[i].toLowerCase();
				}
				return result;
			}
			
			public static void removeDuplicates(int[] array) {
			
				for (int i = 0; i < array.length; i++) {
					boolean check = false;
				
					for (int j = i+1; j < array.length; j++) {
					
						if(array[j] == array[i]) {
							array[j] = 0;
							check = true;
						}
					}
					if(check) {
						array[i] = 0;
					}
				}
			}
			
			
			
			
			
			
	
	
	
	}
	

	
	


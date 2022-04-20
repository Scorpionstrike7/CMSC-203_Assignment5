
/**
 * Class: CMSC203 
 *  Program: Assignment #5
 *  Instructor: Professor Grinberg
 * Description: This program manipulates a two-dimensional ragged array of doubles. This utility class creates a Sales Report for Retail 
 * District #5. It will accommodate positive and negative numbers. The program also calculates the holiday bonuses given by a ragged array 
 * of doubles which represent the sales for each store in each category. It will also take in bonus amount for the store with the highest 
 * sales in a category, the lowest sales in a category and all the other stores.
 * Due: MM/DD/YYYY (<04/20/2022>)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bradley Hughes
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility() {}
	
	
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException{

		double data[][] = null;
		int maxRow = 10;
		int maxCol = 10;
		int rowCount = 0;
		int currentRow = 0;
		double[][] tempArray = new double[maxRow][maxCol];
		
		Scanner inputArray1 = new Scanner(file);
		
		while (inputArray1.hasNext()) {
				rowCount++;
				inputArray1.nextLine();
		}
		
		inputArray1.close();
		
		data = new double[rowCount][];
		
		Scanner inputArray2 = new Scanner(file);
		
		while (inputArray2.hasNext()) {
			String a = inputArray2.nextLine();
			String column [] = a.split(" ");
			data[currentRow] = new double[column.length];
		
			for (int c = 0; c < column.length; c++) {
				data[currentRow][c] = Double.parseDouble(column[c]);
			}
			currentRow++;
		}
		inputArray2.close();
		
		if(inputArray2 == null) {
			return null;
		}
		return data;
	}

	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		
		PrintWriter outputData = new PrintWriter(outputFile);
		
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				//System.out.println(array[r][c]+ " ");
				outputData.println(data[r][c]+ " ");
			}
			outputData.println("\n");
		}
		outputData.close();
	}
	
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				total += data [r][c];
			}
		}
		//Return 
		return total;
	}
	public static double getAverage(double[][] data) {
		
		double total = 0;
		double num = 0;
		double average = 0;
		
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				total += data [r][c];
				num++;
			}
		}
		average = total/num;
		//Return 
		return average;	
	}
	public static double getRowTotal(double[][] data, int row) {
		
		double totalR = 0;
		
		//Sets up a for loop that goes through all the columns inside the rows
		for (int c=0; c < data[row].length; c++) {
			totalR += data[row][c];
		}
		//Return 
		return totalR;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		
		double totalC = 0;
		
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
		//Sets up a for loop that goes through all the columns inside the rows
			if (data[r].length <= col && data[r] != null) {
				continue;
			}//Gets total of all array elements
			totalC += data[r][col];
		}
		//Return 
		return totalC;
	}
	public static double getHighestInRow(double[][] data, int row) {
		
		double highestR = 0;
		
		//Sets up a for loop that goes through all the columns
		for (int c=0; c < data[row].length; c++) {
			//if highestR is less than data[row][c], set highestR to data[row][c]
			if(highestR < data[row][c]) {
				highestR = data[row][c];
			}
		}
		return highestR;
		
	}
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestR = 0;
		int hrIndex = 0;
			
		//Loop sets up a for loop that goes through all the rows
		for (int c=0; c < data[row].length; c++) {
			//if highestR is less than data[row][c], set highestR to data[row][c] and set hrIndex to row
			if(highestR < data[row][c]) {
				highestR = data[row][c];
				hrIndex = c;
			}
		}
		return hrIndex;
	}
	public static double getLowestInRow(double[][] data, int row) {
		
		double lowestR = 1000000;
		
		//Loop//Sets up a for loop that goes through all the rows
		for (int c=0; c < data[row].length; c++) {
			//Sets up a for loop that goes through all the columns inside the rows
			if(lowestR > data[row][c]) {
				lowestR = data[row][c];
			}
		}
		return lowestR;
		
	}
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestR = 1000000;
		int lrIndex = 0;
		
		//Loop//Sets up a for loop that goes through all the rows
		for (int c=0; c < data[row].length; c++) {
			//Sets up a for loop that goes through all the columns inside the rows
			if(lowestR > data[row][c]) {
				lowestR = data[row][c];
				lrIndex = c;
			}
		}
		return lrIndex;
		
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		
		double highestC = 0;
		
		//Loop//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			if(data[r].length <= col) {
				continue;
			}
			if(highestC < data[r][col]) {
				highestC = data[r][col];
			}
		}
		return highestC;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		double highestC = 0;
		int hcIndex = 0;
			
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows	
			if(data[r].length <= col) {
				continue;
			}
			if(highestC < data[r][col]) {
				highestC = data[r][col];
				hcIndex = r;
			}
		}
		return hcIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowestC = 1000000;
		
		//Loop//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			if(data[r].length <= col) {
				continue;
			}
			if(lowestC > data[r][col]) {
				lowestC = data[r][col];
			}
		}
		return lowestC;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double lowestC = 1000000;
		int lcIndex = 0;
			
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			if(data[r].length <= col) {
				continue;
			}
			if(lowestC > data[r][col]) {
				lowestC = data[r][col];
				lcIndex = r;
			}
		}
		return lcIndex;
	}
	
	public static double getHighestInArray(double[][] data) {
		
		double highestA = 0;
		
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				if (highestA < data[r][c]) {
					highestA = data [r][c];
				}
			}
		}
		//Return 
		return highestA;
	}
	
	public static double getLowestInArray(double[][] data) {
		
		double lowestA = 1000000;
		
		//Sets up a for loop that goes through all the rows
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				if (lowestA > data[r][c]) {
					lowestA = data [r][c];
				}
			}
		}
		//Return 
		return lowestA;
	}
}
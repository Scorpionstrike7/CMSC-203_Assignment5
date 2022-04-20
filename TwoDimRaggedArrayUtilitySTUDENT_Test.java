

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetArraySTUDENT = {{2.4,-3.5,9.1},{5.7},{8.1,2.2},{12.3,9.0,-3.1,4.7}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetArraySTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(46.9,TwoDimRaggedArrayUtility.getTotal(dataSetArraySTUDENT),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.6899999999999995,TwoDimRaggedArrayUtility.getAverage(dataSetArraySTUDENT),.001);	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(22.9,TwoDimRaggedArrayUtility.getRowTotal(dataSetArraySTUDENT,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(7.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSetArraySTUDENT,1),.001);	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(12.3,TwoDimRaggedArrayUtility.getHighestInArray(dataSetArraySTUDENT),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetArraySTUDENT, outputFile);
		} catch (Exception e) {
			fail("Student testWriteToFile not implemented");	
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(8, array[0][0],.001);
		assertEquals(7, array[0][1],.001);
		assertEquals(6, array[0][2],.001);
		assertEquals(5, array[1][0],.001);
		assertEquals(4, array[1][1],.001);
		assertEquals(3, array[2][0],.001);
		assertEquals(2, array[2][1],.001);
		assertEquals(1, array[2][2],.001);	
		
	}

}

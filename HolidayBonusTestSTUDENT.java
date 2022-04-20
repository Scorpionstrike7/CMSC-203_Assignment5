import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {

	private double[][] dataSetBonusSTUDENT = {{2,1,3},{5,6},{9,7,4}};
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSetBonusSTUDENT,5000,1000,2000);
			assertEquals(3000.0,result[0],.001);
			assertEquals(4000.0,result[1],.001);
			assertEquals(15000.0,result[2],.001);
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	} 

	@Test
	void testCalculateHolidayBonusB() {
		try{
		double[] result = HolidayBonus.calculateHolidayBonus(dataSetBonusSTUDENT,1000,250,500);
		assertEquals(750.0,result[0],.001);
		assertEquals(1000.0,result[1],.001);
		assertEquals(3000.0,result[2],.001);
		
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		} 
		
	}
	
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetBonusSTUDENT, 5000, 1000, 2000),.001);
	}
	
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(4750.0,HolidayBonus.calculateTotalHolidayBonus(dataSetBonusSTUDENT, 1000,250,500),.001);
	}
}
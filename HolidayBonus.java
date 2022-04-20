
public class HolidayBonus {
	
	public HolidayBonus() {}

	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		// Variables
		double [][] array = new double[data.length][];
		double result[] = new double[array.length];
		
		for (int r=0; r < data.length; r++) {
			//Sets up a for loop that goes through all the columns inside the rows
			for (int c=0; c < data[r].length; c++) {
				//Calls getLowestInColumnIndex
				int lowestI = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, c);
				//Calls getHighestInColumnIndex
				int highestI = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, c);

				//If lowest index of array is not null
				if(array[lowestI] != null) {
					//If lowest index is less than or equal to 0, set data element to 0
					if(data[r][c] <= 0) {
						array[lowestI][c] = 0;
					}
					else { //If lowest index is greater than 0, set data element to low
						array[lowestI][c] = low;
					}
				}
				//if highest index of array is not null
				if(array[highestI] != null) {
					//If lowest index is less than or equal to 0, set array element to 0
					if(data[r][c] <= 0) {
						array[highestI][c] = 0;
					}
					else { //If lowest index is greater than 0, set array element to low
						array[highestI][c] = high;
					}
				}//if array is not null
				if(array[r] != null) {
					//If row does not equal highestI and does not equal lowestI, set array element to other
					if(r != highestI && r != lowestI) {
						array[r][c] = other;
					}
					if (data[r][c] <= 0) {
						array[r][c]=0;
					}
				}//add high to result
				if(highestI == r) {
				result[r] += high;
				continue;
				}//add low to result
				if(lowestI == r) {
					result[r] += low;
					continue;
				} //add other to result
				if(r != highestI && r != lowestI) {
					result[r] += other;
					continue;
				}
			}
		}
		return result;
	}
		
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double totalHB = 0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(data, high, low, other);
		
		for(int i = 0; i < bonus.length; i++) {
			System.out.print(bonus.length);
			totalHB += bonus[i];
			}
		return totalHB;	
	}
}
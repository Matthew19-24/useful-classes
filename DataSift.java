package MyMathLab;
import javax.swing.JOptionPane;

public class DataSift {
	
	/**
	 * The size of the dataSet.
	 */
	private int size = 0;
	
	/**
	 * An array of the data set.
	 */
	private double[] dataSet;
	
	/**
	 * An array of the data set organized into frequencies.
	 */
	private double[][] dataFrequencies;
	
	/**
	 * Length of dataFrequencies.
	 */
	private int frequencyLength;
	
	public String getMode()
	{
		// Set variable
		int highest = 0;
		StringBuilder sb = new StringBuilder();
		
		// Get highest frequency
		for (int x = 0; x < this.frequencyLength; x++)
		{
			if (this.dataFrequencies[1][x] > highest)
			{
				highest = (int) this.dataFrequencies[1][x];
			}
		}
		
		// Append mode or modes
		for (int x = 0; x < this.frequencyLength; x++)
		{
			if (this.dataFrequencies[1][x] == highest)
			{
				sb.append(this.dataFrequencies[1][x]).append(", ");
			}
		}
		
		return sb.toString();
		
	} // End getMode
	
	/**
	 * The getDataFrequencies creates a 2 dimensional array of the data and their corresponding frequencies. 
	 */
	public void getDataFrequencies()
	{
		// Set variables
		int countSize = 1; // To count the array size, always starts at 1
		
		// Get new array size
		for (int x = 0; x < this.dataSet.length - 1; x++)
		{
			if (this.dataSet[x] != this.dataSet[x+1])
			{
				countSize++;
			}
		}
		
		// CountSize to frequencyLength
		this.frequencyLength = countSize;
		
		// Create new array for data set & frequencies
		this.dataFrequencies = new double[2][countSize];
		
		// New counter
		int count = 1; 
		
		// Add first data item to index
		this.dataFrequencies[0][0] = dataSet[0];
		
		// Add data to new array
		for (int x = 1; x < this.dataSet.length - 1; x++)
		{
			if (this.dataSet[x] != this.dataSet[x + 1])
			{
				this.dataFrequencies[0][count] = this.dataSet[x + 1];
				count++;
			}
		}
		
		
		// Add frequencies to new array
		for (int x = 0; x < countSize; x++)
		{
			
			for (int i = 0; i < this.dataSet.length; i++)
			{
				if (this.dataFrequencies[0][x] == this.dataSet[i])
				{
					this.dataFrequencies[1][x] += 1;
				}
			}
		}
		
	} // End getDataFrequencies
	
	/**
	 * The getRange method calculates the midrange of the data set.
	 * @return The midrange.
	 */
	public double getRange()
	{
		return (dataSet[0] + dataSet[dataSet.length - 1]) / 2;
	}
	
	/**
	 * The getMedian method calculates the median of the data set.
	 * @return The median of the data set.
	 */
	public double getMedian()
	{
		// Middle number
		int mid = this.dataSet.length / 2;
		
		if (this.isEven())
		{
			return (dataSet[mid] + dataSet[mid + 1]) / 2;
		}
		else
		{
			return dataSet[mid];
		}
	} // End getMedian
	 
	/**
	 * The isEven method determines if the length of the dataSet is odd or even.
	 * @return true if even, false if odd.
	 */
	public boolean isEven()
	{
		if (dataSet.length % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	} // End isEven.
	
	/**
	 * The getMean method calculates the data and gets the mean
	 * @return The mean of the data set.
	 */
	public double getMean()
	{
		// Set variables
		double mean = 0;
		double total = 0; // Running total of dataSet
		
		// Iterate through dataSet adding each index to total
		for (int i = 0; i < this.dataSet.length; i++)
		{
			total += this.dataSet[i];
		}
		
		// Calculate mean
		mean = total / this.dataSet.length;
		
		return mean;
	} // End getMean.
	
	/**
	 * The sortData method will sort the data in ascending order.
	 */
	public void sortData()
	{
		// Declare variables
		double big = 0; // Used to hold the larger variable
		double small = 0; // Used to hold the smaller variable
		
		// Iterate through array
		for (int i = 1; i < this.dataSet.length; i++)
		{
			// Swap indexes if necessary
			if (this.dataSet[i] < this.dataSet[i-1])
			{
				// Hold variable places
				small = this.dataSet[i];
				big = this.dataSet [i-1];
				
				// Set new variables in array
				this.dataSet[i] = big;
				this.dataSet[i-1] = small;
				
				// Reset loop variable
				i = 0;
			}
			
		} // End loop
		
	} // End sortData
	
	
	/**
	 * The constructor gets the data set size, and loops through the data and it's frequencies
	 * until it fills the array with it's the whole data set.
	 */
	public DataSift()
	{
		// Set variables
		int frequency = 0; // Used to hold frequency before adding to array
		double data = 0; // Used to hold data before adding to array
		
		// Get data sets size
		this.size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the total frequency of the data set"));
		
		// Initialize array
		this.dataSet = new double[size];
		
		for (int empty = 0; empty < this.dataSet.length; empty++)
		{
			// Get data and add to array
			data = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter data"));
			
			// Get frequency
			frequency = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter frequency for " + data));
			
			// Add data
			this.dataSet[empty] = data;
			
			// Add data for the amount of frequency
			for (int i = 1; i < frequency; i++)
			{
				// Go to next index
				empty++;
				
				// Add data
				this.dataSet[empty] = data;
				
			} // End loop
			
		} // End loop
		
		// Sort and organize data
		this.sortData();
		
	} // End constructor
	
	/**
	 * The showData method prints the array to the console to test the data.
	 */
	public void showData()
	{
		for (int i = 0; i < this.dataSet.length; i++) {
			System.out.println(this.dataSet[i]);
		}
	} // End showData
	
	
} // End class
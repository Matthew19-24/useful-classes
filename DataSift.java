package Sandbox;
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
	
	public void sortData()
	{
		
	}
	
	
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
		size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the total frequency of the data set"));
		
		// Initialize array
		dataSet = new double[size];
		
		for (int empty = 0; empty < dataSet.length; empty++)
		{
			// Get data and add to array
			data = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter data"));
			
			// Get frequency
			frequency = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter frequency for " + data));
			
			// Add data
			dataSet[empty] = data;
			
			// Add data for the amount of frequency
			for (int i = 1; i < frequency; i++)
			{
				// Go to next index
				empty++;
				
				// Add data
				dataSet[empty] = data;
				
			} // End loop
			
		} // End loop
		
	} // End getData()
	
	/**
	 * The showData method prints the array to the console to test the data.
	 */
	public void showData()
	{
		for (int i = 0; i < dataSet.length; i++) {
			System.out.println(dataSet[i]);
		}
	}
	
	
} // End class



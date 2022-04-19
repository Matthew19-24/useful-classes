package Sandbox;

import javax.swing.JOptionPane;

public class DataSiftTest {

	public static void main(String[] args) {
		// Create new DataSift object
		DataSift data = new DataSift();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("MEAN: ").append(data.getMean());
		sb.append("\nMEDIAN: ").append(data.getMedian());
		sb.append("\nMidrange: ").append(data.getRange());
		sb.append("\nMode: ").append(data.getMode());

		JOptionPane.showMessageDialog(null, sb);

	}

}
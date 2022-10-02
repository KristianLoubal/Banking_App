package firstJavaProject;

import java.io.*;
import java.util.ArrayList;

public class FileWork {
	
	BufferedReader reader = null;
	PrintWriter out = null;
	String line = "";
	String[]temp = new String[2];
	
	ArrayList<String> csvType = new ArrayList<String>();
	ArrayList<Double> csvVal = new ArrayList<Double>();
	
	void readFile(String filename) {
		try {
			csvType.clear();
			csvVal.clear();
			reader = new BufferedReader(new FileReader(filename)); 
			while((line = reader.readLine()) != null) {
				temp=(line.split(","));
				this.csvType.add(temp[0]);
				this.csvVal.add(Double.parseDouble(temp[1])+(Double.parseDouble(temp[2])/100));	
			}
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void printHistory(String filename) {
		try {
			int i=0;
			reader = new BufferedReader(new FileReader(filename)); 
			while((line = reader.readLine()) != null) {
				System.out.println(this.csvType.get(i) + this.csvVal.get(i));
				i++;
			}
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void writeHistory (String filename, String transaction, double amount) {
		try {
			out = new PrintWriter(filename);
			int i =0;
			if(csvType.isEmpty()!=true) {
			do {	 
				out.printf("%s , %.2f\n", this.csvType.get(i), this.csvVal.get(i));
				i++;
				} while (i < csvType.size());
			}
			out.printf("%s , %.2f\n", transaction, amount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}

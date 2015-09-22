package br.com.dextra.mlp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public static final int LINE_ITEMS = 12;
	public static final int LINE_NUMBER = 419909;
	
	private File file;
	private double[][] data;
	private long[] expect;
	
	public FileReader(String path) {
		this.file = new File(path);
	}
	
	public void read() throws FileNotFoundException {
		this.data = new double[LINE_ITEMS][FileReader.LINE_NUMBER];
		expect = new long[FileReader.LINE_NUMBER];
		
		int k = 0;
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line[] = scan.nextLine().split(",");
			int lastItemIndex = line.length - 1;
			
			for (int i = 0; i < lastItemIndex; i++) {
				data[i][k] = new Double(line[i]);
			}
			
			expect[k] = new Long(line[lastItemIndex]);
			k++;
		}
		scan.close();
	}

	public double[][] getData() {
		return data;
	}

	public long[] getExpect() {
		return expect;
	}

}
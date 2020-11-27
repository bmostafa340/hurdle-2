import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Variable {
	
	private String name;
	private int col;
	private ArrayList<String>[] values;
	
	/*
	 * Initializes an empty variable.
	 */
	public Variable(String name, int col) {
		this.name = name;
		this.col = col;
		values = new ArrayList[2];
		values[0] = new ArrayList<String>();
		values[1] = new ArrayList<String>();
	}
	
	/*
	 * Initializes a variable exclusively from hard-coded data.
	 */
	public Variable(String name, String[] years, String[] values) {
		this(name, -1, years, values);
	}
	
	/*
	 * Initializes a variable with hard-coded data and sets the col attribute
	 * for fillValues() to know where to fill values from in case it is run.
	 */
	public Variable(String name, int col, String[] years, String[] values) {
		this(name, col);
		for (String year : years) {
			this.values[0].add(year);
		}
		for (String value : values) {
			this.values[1].add(value);
		}
	}
	
	/*
	 * Fills the values array with data read from the specified column of the data table as well
	 * as the corresponding year.
	 */
	public void fillValues() {
		if (col != -1) {
			File data = new File("C:\\Users\\bmost\\eclipse-workspace\\Hurdle_2\\src\\Serengeti_Plain_Data.txt");
			try {
				Scanner sc = new Scanner(data);
				int current_year = 1960;
				int current_col = 0;
				while (sc.hasNext()) {
					String entry = sc.next();
					if (current_col == col && !entry.equals("NA")) {
						values[0].add(Integer.toString(current_year));
						values[1].add(entry);
					} 
					if (current_col == 13) {
						current_col = -1;
						current_year++;
					}
					current_col++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/*
	 * Prints the contents of values in a way that is convenient for copy pasting into
	 * a spreadsheet for future processing.
	 */
	public void displayValues() {
		System.out.println(name);
		for (int i = 1957; i < 2004; i++) {
			String year = Integer.toString(i);
			int index = values[0].indexOf(year);
			if (index != -1) {
				System.out.println(values[1].get(index));
			} else {
				System.out.println();
			}
		}
	}
	
	/*
	 * Prints all years for which data is provided in a way that is convenient for
	 * copy pasting into a spreadsheet for future processing.
	 */
	public void displayYears() {
		System.out.println("Year");
		for (int i = 1957; i < 2004; i++) {
			System.out.println(i);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public ArrayList<String>[] getValues() {
		return values;
	}

	public void setValues(ArrayList<String>[] values) {
		this.values = values;
	}
	
}

public class DataFormatter {
	
	public static void main(String[] args) {
		/*
		 * Hard coded data that was not found in the data table.
		 */
		String[] rp_yrs = {"1958", "1959", "1960", "1961", "1962", "1963", 
				"1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989"};
		String[] rp_vals = {"0.86", "0.86", "0.81", "0.65", "0.17", "0.00", 
				"0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00"};
		String[] wb_yrs = {"1957"};
		String[] wb_vals = {"191"};
		
		/*
		 * Initializes Variable objects with the appropriate data from the data
		 * table.
		 */
		Variable rinderpest = new Variable("Rinderpest", rp_yrs, rp_vals);
		Variable wildebeest = new Variable("Wildebeest", 7, wb_yrs, wb_vals);
		Variable fire = new Variable("Fire Frequency", 10);
		Variable trees = new Variable("Tree Density", 12);
		
		/*
		 * Prints out data in a format that is more readily copy-pasted into 
		 * a spreadsheet for further numerical analysis.
		 */
		display(trees);
	}
	
	/*
	 * Prints out the data corresponding to the input Variable.
	 */
	private static void display(Variable var) {
		var.fillValues();
		var.displayYears();
		var.displayValues();
	}
	
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulationPrinter {
	
	/*
	 * Finds and prints the fire frequency that best macthes the populations in the predicted 
	 * populations array, reading from a file containing the predicted fire frequency at certain
	 * population sizes. Used to combine the wildebeest population over time prediction with the
	 * fire frequency vs wildebeest population prediction to produce the fire frequency over time
	 * plot presented in the conclusion section.
	 */
	public static void main(String[] args) {
		double[] population = {191, 212.0185311, 235.3567579, 261.2840534, 290.0995968, 322.1356711, 357.7613262, 397.1518321, 440.879341, 489.4213688, 543.3080074, 603.1277132, 669.533733, 743.2512382, 825.0852435, 915.9293978, 1016.775743, 1128.725549, 1253.001336, 1390.960229, 1544.108775};
		File data = new File("C:\\Users\\bmost\\eclipse-workspace\\Hurdle_2\\src\\Population_and_Predicted_Fire.txt");
		try {
			Scanner sc = new Scanner(data);
			int i = 0;
			while (sc.hasNext()) {
				if (Math.abs(Double.parseDouble(sc.next()) - population[i]) < 0.500001) {
					System.out.println(sc.next());
					i++;
				} else {
					sc.next();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

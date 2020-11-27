
public class FireSimulator {
	
	private final int ROWS;
	private final int COLS;
	private final double FIRE_SPREAD_PROBABILITY;
	private final double FIRE_START_PROBABILITY;
	private final int FIRE_DURATION;
	private int[][] system;
	private int numGenerations;
	
	public FireSimulator(int rows, int cols, double fireSpreadProbability, 
			double fireStartProbability, int fireDuration, int numGenerations) {
		ROWS = rows;
		COLS = cols;
		FIRE_SPREAD_PROBABILITY = fireSpreadProbability;
		FIRE_START_PROBABILITY = fireStartProbability;
		FIRE_DURATION = fireDuration;
		system = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				system[row][col] = 0;
			}
		}
		this.numGenerations = numGenerations;
	}
	
	public int getNumBurntSquares() {
		int count = 0;
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (system[row][col] != 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	/*
	 * Computes the final result of the cellular automaton.
	 */
	public void simulate() {
		while (numGenerations > 0) {
			nextGeneration();
			numGenerations--;
		}
	}
	
	/*
	 * Permanently quenches fires that have run out of fuel, increments the
	 * amount of time burnt for cells that are still burning, burns new cells
	 * with a probability proportional to the number of neighboring burning
	 * cells, and randomly starts new fires with a probability proportional
	 * to the parameters passed to the FireSimulator.
	 */
	private void nextGeneration() {
		int[][] copy = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (system[row][col] > 0) {
					if (system[row][col] == FIRE_DURATION) {
						copy[row][col] = -1;
					} else {
						copy[row][col] = system[row][col] + 1;
					}
				} else if (system[row][col] == 0) {
					if (Math.random() < FIRE_SPREAD_PROBABILITY * 
							numSurroundingFires(row, col)) {
						copy[row][col] = 1;
					} else if (Math.random() < 
							FIRE_START_PROBABILITY / (ROWS * COLS)) {
						copy[row][col] = 1;
					}
				}
			}
		}
		system = copy;
	}
	
	/*
	 * Computes the number of neighboring cells that are on fire.
	 */
	private int numSurroundingFires(int row, int col) {
		int count = 0;
		count += isOnFire(row - 1, col - 1);
		count += isOnFire(row - 1, col);
		count += isOnFire(row - 1, col);
		count += isOnFire(row, col - 1);
		count += isOnFire(row, col + 1);
		count += isOnFire(row + 1, col - 1);
		count += isOnFire(row + 1, col);
		count += isOnFire(row + 1, col);
		return count;
	}
	
	/*
	 * Returns 1 if the input coordinates are in bounds
	 * and represent a burning cell.
	 */
	private int isOnFire(int row, int col) {
		if (row > 0 && row < ROWS && col > 0 && col < COLS) {
			if (system[row][col] > 0) {
				return 1;
			} 
		}
		return 0;
	}

}

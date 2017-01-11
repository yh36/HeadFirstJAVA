package body;

public class SimpleDotCom {

	// ********** Instance Variable Declaration **********//
	// Declare an int array to hold the location cells. Call it location Cells.
	int[] locationCells;

	// Declare an int to hold the number of hits. Call it numOfHits and SET it
	// to 0
	int numOfHits = 0;


	// ********** Method Declaration & Logic **********//
	// String checkYourself(String userGuess)
	// Declaration:
	// It takes a String for the user's guess, and returns a result representing
	// a "hit", "miss", or "kill"
	// Logic:
	// GET the user guess as a String parameter
	// CONVERT the user guess to an int
	// REPEAT with each of the location cells in the int array
	// COMPARE the user guess to the location cell
	// IF the user guess matches
	// INCREMENT the number of hits
	// IF number of hits is 3. RETURN "kill"
	// ELSE RETURN "hit"
	// ELSE the user guess did not match, RETURN "miss"
	public String checkYourself(String userGuess) {
		int guess = Integer.parseInt(userGuess);
		String result = "miss";
		
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		
		if (numOfHits == locationCells.length) {
			result = "kill";
		}
		
		System.out.println(result);
		
		return result;
	}


	// void setLocationCells(int[] cellLocations)
	// Declaration: It takes an int array
	// Logic:
	// GET the cell locations as an int array parameter
	// ASSIGN the cell locations paramter to the cell locations instance
	// variable
	public void setLocationCells(int[] locs) {
		locationCells = locs;
	}
}

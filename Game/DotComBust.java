import java.util.*;

public class DotComBust {
  /******Variable Declarations******/
  // helper: instantiate the GameHelper instance
  GameHelper helper = new GameHelper();
  // dotComList: holds the list of DotComs
  ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
  // numOfGuesses: an int variable to hold the number of user guesses
  int numOfGuesses = 0;

  /******Method Declarations*******/
  // setUpGame: create and initialize the DotCom objects with names and
  // locations.
  // CREATE three DotCom objects
  // SET a name for each DotCom
  // Add the DotCom to the dotComList
  // REPEAT with each of the DotCom objects in the dotComList array
  //    CALL the placeDotCom() on the helper object to get a randomly-selected
  //    location for this DotCom
  private void setUpGame() {
    DotCom one = new DotCom();
    one.setName("Pets.com");
    DotCom two = new DotCom();
    two.setName("eToys.com");
    DotCom three = new DotCom();
    three.setName("Go2.com");
    dotComList.add(one);
    dotComList.add(two);
    dotComList.add(three);

    System.out.println("Your goal is to sink three dot coms.");
    System.out.println("Pet.com, eToys.com, Go2.com");
    System.out.println("Try to sink them all in the fewest number of guesses");

    for (DotCom dotComToSet : dotComList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  // startPlaying(): ask the player for guesses and call checkUserGuess() method
  // until all the DotCom objects are removed from play
  // REPEAT while any DotCom exists
  //    GET user input by calling the helper getUserInput() method
  //    EVALUATE the user's guess by checkUserGuess() method
  private void startPlaying() {
    while (!dotComList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  // checkUserGuess(): loops through all remaining DotCom objects and calls each
  // each DotCom object's checkYourself()
  // INCREMENT the number of user guesses in the numOfGuesses variable
  // SET the local result variable to "miss"
  // REPEAT with each of the DotObjects in the dotComList
  //    EVALUATE the user's guess by calling the DotCom object's checkYourself()
  //    SET the result to "hit" or "kill" if appropriate
  //    IF the result if "kill", REMOVE the DotCom from the dotComList
  // DISPLAY the result
  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";

    for (DotCom dotComToTest : dotComList) {
      result = dotComToTest.checkYourself(userGuess);

      if (result.equals("hit")) {
        break;
      }

      if (result.equals("kill")) {
        dotComList.remove(dotComToTest);
        break;
      }
    }

    System.out.println(result);
  }

  // finishGame(): prints a message about the user's performance, based on how
  // many guesses it took to sink all of the DotCom objects
  // DISPLAY a generic "game over"
  private void finishGame() {
    System.out.println("All Dot Coms are dead! Your stock is now worthless.");
  }

  public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }
}

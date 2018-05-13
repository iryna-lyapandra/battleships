import java.util.*;

public class ShipManager {
    private GameHelper helper = new GameHelper();
    private List<Ship> shipsArrayList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Ship one = new Ship();
        one.setName("Bentinck");
        Ship two = new Ship();
        two.setName("Imperial");
        Ship three = new Ship();
        three.setName("Misoa");
        shipsArrayList.add(one);
        shipsArrayList.add(two);
        shipsArrayList.add(three);

        System.out.println("Your goal is to sink three ships");
        System.out.println("Bentinck, Imperial, Misoa");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Ship shipSet : shipsArrayList) {
            List <String> newLocation = helper.placeShips(3);
            shipSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!shipsArrayList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Ship shipToTest : shipsArrayList) {
            result = shipToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                shipsArrayList.remove(shipToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All ships are sunk!");
        System.out.println("It took you " + numOfGuesses + " guesses");
    }

    public static void main(String[] args) {
        ShipManager game = new ShipManager();
        game.setUpGame();
        game.startPlaying();
    }
}
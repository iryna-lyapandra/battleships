import java.io.*;
import java.util.*;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private final int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int shipCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }


    public List<String> placeShips(int shipSize) {
        List<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[shipSize];       //real coords
        String temp = null;
        int[] coords = new int[shipSize];                  // temp coords
        int attempts = 0;
        boolean success = false;                           // found a good location
        int location = 0;

        shipCount++;
        int incr = 1;                                      // set horizontal increment
        if ((shipCount % 2) == 1) {                         // if odd ship - set vertical increment
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);      // get random starting point
            //System.out.print(" try " + location);
            int x = 0;
            success = true;                                 // assume success
            while (success && x < shipSize) {                // look for unused spots
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {                 // out of bounds
                        success = false;                         //
                    }
                    if (x > 0 & (location % gridLength == 0)) {  // out of bounds - right edge
                        success = false;
                    }
                } else {                                      // found already used location
                    // System.out.print(" used " + location);
                    success = false;
                }
            }
        }
        // turn good location into real coords
        int x = 0;
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while (x < shipSize) {
            grid[coords[x]] = 1;                              // mark grids as 'used'
            row = (int) (coords[x] / gridLength);             // get row value
            column = coords[x] % gridLength;                  // get column value
            temp = String.valueOf(alphabet.charAt(column));   // convert to alpha

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

            // System.out.print("  coord "+x+" = " + alphaCells.get(x-1));

        }


        return alphaCells;
    }
}
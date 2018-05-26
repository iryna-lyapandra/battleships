package battleshipsJava.mvc;

import java.util.List;

public class Ship {
    private List<String> locationCells;

    public void setLocationCells(List<String> loc) {
        locationCells = loc;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }

    private String name;

    public void setName(String string) {
        name = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (locationCells != null ? !locationCells.equals(ship.locationCells) : ship.locationCells != null)
            return false;
        return name.equals(ship.name);
    }

    @Override
    public int hashCode() {
        return locationCells != null ? locationCells.hashCode() : 0;
    }
}
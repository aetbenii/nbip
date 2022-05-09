package datenbankenueben;

import java.util.ArrayList;

public class spieler {

    private String name;
    public spieler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "spieler{" +
                "name='" + name + '\'' +
                '}';
    }
}

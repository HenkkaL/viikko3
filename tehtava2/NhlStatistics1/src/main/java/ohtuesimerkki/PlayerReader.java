package ohtuesimerkki;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerReader implements Reader {

    public static final int PARTFOUR = 4;
    public static final int PARTTHREE = 3;
    private Scanner scanner;  

    public PlayerReader(String pageUrl) {
        try {
            URL url = new URL(pageUrl);
            scanner = new Scanner(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        
        while (scanner.hasNextLine()) {
            String[] parts =  scanner.nextLine().split(";");            
            
            if (parts.length > PARTTHREE) {
                players.add(new Player(parts[0].trim(), parts[1], extractInt(parts[PARTTHREE]), extractInt(parts[PARTFOUR])));
            }
        }

        return players;
    }

    private int extractInt(String str) {
        return Integer.parseInt(str.trim());
    }
}

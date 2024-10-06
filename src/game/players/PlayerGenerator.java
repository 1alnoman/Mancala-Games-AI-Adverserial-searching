package game.players;

import game.GamePlayer;

import java.util.Scanner;

public class PlayerGenerator {
    public static GamePlayer generatePlayer(String player) {
        GamePlayer gamePlayer = null;
        if(player.equalsIgnoreCase("Human")) {
            gamePlayer = new HumanGamePlayer();
        }
        else if(player.equalsIgnoreCase("AI")) {
            Scanner scn = new Scanner(System.in);
            AIGamePlayer aiGamePlayer = new AIGamePlayer();
            System.out.println("Enter the depth for the AI player");
            aiGamePlayer.setDepth(Integer.parseInt(scn.nextLine()));

            gamePlayer = aiGamePlayer;
        }

        return gamePlayer;
    }
}

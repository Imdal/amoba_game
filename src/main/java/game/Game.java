package game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static PlayerDao playerDao;
    /**
     * Stores the first player.
     */
    public static Player Player1;
    /**
     * Stores the second player.
     */
    public static Player Player2;
    /**
     * Stores the name of the first player.
     */
    public static String player1Name;
    /**
     * Stores the name of the second player.
     */
    public static String player2Name;
    /**
     * Stores the player number who won.
     */
    public static int Winner = 0;

    /**
     * Creates and stores the players.
     *
     * @param name1 the name of the first player
     * @param name2 the name of the second player
     */
    public static void setPlayers(String name1, String name2) {
        player1Name = name1;
        player2Name = name2;
//        Player1=playerDao.findPlayer(name1);
//        Player2=playerDao.findPlayer(name2);
        Player1 = new Player(name1);
        Player2 = new Player(name2);
//        playerDao.persist(Player1);
//        playerDao.persist(Player2);

    }

}
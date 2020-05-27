package game;

public class Game {
    public static PlayerDao playerDao;
    public static Player Player1;
    public static Player Player2;
    public static String player1Name;
    public static String player2Name;
    public static int Winner=0;

    public static void setPlayers(String name1, String name2) {
        player1Name=name1;
        player2Name=name2;
//        Player1=playerDao.findPlayer(name1);
//        Player2=playerDao.findPlayer(name2);
        Player1 = new Player(name1);
        Player2 = new Player(name2);
//        playerDao.persist(Player1.createPlayer());
//        playerDao.persist(Player2.createPlayer());

    }


}

public class Game {
    private Player player1;
    private Player player2;
    private Table table;

    Game(){

    }

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void Start(){
        table = new Table();
    }

}

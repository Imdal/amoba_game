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
        table.put(0,0,1);
        table.put(0,1,2);
        table.cout();
        System.out.println(table.check());
        table.put(1,0,1);
        table.put(1,1,2);
        table.cout();
        System.out.println(table.check());
        table.put(2,0,1);
        table.put(2,1,2);
        table.cout();
        System.out.println(table.check());
        table.put(3,0,1);
        table.put(3,1,2);
        table.cout();
        System.out.println(table.check());
        table.put(4,0,1);
//        table.put(0,1,2);
        table.cout();
        System.out.println(table.check());
        if(table.check()==1) {
            player1.WinGame();
            player2.LoseGame();
        }
        else if (table.check()==2) {
            player2.WinGame();
            player1.LoseGame();
        }
    }

}

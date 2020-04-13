public class Player {
    private String playerName;
    private int games = 0;
    private int wins = 0;
    private int winRow = 0;
    private int bestWinRow = 0;

    Player(String playerName){
        this.playerName = playerName;
    }
    void WinGame() {
        this.games += 1;
        this.wins += 1;
        this.winRow += 1;
        if(winRow>bestWinRow){
            bestWinRow += 1;
        }
    }

    void LoseGame(){
        this.games += 1;
        this.winRow = 0;
    }
}

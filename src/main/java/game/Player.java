package game;

public class Player {
    private String playerName;
    private int games;
    private int wins;
    private int winRow;
    private int bestWinRow;

    Player(String playerName){
        this.playerName = playerName;
        this.games = 0;
        this.wins = 0;
        this.winRow = 0;
        this.bestWinRow = 0;
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

    int getGames(){
        return this.games;
    }

    int getWins(){
        return  this.wins;
    }

    int getBestWinRow(){
        return this.bestWinRow;
    }

    int getWinRow(){
        return this.winRow;
    }
}

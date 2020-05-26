package game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@Entity
@Slf4j
public class Player {

    @Column(nullable = false)
    private final String playerName;
    private int games;
    private int wins;
    private int winRow;
    private int bestWinRow;

    public Player(String playerName){

        this.playerName = playerName;
        this.games = 0;
        this.wins = 0;
        this.winRow = 0;
        this.bestWinRow = 0;
    }
    public void WinGame() {
        this.games += 1;
        this.wins += 1;
        this.winRow += 1;
        if(winRow>bestWinRow){
            bestWinRow += 1;
        }
    }

    public void LoseGame(){
        this.games += 1;
        this.winRow = 0;
    }

    public int getGames(){
        return this.games;
    }

    public int getWins(){
        return  this.wins;
    }

    public int getBestWinRow(){
        return this.bestWinRow;
    }

    public int getWinRow(){
        return this.winRow;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Player createPlayer() {
        Player result = Player.builder()
                .playerName(playerName)
                .games(games)
                .wins(wins)
                .winRow(winRow)
                .bestWinRow(bestWinRow)
                .build();
        log.info("Player {} created.", playerName);
        return result;
    }
}

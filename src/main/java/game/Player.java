package game;

import lombok.*;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {
    /**
     * Stores the name of the player.
     */
    @Id
    @Column(nullable = false)
    private String playerName;
    /**
     * Store the number of the player's lifetime games.
     */
    @Column
    private int games;
    /**
     * Store the number of games where the player won.
     */
    @Column
    private int wins;
    /**
     * Store the number of wins in the last win row.
     */
    @Column
    private int winRow;
    /**
     * Store the number of wins in the best win row.
     */
    @Column
    private int bestWinRow;

    public Player(String playerName){

        this.playerName = playerName;
        this.games = 0;
        this.wins = 0;
        this.winRow = 0;
        this.bestWinRow = 0;
    }

    /**
     * Set the variables if the player wins.
     */
    public void WinGame() {
        this.games += 1;
        this.wins += 1;
        this.winRow += 1;
        if(winRow>bestWinRow){
            bestWinRow += 1;
        }
    }

    /**
     * Set the variables if the player lose.
     */
    public void LoseGame(){
        this.games += 1;
        this.winRow = 0;
    }

    /**
     * To get the number of the lifetime games.
     * @return the number of games
     */

    public int getGames(){
        return this.games;
    }

    /**
     * To get the number of the lifetime wins.
     * @return the number of wins
     */

    public int getWins(){
        return  this.wins;
    }

    /**
     * To get the value of the best row of wins.
     * @return the vaalue of the best win row
     */

    public int getBestWinRow(){
        return this.bestWinRow;
    }

    /**
     * To get the current win row.
     * @return the value of the current win row
     */

    public int getWinRow(){
        return this.winRow;
    }

    /**
     * To get the player name.
     * @return the name of the player
     */

    public String getPlayerName() {
        return this.playerName;
    }
}

package game;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

@Slf4j
public class Table {

 /**
  * This stores the count of the steps.
  */
 private static int move=1;

 /**
  * To write the current state of the table to the consol.
  */

 public static void cout() {
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 10; j++) {
    System.out.print(table[i][j]);
   }
   System.out.print("\n");
  }
 }

 /**
  * This method set the initial value of the table.
  */

 public static void setInitTable() {
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 10; j++) {
    table[i][j]=0;
   }
  }
 }

 /**
  * The array representing the current configuration of the tray.
  */

 public static int[][] table = new int[10][10];

 /**
  * To get the number of steps made by players.
  * @return the number of steps
  */

 public static int getMove() {
  return move;
 }

 /**
  * Increment {@code move} value by 1;
  */

 public static void newMove() {
  move += 1;
 }

 /**
  * It gets the number of the player who made the last move.
  * @return the number of the player
  */

 public static int getPlayerNum() {
  if(move%2==0)
   return 2;
  else
   return 1;
 }

 /**
  * Puts the next step to the cell that added by the player that added.
  * @param row The index of the table row where to take the next step.
  * @param column The index of the table column where to take the next step.
  * @param player The number of the player who tek the next step.
  */

 public static void put(int row, int column,int player){
  if (player == 1) {
   table[row][column] = 1;
  }
  else {
   table[row][column] = 2;
  }
 }

 /**
  * Checks that the table cell is available to put by the player or not. If the cell is available it calls the {@code put} method to take the step.
  * @param row The index of the table row where to check.
  * @param column The index of the table column where to check.
  * @param player The number of the player who take the next step to check.
  * @return true when the step was taken, false when the step can't be taken.
  */

 public static boolean available(int row, int column, int player) {
  if(player!=1 && player!=2 || row>9 || row<0 || column>9 || column<0)
   return false;
  if(table[row][column]==0) {
   put(row,column,player);
   return true;
  }
  else
   return false;
 }

 /**
  * Examines the board to see if it contains a winning position.
  * @return that which player win or 0 if no one has won
  */

 public static int check(){ //TODO: if the table is full draw
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 6; j++) {
    if (table[i][j] == 0)
     continue;
    else if (table[i][j] == 1 && table[i][j + 1] == 1 && table[i][j + 2] == 1 && table[i][j + 3] == 1 && table[i][j + 4] == 1)
     return 1;
    else if (table[i][j] == 2 && table[i][j + 1] == 2 && table[i][j + 2] == 2 && table[i][j + 3] == 2 && table[i][j + 4] == 2)
     return 2;
   }
  }

  for (int i = 0; i < 6; i++) {
   for (int j = 0; j < 10; j++) {
    if (table[i][j] == 0)
     continue;
    else if (table[i][j] == 1 && table[i + 1][j] == 1 && table[i + 2][j] == 1 && table[i + 3][j] == 1 && table[i + 4][j] == 1)
     return 1;
    else if (table[i][j] == 2 && table[i + 1][j] == 2 && table[i + 2][j] == 2 && table[i + 3][j] == 2 && table[i + 4][j] == 2)
     return 2;
   }
  }
  for (int i = 0; i < 6; i++) {
   for (int j = 0; j < 6; j++) {
    if (table[i][j] == 0)
     continue;
    else if (table[i][j] == 1 && table[i + 1][j + 1] == 1 && table[i + 2][j + 2] == 1 && table[i + 3][j + 3] == 1 && table[i + 4][j + 4] == 1)
     return 1;
    else if (table[i][j] == 2 && table[i + 1][j + 1] == 2 && table[i + 2][j + 2] == 2 && table[i + 3][j + 3] == 2 && table[i + 4][j + 4] == 2)
     return 2;
   }
  }
  for (int i = 4; i < 10; i++) {
   for (int j = 0; j < 6; j++) {
    if (table[i][j] == 0)
     continue;
    else if (table[i][j] == 1 && table[i - 1][j + 1] == 1 && table[i - 2][j + 2] == 1 && table[i - 3][j + 3] == 1 && table[i - 4][j + 4] == 1)
     return 1;
    else if (table[i][j] == 2 && table[i - 1][j + 1] == 2 && table[i - 2][j + 2] == 2 && table[i - 3][j + 3] == 2 && table[i - 4][j + 4] == 2)
     return 2;
   }
  }
  return 0;
 }

 public static boolean fullTable() {
  for(int i=0;i<10;i++) {
   for (int j=0;j<10;j++) {
    if(table[i][j]==0)
     return false;
   }
  }
  return true;
 }

}

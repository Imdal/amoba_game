package game;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

@Slf4j
public class Table {
 private static int move;
 private static int size;
 private static int[][] table;

// public Table(){
//  table = new int[10][10];
//  for (int i = 0; i < 10; i++) {
//   for (int j = 0; j < 10; j++) {
//    table[i][j] = 0;
//   }
//  }
//  this.move = 0;
// }
//
// public Table(int size){
//  table=new int[size][size];
//  for (int i = 0; i < size; i++) {
//   for (int j = 0; j < size; j++) {
//    table[i][j] = 0;
//   }
//  }
//  this.move = 0;
// }

 public static void cout() {
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 10; j++) {
    System.out.print(table[i][j]);
   }
   System.out.print("\n");
  }
 }

 public static void tableInit() {
  table = new int[10][10];
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 10; j++) {
    table[i][j] = 0;
   }
  }
  move = 1;
 }

 public static int getMove() {
  return move;
 }

 public static void newMove() {
  move += 1;
 }

 public static int getSize() {
  return size;
 }

 public static int getPlayerNum() {
  if(move%2==0)
   return 2;
  else
   return 1;
 }

 public static void put(int row, int column,int player){
  if (player == 1) {
   table[row][column] = 1;
  }
  else {
   table[row][column] = 2;
  }
 }

 public static boolean available(int row, int column, int player) {
  if(table[row][column]==0) {
   put(row,column,player);
   return true;
  }
  else
   return false;
 }

 public static int currentState(int row, int column) {
  return table[row][column];
 }


 public static int check(){
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

  }


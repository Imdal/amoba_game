import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Table {
 private int[][] table = new int[10][10];

 Table(){
  for (int i = 0; i < 10; i++) {
   for (int j = 0; j < 10; j++) {
    table[i][j] = 0;
   }
  }
 }

 Table(int size){
  for (int i = 0; i < size; i++) {
   for (int j = 0; j < size; j++) {
    table[i][j] = 0;
   }
  }
 }

 public void Put(int row, int column,int player){
  if (player == 1) {
   table[row][column] = 1;
  }
  else {
   table[row][column] = 2;
  }
 }


 public int check(){
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


import java.io.*;
import java.util.*;
public class USACO{
  private static int row = 0; //To initialize the field
  private static int col = 0; //To initialize the field
  private static int[][] field;

  public static int bronze(String filename){
    try{
      int inforow = 0; //To initialize the array storing the instructions
      int elevation = 0;
      int[][] info;

      //Basic info from the text file
      File f = new File(filename);
      Scanner s = new Scanner(f);
      String temp = s.nextLine();
      String[] test = temp.split(" ");
      row = Integer.parseInt(test[0]);
      col = Integer.parseInt(test[1]);
      elevation = Integer.parseInt(test[2]);
      inforow = Integer.parseInt(test[3]);
      field = new int[row][col];
      info = new int[inforow][3];

      //Fill out the info for the field
      for (int r = 0; r < row; r ++){
        String line = s.nextLine();
        String[] lineinfo = line.split(" ");
        for (int c = 0; c < col; c ++){
          field[r][c] = Integer.parseInt(lineinfo[c]);
        }
      }

      //Fill out the instructions
      for (int r = 0; r < inforow; r ++){
        String line = s.nextLine();
        String[] lineinfo = line.split(" ");
        for (int c = 0; c < 3; c ++){
          info[r][c] = Integer.parseInt(lineinfo[c]);
        }
      }
      s.close();

      for (int count = 0; count < inforow; count ++){
        int srow = info[count][0] - 1;
        int scol = info[count][1] - 1;
        int sdepth = info[count][2];
        stomp(srow, scol, sdepth, field);
      }
    }
    catch (FileNotFoundException e){}
    return -1;
  }

  private static void stomp(int row, int col, int depth, int[][] field){

    //Loop through to find the highest value on the the map (within the square)
    int high = 0;
    for (int r = row; r < row + 3; r ++){
      for (int c = col; c < col + 3; c ++){
        if (field[r][c] > high){
          high = field[r][c];
        }
      }
    }

    //Set goal to the highest possible value
    int goal = high - depth;
    //Loop through the area and set all the values greater than the goal to the
    //goal value
    for (int r = row; r < row + 3; r ++){
      for (int c = col; c < col + 3; c ++){
        if (field[r][c] > goal){
          field[r][c] = goal;
        }
      }
    }

  }

  public String toString(){
    String ans = "";
    for (int r = 0; r < row; r ++){
      for (int c = 0; c < col; c ++){
        ans = ans + field[r][c] + " ";
      }
      ans += "\n";
    }
    return ans;
  }
  public static void main(String[] args){
    System.out.println(bronze("makelake.1.in"));
  }
}

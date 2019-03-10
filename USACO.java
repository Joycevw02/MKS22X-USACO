import java.io.*;
import java.util.*;
public class USACO{

  public static int bronze(String filename){
    try{
      int row = 0; //To initialize the field
      int col = 0; //To initialize the field
      int[][] field;
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

      //Carry out the instructions
      for (int count = 0; count < inforow; count ++){
        int srow = info[count][0] - 1;
        int scol = info[count][1] - 1;
        int sdepth = info[count][2];
        stomp(srow, scol, sdepth, field);
      }

      //Return the volume of the lake
      int ans = 0;
      for (int r = 0; r < row; r ++){
        for (int c = 0; c < col; c ++){
          field[r][c] = elevation - field[r][c];
          if (field[r][c] > 0){
            ans += field[r][c];
          }
        }
      }
      ans = ans * 72 * 72;
      return ans;
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


  public static int silver(String filename){
    try{
      int[][] field;
      int[][] moves = {{1,0},{-1,0},{0,-1},{0,1}};
      int row = 0; //To initialize the field
      int col = 0; //To initialize the field
      int timer = 0; //Timer
      int r1 = 0; //Starting row
      int r2 = 0; //Ending row
      int c1 = 0; //Starting col
      int c2 = 0; //Ending col

      //Basic information from the file
      File f = new File(filename);
      Scanner s = new Scanner(f);
      String temp = s.nextLine();
      String[] info = temp.split(" ");
      row = Integer.parseInt(info[0]);
      col = Integer.parseInt(info[1]);
      timer = Integer.parseInt(info[2]);
      field = new int[row][col];

      //Fills out the field (If it is open pasture, the value is 0 and if it is
      //a tree, then the value is -1)
      for (int r = 0; r < row; r ++){
        String line = s.nextLine();
        String[] lineinfo = line.split(" ");
        for (int c = 0; c < col; c ++){
          if (line.charAt(c) == '.'){
            field[r][c] = 0;
          }
          else{
            field[r][c] = -1;
          }
        }
      }

      //The starting and ending positions
      temp = s.nextLine();
      info = temp.split(" ");
      r1 = Integer.parseInt(info[0]) - 1;
      c1 = Integer.parseInt(info[1]) - 1;
      r2 = Integer.parseInt(info[2]) - 1;
      c2 = Integer.parseInt(info[3]) - 1;

      s.close();

    }
    catch (FileNotFoundException e){}
    return -1;
  }

  private static int help(int startr, int startc, int endr, int endc, int ans, int timer, int[][] field){
    return ans;
  }

  public static void main(String[] args){
    //System.out.println(bronze("makelake.1.in")); //342144
    //System.out.println(bronze("makelake.2.in")); //102762432
    //System.out.println(bronze("makelake.3.in")); //1058992704
    //System.out.println(bronze("makelake.4.in")); //753121152
    //System.out.println(bronze("makelake.5.in")); //1028282688
    System.out.println(silver("ctravel.1.in"));
  }
}

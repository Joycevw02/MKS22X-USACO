import java.io.*;
import java.util.*;
public class USACO{

  public static int bronze(String filename){
    try{
      int row = 0; //To initialize the field
      int col = 0; //To initialize the field
      int inforow = 0; //To initialize the array storing the instructions
      int elevation = 0;
      int[][] field;
      int[][] info;

      File f = new File(filename);
      Scanner s = new Scanner(f);
      String temp = s.nextLine();
      String[] test = temp.split(" ");
      row = Integer.parseInt(test[0]);
      col = Integer.parseInt(test[1]);
      inforow = Integer.parseInt(test[2]);
      field = new int[row][col];
      info = new int[inforow][3];

      int r = 0;
      while (s.hasNextLine()){
        String line = s.nextLine();
        //System.out.println(line);
        String[] lineinfo = line.split(" ");
        if (r < row){
          for (int c = 0; c < col; c ++){
            field[r][c] = Integer.parseInt(lineinfo[c]);
            //System.out.println(field);
          }
          r ++;
        }
        else{
          for (int c = 0; c < 3; c ++){
            info[r][c] = Integer.parseInt(lineinfo[c]);
            //System.out.println(info[r][c]);
          }
          r ++;
        }
      }
      s.close();
    }
    catch (FileNotFoundException e){}
      return -1;
  }

  private static void stomp(int row, int col, int depth){


  }

  public static void main(String[] args){
    System.out.println(bronze("makelake.1.in"));
  }
}

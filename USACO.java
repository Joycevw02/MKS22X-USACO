import java.io.*;
import java.util.*;
public class USACO{

  public static int bronze(String filename){
    try{
      int row = 0; //To initialize the field
      int col = 0; //To initialize the field
      int inforow = 0; //To initialize the array storing the instructions
      int elevation = 0;
      String[][] field;
      int[][] info;

      //Basic info from the text file
      File f = new File(filename);
      Scanner s = new Scanner(f);
      String temp = s.nextLine();
      String[] test = temp.split(" ");
      row = Integer.parseInt(test[0]);
      col = Integer.parseInt(test[1]);
      inforow = Integer.parseInt(test[2]);
      field = new String[row][col];
      info = new int[inforow][3];

      int r = 0;
      while (s.hasNextLine()){
        String line = s.nextLine();
        //System.out.println(line);
        String[] lineinfo = line.split(" ");
        //If r < row (meaning that it is in the field's data), add the data into
        //the int array
        if (r < row){
          for (int c = 0; c < col; c ++){
            field[r][c] = lineinfo[c];
            //System.out.println(field);
          }
          r ++;
        }
        //If not, it would be in the instructions
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

  private static void stomp(int row, int col, int depth, String[][] field){

    //Loop through to find the highest area in the the map (within the square)
    int highrow = 0;
    int highcol = 0;
    int high = 0;
    for (int r = row; r < 3; r ++){
      for (int c = col; c < 3; c ++){
        if (Integer.parseInt(field[r][c]) > high){
          highrow = r;
          highcol = c;
          high = Integer.parseInt(field[r][c]);
        }
      }
    }

    //Set temp to the highest because...too lazy to type repeatedly
    int temp = Integer.parseInt(field[highrow][highcol]);
    //If temp minus the depth is greater than 0, set the value at the field to
    //the value minus the depth. Then, loop through the square and if any value
    //is greater than the target (highest value - depth), then change it to the
    //target value
    if (temp - depth > 0){
      field[highrow][highcol] = temp - depth + "";
      int target = temp - depth;
      for (int r = row; r < 3; r ++){
        for (int c = col; c < 3; c ++){
          if (Integer.parseInt(field[r][c]) > target){
            field[r][c] = target + "";
          }
        }
      }
    }
    //Else, loop through the square and change them all to --, because none of
    //the values should be less than 0.
    else{
      field[highrow][highcol] = "--";
      for (int r = row; r < 3; r ++){
        for (int c = col; c < 3; c ++){
          field[r][c] = "--";
        }
      }
    }
  }

  public static void main(String[] args){
    System.out.println(bronze("makelake.1.in"));
  }
}

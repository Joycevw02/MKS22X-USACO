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
      row = Integer.parseInt(temp.substring(0,1));
      col = Integer.parseInt(temp.substring(1,2));
      inforow = Integer.parseInt(temp.substring(3,4));
      field = new int[row][col];
      info = new int[inforow][3];

    }
    catch (FileNotFoundException e){}
  }
}

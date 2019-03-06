import java.io.*;
import java.util.*;
public class USACO{

  public static int bronze(String filename){
    try{
      int row = 0;
      int col = 0;
      int coltemp = 0;
      int elevation = 0;
      int[][] field;
      File f = new File(filename);
      Scanner count = new Scanner(f);
      while (count.hasNextLine()){
        row ++;
        String temp = count.nextLine();
        coltemp = 0;
        for (int i = 0; i < temp.length(); i ++){
          coltemp ++;
        }
        if (coltemp > col){
          col = coltemp;
        }
      }
    }
    catch (FileNotFoundException e){}
  }
}

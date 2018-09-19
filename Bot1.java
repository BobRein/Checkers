import java.util.*;
public class Bot1
{
public static int a,b,c,d,value=0;
public static int [] cord =new int [4];
public static int [] newJump =new int [2];
        public static int [] getMove (Piece [][] data, int team)
    {
         value =0;
        for (int w=0; w<8;w++)
          {
              for (int x =0; x<8; x++)
              {
                  if (data [w] [x] != null && data [w][x].getTeam ()== team)
                  {
                      for (int y=0; y<8; y++)
                      { 
                          for (int z=0;z<8; z++)
                          {
                              if (Math.abs (y-w)<3 && Math.abs(z-x)<3 && value < Piece.moveType (data, w,x,y,z))
                              {
                                  value = Piece.moveType (data, w,x,y,z);
                                  cord [0]=w;
                                  cord [1]=x;
                                  cord [2]=y;
                                  cord [3]=z;
                              }
                            }
                        }
                    }
                }
           }
            return cord;  
    }
    public static int [] getNextJump (Piece [][] data, int a, int b)
    {
        newJump [0] = 0;
        newJump [1]= 0;
                for (int y=0; y<8; y++)
                      { 
                          for (int z=0;z<8; z++)
                          {
                              
                              if (2== Piece.moveType (data, a,b,y,z))
                              {
                                  newJump [0]=y;
                                  newJump [1]=z;
                              }
                              
                            }
                        }        
        return newJump;
    }
}

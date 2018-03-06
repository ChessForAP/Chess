
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private Chess[][] table=new Chess[8][8];
    public Board(){
        
        for(int i=0;i<8;i++){
            table[1][i]=Pawn.create("W");
            table[6][i]=Pawn.create("B");
            for(int j=2;j<6;j++){
                table[j][i]=new Chess();
            }
        }
        table[0][0]=Rook.create("W");
        table[0][7]=Rook.create("W");
        table[7][0]=Rook.create("B");
        table[7][7]=Rook.create("B");
        table[0][1]=Knight.create("W");
        table[0][6]=Knight.create("W");
        table[7][1]=Knight.create("B");
        table[7][6]=Knight.create("B");
        table[0][2]=Bishop.create("W");
        table[0][5]=Bishop.create("W");
        table[7][2]=Bishop.create("B");
        table[7][5]=Bishop.create("B");
        table[0][3]=Queen.create("W");
        table[7][3]=Queen.create("B");
        table[0][4]=Queen.create("W");
        table[7][4]=Queen.create("B");
    }
    public void printOut(){
        for(int i=0;i<8;i++){
            System.out.print((8-i)+"   ");
            for(int j=0;j<8;j++){
                System.out.print(table[7-i][j]);
            }
            System.out.println();
            System.out.println();
        }
        System.out.print("    ");
        for(int i=65;i<73;i++){
            System.out.print((char)i);
            System.out.print("      ");
        }
    }
}

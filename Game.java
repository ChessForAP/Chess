
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//upload by Violet Yu--Zoe Du--Yolanda Su--Violet Yu--Kevin Jiang--Yolanda Su
import java.util.*;
public class Game
{
    Player player1;
    Player player2;
    Board table;
    public  Game() throws Exception{
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter the name of User1 :");
        player1= new Player("W",scanner1.next());
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter the name of User2 :");
        player2= new Player("B",scanner2.next());
        table=new Board();
        while(true){
            printOutBoard();
            move(player1);
            if(table.getEvolve()){
                Scanner scanner = new Scanner(System.in);
                System.out.println("change this Pawn to(rook or queen or knight or bishop):");
                String change=scanner.next();
                table.evolve(change);
            }
            printOutBoard();
            move(player2);
            if(table.getEvolve()){
                Scanner condition = new Scanner(System.in);
                Scanner scanner = new Scanner(System.in);
                table.evolve(scanner.next());
            }
        }
    }
    public void move(Player player) throws Exception{
        Scanner condition = new Scanner(System.in);
        System.out.println("");
        System.out.println(player.getName()+" move piece at:");
        String str1=condition.next();
        condition = new Scanner(System.in);
        System.out.println("to place:");
        String str2=condition.next();
        try{
            player.move(str1,str2);
        }
        catch(Exception e){
            System.out.println("illegal moving");
            move(player);
        }
        
    }
    public void printOutBoard(){
        Piece[][] board=table.getBoard();
        for(int i=0;i<8;i++){
            System.out.print((8-i)+"   ");
            for(int j=0;j<8;j++){
                if(board[7-i][j]==null)
                {
                    System.out.print("       ");
                }
                else{
                    System.out.print(board[7-i][j]);
                }
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




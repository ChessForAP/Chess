import java.util.*;
public class Game
{
    Player player1;
    Player player2;
    Board table;
    public  Game(){
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
            printOutBoard();
            move(player2);
        }
    }
    public void move(Player player){
        Scanner condition = new Scanner(System.in);
        System.out.println("");
        System.out.println(player.getName()+" move piece at:");
        String str1=condition.next();
        condition = new Scanner(System.in);
        System.out.println("to place:");
        String str2=condition.next();
        player.move(str1,str2);
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

import java.util.*;
public class Game
{
    public void game(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter the name of User1 :");
        Player player1= new Player("W",scanner1.next());
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter the name of User2 :");
        Player player2= new Player("B",scanner2.next());
        Board table=new Board();
        while(true){
            table.printOut();
            move(table,player1);
            table.printOut();
            move(table,player2);
        }
    }
    private void move(Board table, Player player){
        Scanner condition = new Scanner(System.in);
        System.out.println(player.getName()+":");
        String str=condition.next();
        table.move(str.substring(0,2),str.substring(3,5),player.getColor());
    }
}

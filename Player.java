import java.util.*;
public class Player
{
    private String color;
    private String name;
    public Player(String color,String name)
    {
        this.color=color;
        this.name=name;
    }
    public String getColor()
    {
        return this.color;
    }
    public String getName(){
        return this.name;
    }
    public void move(Board table){
        Scanner condition = new Scanner(System.in);
        System.out.println(name+":");
        String str=condition.next();
        table.move(str.substring(0,2),str.substring(3,5),color);
    }
}
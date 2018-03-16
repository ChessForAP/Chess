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
    public void move(String str1,String str2){
        Board.move(str1,str2);
    }
}
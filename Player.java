//upload by Kevin Jiang--Violet Yu---Zoe Du
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
    public void move(String str1,String str2) throws Exception{
        try{
            Board.move(str1,str2);
        }
        catch(MyException e){
            throw new MyException();
        }
        catch(MoveException e){
            throw new MoveException();
        }
        catch(KillException e){
            throw new KillException();
        }
        catch(CheckException e){
            throw new CheckException();
        }
    }
}
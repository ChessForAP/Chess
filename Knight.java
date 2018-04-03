 
/**
 * Write a description of class Knight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//upload by Zoe Du--Yolanda Su
public class Knight extends Piece
{
    private int x;
    private int y;
    private String color;
    private Knight(String color,int x,int y)
    {
        this.color=color;
        Piece.num+=1;
        this.x=x;
        this.y=y;
    }
    public String getColor(){
        return color;
    }
    public String toString()
    {
        return color+"Kn    ";
    }
    public static Knight create(String color,int x,int y)
    {
        if(checkNum())
        {
            return new Knight(color,x,y);
        }
        else
        {
            throw new Error("more than 32");
        }
    }
    public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(Math.abs(this.x-x)==2 && Math.abs(y-this.y)==1){
                    this.x=x;
                    this.y=y;
            }
            else if(Math.abs(this.x-x)==1 && Math.abs(y-this.y)==2){
                    this.x=x;
                    this.y=y;
            }
            else{
                throw new Exception();
            }
        }
        else{
            throw new Error("out of table");
        }
    }
    public int kill(int x,int y,String color){
        if(this.color.equals(color)){
            return 1;
        }
        if(this.x-x==this.y-y || this.x-x==y-this.y){
                return 2;
            }
            else{
                return 1;
            }
    }
}

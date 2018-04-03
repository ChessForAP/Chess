
/**
 * Write a description of class Bishop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//upload by all of as--Zoe Du--Yolanda Su--Carol Li--Yolanda Su
public class Bishop extends Piece
{
    private String color;
    private int x;
    private int y;
    private Bishop(String color,int x,int y)
   {
        this.color=color;
        this.x=x;
        this.y=y;
        Piece.num+=1;
   }
   public String getColor(){
        return color;
    }
   public String toString()
   {
        return color+"B     ";
   }
   public static Bishop create(String color,int x,int y)
   {
        if(checkNum())
        {
            return new Bishop(color,x,y);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x-x==this.y-y || this.x-x==y-this.y)
            {
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
    public int kill(int x, int y,String color){
        if(this.color.equals(color)){
            return 1;
        }
        if(Math.abs(this.x-x)==2 || Math.abs(y-this.y)==1){
                return 2;
            }
            else if(Math.abs(this.x-x)==1 || Math.abs(y-this.y)==2){
                return 2;
            }
            else{
                return 1;
            }
    }
}


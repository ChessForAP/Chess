
/**
 * Write a description of class Queen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//upload by Violet Yu--Kevin Jiang--Violet Yu--Carol Li--Yolanda Su
public class Queen extends Piece
{
   private int x;
   private int y;
   private String color;
   private Queen(String color,int x,int y)
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
        return color+"Q     ";
   }
   public static Queen create(String color,int x,int y)
   {
       if(checkNum())
        {
            return new Queen(color,x,y);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x-x==this.y-y || this.x-x==y-this.y){
                this.x=x;
                this.y=y;
            }
            else if(this.x==x || this.y==y){
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
        else if(this.x==x || this.y==y){
            return 2;
        }
        else{
            return 1;
        }
    }
}

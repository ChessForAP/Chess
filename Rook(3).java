//upload by Zoe Du--Kevin Jiang--Violet Yu---Zoe Du--Carol Li
public class Rook extends Piece
{
    private String color;
    private int x;
    private int y;
    private Rook(String color,int x)
   {
       this.color=color;
       if(color.equals("W")){
            this.y=0;
        }
        else{
            this.y=7;
        }
       super.num+=1;
       this.x=x;
   }
   public String getColor(){
        return color;
    }
   public String toString()
   {
        return this.color+"R     ";
   }
   public static Rook create(String color,int x)
   {
        if(checkNum())
        {
            return new Rook(color,x);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x==x || this.y==y){
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
}

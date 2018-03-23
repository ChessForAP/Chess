//upload by Violet Yu--Kevin Jiang--Zoe Du--Carol Li
public class King extends Piece
{
   private int x;
   private int y;
   private String color;
   private King(String color,int x)
   {
       this.color= color;
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
        return color+"Ki    ";
   }
   public static King create(String color,int x)
   {
        if(checkNum())
        {
            return new King(color,x);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(Math.abs(this.x-x)==1 || Math.abs(this.y-y)==1){
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
//upload by Zoe Du--Kevin Jiang--Violet Yu---Zoe Du--Carol Li--Kevin Jiang--Violet Yu
public class Rook extends Piece
{
    private String color;
    private int x;
    private int y;
    private boolean var=true;
    private Rook(String color,int x,int y)
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
        return this.color+"R     ";
   }
   public static Rook create(String color,int x,int y)
   {
        if(checkNum())
        {
            return new Rook(color,x,y);
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
                var=true;
            }
            else{
                throw new Exception();
            }
        }
        else{
            throw new Error("out of table");
        }
    }
    public boolean castling(){
        return var;
    }
    public void move(String dir){
        if(dir.equals("left")){
            this.x=3;
        }
        else{
            this.x=5;
        }
    }
}

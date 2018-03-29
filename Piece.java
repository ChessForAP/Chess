//upload by Zoe Du--Violet Yu---Zoe Du--Yolanda Su--Kevin Jiang--Yolanda Su--Kevin Jiang--Violet Yu
public abstract class Piece
{
    private String color;
    private int x;
    private int y;
    protected static int num=0;
    Piece(){
    }
    public abstract String toString();
    public abstract String getColor();
    public abstract void setPosition(int x,int y) throws Exception;
    public static boolean checkNum(){
        
        if(num<32){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean evolve(){
        return false;
    }
    public int kill(int x,int y,String color)throws Exception{
        return 0;
    }
    public boolean castling(){
        return false;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean checkFrount(){
        return false;
    }
    public void die() throws Exception{
        throw new Exception();
    }
    public void move(String dir){
        throw new Error("only King/Rook");
    }
}
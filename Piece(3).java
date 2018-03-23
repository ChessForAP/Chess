//upload by Zoe Du--Violet Yu---Zoe Du--Yolanda Su
public abstract class Piece
{
    private String color;
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
    public int kill(int x,int y,String color)throws Exception{
        
        return 0;
    }
    
    public boolean checkFrount(){
        return false;
    }
}
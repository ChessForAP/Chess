public abstract class Piece
{
    private String color="none";
    protected static int num=0;
    Piece(){
    }
    public abstract String toString();
    public abstract void setPosition(int x,int y);
    public static boolean checkNum(){
        
        if(num<32){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getColor(){
        return this.color;
    }
    public int kill(int x,int y,String color){
        return 1;
    }
    
    public boolean checkfrount(int x,int y){
        return false;
    }
}
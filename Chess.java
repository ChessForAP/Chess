public class Chess
{
    private String color;
    protected static int num=0;
    Chess(){
        
        
    }
    public static boolean checkNum(){
        
        if(num<32){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "       ";
    }
    
}
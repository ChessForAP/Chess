public class Knight extends Chess
{
    private int x;
    private int y;
    private String color;
    private Knight(String color)
    {
        this.color=color;
        super.num+=1;
    }
    public String toString()
    {
        return color+"Kn    ";
    }
    public static Knight create(String color)
    {
        if(checkNum())
        {
            return new Knight(color);
        }
        else
        {
            throw new Error("more than 32");
        }
    }
}
